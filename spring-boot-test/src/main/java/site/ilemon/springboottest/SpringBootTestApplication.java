package site.ilemon.springboottest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"site.ilemon.springboottest"})
public class SpringBootTestApplication {

    public static void main(String[] args) {
        System.out.println("加载当前类的类加载器："+SpringBootTestApplication.class.getClassLoader());
        SpringApplication.run(SpringBootTestApplication.class, args);
    }

}
