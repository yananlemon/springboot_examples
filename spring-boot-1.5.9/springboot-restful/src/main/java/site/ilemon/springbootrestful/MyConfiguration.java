package site.ilemon.springbootrestful;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

@Configuration
public class MyConfiguration {

    /**
     * 注册自定义支持 YAML格式数据的HTTP转换器bean
     *
     * @return
     */
    @Bean
    public HttpMessageConverters yamlHttpMessageConverter() {
        return new HttpMessageConverters(new YamlMessageConverter());
    }

}
