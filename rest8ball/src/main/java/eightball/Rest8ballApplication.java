package eightball;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Rest8ballApplication {

    public static void main(String[] args) {
        SpringApplication.run(Rest8ballApplication.class, args);
    }
}
