package site.ilemon.springboot.springboothelloworld.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class MySpringApplicationRunListener implements SpringApplicationRunListener {

    public MySpringApplicationRunListener(SpringApplication app, String[] str){

    }

    @Override
    public void starting() {
        System.out.println("回调 SpringApplicationRunListener的starting方法");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        String osName = environment.getProperty("os.name");
        System.out.println("environmentPrepared...osName:"+osName);
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("contextPrepared...");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("contextLoaded...");
    }

    @Override
    public void finished(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("finished...");
    }
}
