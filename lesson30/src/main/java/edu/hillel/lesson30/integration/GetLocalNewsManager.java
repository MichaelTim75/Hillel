package edu.hillel.lesson30.integration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class GetLocalNewsManager {

    @Setter(onMethod_=@Autowired)
    private RestTemplate restTemplate;

    @Value("${local.api.news.host:http://localhost}")
    private String host;

    @Value("${server.port:8181}")
    private int port;

    public List<String> getNews(){
        HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);

        URI uri = UriComponentsBuilder.fromHttpUrl(host)
                          .port(port)
                          .path("/news")
                          .build()
                          .encode()
                          .toUri();
        ResponseEntity<LocalNewsResponse> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                entity,
                LocalNewsResponse.class);

        return Optional.of(response)
                .map(HttpEntity::getBody)
                .map(LocalNewsResponse::getNews)
                .orElseGet(Collections::emptyList);
    }

    @Data
    @NoArgsConstructor
    private static class LocalNewsResponse{
        @JsonProperty("news")
        private List<String> news;
    }
}
