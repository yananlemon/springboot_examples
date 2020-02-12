package site.ilemon.springbootrestful;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @GetMapping("/test")
    public String test(Map<String, Object> map) {
        map.put("hello", "<h4>hello</h4>");
        map.put("technologies", Arrays.asList("SpringBoot", "Struts"));
        return "hello";
    }
}
