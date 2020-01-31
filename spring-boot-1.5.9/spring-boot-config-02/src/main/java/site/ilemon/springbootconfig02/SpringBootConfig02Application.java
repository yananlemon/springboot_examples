package site.ilemon.springbootconfig02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootConfig02Application {

    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConfig02Application.class, args);
    }

}
