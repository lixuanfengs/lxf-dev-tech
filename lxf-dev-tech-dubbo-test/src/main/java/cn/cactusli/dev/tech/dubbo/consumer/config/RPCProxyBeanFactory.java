package cn.cactusli.dev.tech.dubbo.consumer.config;

import cn.cactusli.dev.tech.dubbo.api.IUserService;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Package: cn.cactusli.dev.tech.dubbo.consumer.config
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/4/22 11:26
 * @Github https://github.com/lixuanfengs
 */
@Slf4j
@Component("rpcProxyBeanFactory")
public class RPCProxyBeanFactory implements FactoryBean<IUserService>, Runnable {

    private Channel channel;

    // 缓存数据，实际RPC会对每次的调用生成一个ID来标记获取
    private Object responseCache;

    @Override
    public IUserService getObject() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] classes = {IUserService.class};
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (Object.class.equals(method.getDeclaringClass())) {
                    return method.invoke(this, args);
                }
                Map<String, Object> request = new HashMap<>();
                request.put("clazz", IUserService.class);
                request.put("methodName", method.getName());
                request.put("paramTypes", method.getParameterTypes());
                request.put("args", args);

                channel.writeAndFlush(request);
                // 模拟超时等待，一般RPC接口请求，都有一个超时等待时长。
                Thread.sleep(500);
                return responseCache;
            }
        };
        return (IUserService) Proxy.newProxyInstance(classLoader, classes, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserService.class;
    }

    public RPCProxyBeanFactory() throws InterruptedException {
        new Thread(this).start();
        while (null == channel) {
            Thread.sleep(550);
            log.info("Rpc Socket 链接等待，需要启动 lxf-dev-tech-dubbo 默认提供 127.0.0.1:22881 链接地址...");
        }
    }

    @Override
    public void run() {
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.AUTO_READ, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            channel.pipeline().addLast(new ObjectEncoder());
                            channel.pipeline().addLast(new ObjectDecoder(ClassResolvers.cacheDisabled(null)));
                            channel.pipeline().addLast(new SimpleChannelInboundHandler<Map<String, Object>>() {
                                @Override
                                protected void channelRead0(ChannelHandlerContext channelHandlerContext, Map<String, Object> data) throws Exception {
                                    responseCache = data.get("data");
                                }
                            });
                        }
                    });
            ChannelFuture channelFuture = b.connect("127.0.0.1", 22881).syncUninterruptibly();
            this.channel = channelFuture.channel();
            channelFuture.channel().closeFuture().syncUninterruptibly();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
