package edu.hillel.lesson30.service;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import edu.hillel.lesson30.config.Config;
import edu.hillel.lesson30.exception.GetNewsException;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    @Setter(onMethod_ = @Autowired)
    private Config config;

    @Setter(onMethod_ = @Autowired)
    private GetNewsResult getNewsResult;

    public List<String> getUkraineTopNews() {
        NewsApiClient newsApiClient = new NewsApiClient(config.apiNewsKey);

        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .q("Ukraine")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        getNewsResult.setNews(response.getArticles()
                                .stream()
                                .map(c -> "Glory to Ukraine: " + c.getTitle())
                                .toList());
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        throw new GetNewsException(throwable);
                    }
                }
        );
        return getNewsResult.getNews();
    }
}
