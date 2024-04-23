package cn.cactusli.dev.tech.dubbo.consumer;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * Package: cn.cactusli.dev.tech.dubbo.consumer
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/4/22 11:25
 * @Github https://github.com/lixuanfengs
 */
@SpringBootApplication
@Configuration
public class Application {

        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }
}
