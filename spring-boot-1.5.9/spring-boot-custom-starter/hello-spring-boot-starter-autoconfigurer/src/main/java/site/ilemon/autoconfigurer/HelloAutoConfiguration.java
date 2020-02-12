package site.ilemon.autoconfigurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(HelloProperties.class) // 启用属性配置
public class HelloAutoConfiguration {

    @Autowired
    private HelloProperties properties;

    @Bean
    public HelloService helloService() {
        return new HelloService(properties);
    }
}
