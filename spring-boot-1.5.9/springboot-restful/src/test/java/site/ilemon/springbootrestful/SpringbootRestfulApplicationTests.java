package site.ilemon.springbootrestful;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.yaml.snakeyaml.Yaml;
import site.ilemon.springbootrestful.model.Customer;

@SpringBootTest
public class SpringbootRestfulApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testYaml() {
        Customer c = new Customer("Andy", "Yan", 19);

        Yaml yaml = new Yaml();
        System.out.println(yaml.dump(c));
    }
}
