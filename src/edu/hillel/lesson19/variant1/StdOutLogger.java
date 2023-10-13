package edu.hillel.lesson19.variant1;

import java.time.LocalDateTime;

public class StdOutLogger implements Logger {
    private final StdOutLoggerConfiguration loggerConfiguration;

    public StdOutLogger() {
        StdOutLoggerConfigurationLoader loggerConfigurationLoader = new StdOutLoggerConfigurationLoader();
        loggerConfiguration = loggerConfigurationLoader.load("lesson19_properties.txt");

    }

    @Override
    public void debug(String message) {
        if (LoggingLevel.DEBUG.equals(loggerConfiguration.getLoggingLevel())) {
            logging(String.format(loggerConfiguration.getFormat(), LocalDateTime.now(), LoggingLevel.DEBUG, message));
        }
    }

    @Override
    public void info(String message) {
        logging(String.format(loggerConfiguration.getFormat(), LocalDateTime.now(), LoggingLevel.INFO, message));
    }

    private void logging(String message) {
        System.out.println(message);
    }
}
