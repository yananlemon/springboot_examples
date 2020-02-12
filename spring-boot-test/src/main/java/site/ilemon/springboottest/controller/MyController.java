package site.ilemon.springboottest.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.ilemon.springboottest.domain.Person;

import java.util.Date;

@RestController
@RequestMapping(value = "/api")
public class MyController {

    @GetMapping(path = "/person/{id}")
    public Person getPerson(@PathVariable("id") int id){
        Person person = new Person();
        person.setId(id);
        person.setName("Sam");
        person.setBirthday(new Date());
        return person;
    }
}
