package site.ilemon.springbootservlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletComponentConfig {

    @Bean
    public ServletRegistrationBean myServlet(){
        MyServlet servlet = new MyServlet();
        ServletRegistrationBean servletRegistrationBean = new
                ServletRegistrationBean(servlet,"/myServlet");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        MyFilter filter = new MyFilter();
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("initParam","value");
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new
                ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new MyListener());
        return  servletListenerRegistrationBean;
    }
}
