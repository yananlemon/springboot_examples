package site.ilemon.springbootdruid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidDataSourceConfig {

    /**
     * 向容器注册DruidDataSource类型的bean
     * @return
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource(){
        return  new DruidDataSource();
    }

    /**
     * 配置Druid 监控Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){

        // 设置Druid初始化参数
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","admin");
        initParameters.put("allow","");

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"");
        servletRegistrationBean.addUrlMappings("/druid/*"); // 处理所有以druid开头的请求
        servletRegistrationBean.setInitParameters(initParameters);
        ServletRegistrationBean registration = new ServletRegistrationBean();
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        //添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions",
                "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
