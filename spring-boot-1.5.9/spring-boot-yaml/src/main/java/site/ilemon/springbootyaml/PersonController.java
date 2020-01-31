package site.ilemon.springbootyaml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private Person person;

    @GetMapping("/person")
    public Person attainPerson(){
        return person;
    }
}
