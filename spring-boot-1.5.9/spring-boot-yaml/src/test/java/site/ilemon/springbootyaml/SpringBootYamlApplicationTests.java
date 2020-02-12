package site.ilemon.springbootyaml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import site.ilemon.springbootyaml.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootYamlApplicationTests {

    @Autowired
    private Person person;

    @Autowired
    private TestPropertiesBind testPropertiesBind;


    @Autowired
    private TestPropertiesBind2 testPropertiesBind2;

    @Autowired
    private TestProSource testPropertySource;
    @Autowired
    IUserService userService;

    @Autowired
    ApplicationContext ioc;

    @Test
    public void testBean() {
        IUserService service = (IUserService) ioc.getBean("userService");
        Assert.notNull(service);
    }

    @Test
    public void testBean2() {
        Assert.notNull(userService);
    }

    @Test
    public void contextLoads() {
        System.out.println(person);
    }

    @Test
    public void testPropertiesBind() {
        System.out.println(testPropertiesBind);
    }

    @Test
    public void testPropertiesBind2() {
        System.out.println(testPropertiesBind2);
    }

    @Test
    public void testPropertySource() {
        System.out.println(testPropertySource);
    }

    @Autowired
    private Placeholder placeholder;

    @Test
    public void testPlaceholder() {
        System.out.println(placeholder);
    }

}
