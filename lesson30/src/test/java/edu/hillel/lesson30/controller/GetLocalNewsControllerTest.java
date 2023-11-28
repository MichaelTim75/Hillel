package edu.hillel.lesson30.controller;

import edu.hillel.lesson30.Lesson30Application;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = Lesson30Application.class)
@ActiveProfiles(value = {"test"})

class GetLocalNewsControllerTest {

    @Autowired
    private RestTemplate restTemplate;

    @LocalServerPort
    private int serverPort;

    @Value("${local.api.news.host:http://localhost}")
    private String host;

    @Value("${server.port:8181}")
    private int port;

    private MockRestServiceServer mockServer;

    @BeforeEach
    public void setUpRestAssured(){
        RestAssured.port=serverPort;
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void GetLocalNewsTest(){
        URI uri = UriComponentsBuilder.fromHttpUrl(host)
                .port(port)
                .path("/news")
                .build()
                .encode()
                .toUri();

        String response = """
            {
                "news": [
                    "Glory to Ukraine: 1",
                    "Glory to Ukraine: 2",
                    "Glory to Ukraine: 3"
                ]
            }
            """;
        mockServer
                .expect(MockRestRequestMatchers.requestTo(uri))
                .andExpect(MockRestRequestMatchers.method(HttpMethod.GET))
                .andRespond(MockRestResponseCreators.withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(response));

        Response localResponse = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .get("/local/news");

        localResponse
                .then()
                .statusCode(200)
                .assertThat()
                .body(notNullValue());

        List<String> news = localResponse.getBody().jsonPath().getList("news");
        Collections.sort(news);

        Assertions.assertEquals(3,news.size());

    }

}