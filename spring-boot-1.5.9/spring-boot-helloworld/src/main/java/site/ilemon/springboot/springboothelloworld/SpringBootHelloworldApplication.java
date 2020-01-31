package site.ilemon.springboot.springboothelloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 注解用来标注一个主程序类，说明这是一个Spring Boot应用。
 */
@SpringBootApplication
public class SpringBootHelloworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloworldApplication.class, args);
    }

}
