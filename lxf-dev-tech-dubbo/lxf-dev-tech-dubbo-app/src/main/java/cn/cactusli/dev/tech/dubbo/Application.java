package cn.cactusli.dev.tech.dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Package: cn.cactusli.dev.tech.dubbo
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/4/22 11:10
 * @Github https://github.com/lixuanfengs
 */
@SpringBootApplication
@Configurable
@EnableDubbo
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
