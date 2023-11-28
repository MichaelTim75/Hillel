package edu.hillel.lesson30.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @Value("${api.news.key}")
    public String apiNewsKey;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
