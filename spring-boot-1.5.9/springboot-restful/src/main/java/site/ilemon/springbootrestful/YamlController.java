package site.ilemon.springbootrestful;

import org.springframework.web.bind.annotation.*;
import site.ilemon.springbootrestful.model.Customer;

@RestController
@RequestMapping(value = "/customer")
public class YamlController {


    /**
     * 获取 customer
     *
     * @return List<Customer>
     */
    @RequestMapping(value = "/customer/{id}", consumes = "application/yaml", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable(name = "id") String id) {
        return new Customer("Andy", "Yan", 19);
    }

    /**
     * 创建一个 customer
     *
     * @return List<Customer>
     */
    @RequestMapping(value = "/customer",
            consumes = "application/yaml",
            produces = "application/yaml",
            method = RequestMethod.POST)
    public Customer createCustomer(@RequestBody Customer customer) {
        return customer;
    }
}
