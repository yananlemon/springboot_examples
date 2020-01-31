package site.ilemon.springbootconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootConfigApplication {

    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConfigApplication.class, args);
    }

}
