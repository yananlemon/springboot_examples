package site.ilemon.springboot.springboothelloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.ilemon.autoconfigurer.HelloService;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        return "hello,Andy!";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return helloService.sayHello("Andy");
    }

}
