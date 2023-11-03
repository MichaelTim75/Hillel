package edu.hillel.lesson19.variant1;

public class StdOutLoggerConfiguration implements LoggerConfiguration {
    private final LoggingLevel loggingLevel;
    private final String format;

    public StdOutLoggerConfiguration(LoggingLevel loggingLevel, String format) {
        this.loggingLevel = loggingLevel;
        this.format = format;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public String getFormat() {
        return format;
    }
}
