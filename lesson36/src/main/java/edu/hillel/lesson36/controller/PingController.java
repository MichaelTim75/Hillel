package edu.hillel.lesson36.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    private static final Logger LOGGER = LogManager.getLogger();

    @GetMapping("/ping")
    public String ping(Authentication authentication) {
        LOGGER.info("Ping. Called by user {}", authentication.getName());
        return "OK";
    }

}
