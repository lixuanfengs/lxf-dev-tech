package cn.cactusli.lxf.dev.tech.config;

import cn.cactusli.lxf.dev.tech.plugin.FieldEncryptionAndDecryptionMybatisPlugin;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Package: cn.cactusli.lxf.dev.tech.config
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/4/19 9:54
 * @Github https://github.com/lixuanfengs
 */
@Configuration
public class PluginAutoConfiguration {

    @Bean
    public Interceptor plugin() {
        return new FieldEncryptionAndDecryptionMybatisPlugin();
    }

}
