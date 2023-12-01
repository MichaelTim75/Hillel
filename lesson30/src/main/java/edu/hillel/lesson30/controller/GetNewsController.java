package edu.hillel.lesson30.controller;

import edu.hillel.lesson30.model.NewsResponse;
import edu.hillel.lesson30.service.NewsService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/news")
public class GetNewsController {

    @Setter(onMethod_ = @Autowired)
    private NewsService newsService;

    @GetMapping
    public NewsResponse getUkraineTopNews() {
        return new NewsResponse(newsService.getUkraineTopNews());
    }
}
