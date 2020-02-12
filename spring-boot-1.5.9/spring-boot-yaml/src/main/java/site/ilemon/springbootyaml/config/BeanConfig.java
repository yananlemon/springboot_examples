package site.ilemon.springbootyaml.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import site.ilemon.springbootyaml.service.impl.UserServiceImpl;

/**
 * 使用@Configuration注解来标注一个类，相当于
 * <beans></beans>
 * 配置文件，
 * 在标签内部使用<bean></bean>相当于在配置类中使用@Bean注解
 */
@Configuration
public class BeanConfig {

    @Bean
    public UserServiceImpl userService() {
        return new UserServiceImpl();
    }
}
