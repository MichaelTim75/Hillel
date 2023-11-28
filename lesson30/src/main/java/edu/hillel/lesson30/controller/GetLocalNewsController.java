package edu.hillel.lesson30.controller;

import edu.hillel.lesson30.model.NewsResponse;
import edu.hillel.lesson30.service.LocalNewsService;
import edu.hillel.lesson30.service.NewsService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/local/news")
public class GetLocalNewsController {

    @Setter(onMethod_ = @Autowired)
    private LocalNewsService localNewsService;

    @GetMapping
    public NewsResponse getUkraineTopNews(){
        return new NewsResponse(localNewsService.getLocalNews());
    }
}
