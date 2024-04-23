package cn.cactusli.dev.tech.dubbo.consumer.test;

import cn.cactusli.dev.tech.dubbo.api.IUserService;
import cn.cactusli.dev.tech.dubbo.api.dto.UserReqDTO;
import cn.cactusli.dev.tech.dubbo.api.dto.UserResDTO;
import cn.cactusli.dev.tech.dubbo.api.types.Response;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Package: cn.cactusli.dev.tech.dubbo.consumer.test
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/4/22 11:35
 * @Github https://github.com/lixuanfengs
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    // 测试使用直连模式；
    // @DubboReference(interfaceClass = IUserService.class, url = "dubbo://127.0.0.1:20881", version = "1.0.0")
    // 测试注册中心模式；需要配置 Zookeeper
    @DubboReference(interfaceClass = IUserService.class, version = "1.0.0")
    private IUserService userService;

    @Resource(name = "rpcProxyBeanFactory")
    private IUserService proxyUserService;

    @Test
    public void test_userService() {
        UserReqDTO reqDTO = UserReqDTO.builder().userId("10001").build();
        Response<UserResDTO> resDTO = userService.queryUserInfo(reqDTO);
        log.info("测试结果 req: {} res: {}", JSON.toJSONString(reqDTO), JSON.toJSONString(resDTO));
    }

    @Test
    public void test_proxyUserService(){
        UserReqDTO reqDTO = UserReqDTO.builder().userId("10001").build();
        Response<UserResDTO> resDTO = proxyUserService.queryUserInfo(reqDTO);
        log.info("测试结果 req: {} res: {}", JSON.toJSONString(reqDTO), JSON.toJSONString(resDTO));
    }

}
