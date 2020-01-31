package site.ilemon.springboot.springboothelloworld.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        System.out.println("MyCommandLineRunner.run() args:"+ Arrays.asList(args));
    }
}
