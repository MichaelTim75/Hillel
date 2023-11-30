package edu.hillel.lesson30.service;

import edu.hillel.lesson30.integration.GetLocalNewsManager;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalNewsService {

    @Setter(onMethod_ = @Autowired)
    private GetLocalNewsManager getLocalNewsManager;

    public List<String> getLocalNews() {
        return getLocalNewsManager.getNews();
    }
}
