package edu.hillel.lesson30;

import edu.hillel.lesson30.service.LocalNewsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Lesson30Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Lesson30Application.class, args);

        LocalNewsService localNewsService = applicationContext.getBean(LocalNewsService.class);

        localNewsService.getLocalNews()
                .forEach(System.out::println);
    }

}
