package edu.hillel.lesson19.variant2;

import java.time.LocalDateTime;

public abstract class Logger {
    protected final LoggerConfiguration loggerConfiguration;

    public Logger() {
        LoggerConfigurationLoader loggerConfigurationLoader = new LoggerConfigurationLoader();
        loggerConfiguration = loggerConfigurationLoader.load("lesson19_properties.txt");

    }

    public void debug(String message) {
        if (LoggingLevel.DEBUG.equals(loggerConfiguration.getLoggingLevel())) {
            logging(String.format(loggerConfiguration.getFormat(), LocalDateTime.now(), edu.hillel.lesson19.variant1.LoggingLevel.DEBUG, message));
        }
    }

    public void info(String message) {
        logging(String.format(loggerConfiguration.getFormat(), LocalDateTime.now(), LoggingLevel.INFO, message));
    }

    abstract void logging(String message);
}
