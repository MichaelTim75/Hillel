package edu.hillel.lesson30.service;

import edu.hillel.lesson30.exception.GetNewsException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
@Scope("prototype")
public class GetNewsResult {
    private static final long TIMEOUT = 5000L;
    private final List<String> news = new CopyOnWriteArrayList<>();

    public List<String> getNews() {
        long startTimeMS = System.currentTimeMillis();
        while (news.isEmpty() && System.currentTimeMillis() - startTimeMS < TIMEOUT) {
            synchronized (this) {
                try {
                    wait(TIMEOUT);
                } catch (Exception e) {
                    throw new GetNewsException(e);
                }
            }
        }
        return news;
    }

    public void setNews(List<String> news) {
        this.news.clear();
        this.news.addAll(news);
        synchronized (this) {
            notify();
        }
    }
}
