package edu.hillel.lesson30.service;

import edu.hillel.lesson30.Lesson30Application;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = Lesson30Application.class)
@ActiveProfiles(value = {"test"})
class NewsServiceTest {

    @MockBean
    private NewsService newsService;

    @LocalServerPort
    private int serverPort;

    @BeforeEach
    public void setUpRestAssured(){
        RestAssured.port=serverPort;
    }

    @Test
    void getUkraineTopNews() {
        List<String> originalNews =List.of("Glory to Ukraine: 1","Glory to Ukraine: 2","Glory to Ukraine: 3");
        Mockito.when(newsService.getUkraineTopNews())
                .thenReturn(originalNews);

        Response response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .get("/news");

        response
                .then()
                .statusCode(200)
                .assertThat()
                .body(notNullValue());

        List<String> news = response.getBody().jsonPath().getList("news");
        Collections.sort(news);

        Assertions.assertEquals(3,news.size());
        Assertions.assertEquals(originalNews,news);

    }
}