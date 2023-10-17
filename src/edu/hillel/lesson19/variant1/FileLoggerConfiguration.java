package edu.hillel.lesson19.variant1;

public class FileLoggerConfiguration implements LoggerConfiguration {
    private final String logFileName;
    private final LoggingLevel loggingLevel;
    private final int maxLogFileSize;

    private final String format;

    public FileLoggerConfiguration(String logFileName, LoggingLevel loggingLevel, int maxLogFileSize, String format) {
        this.logFileName = logFileName;
        this.loggingLevel = loggingLevel;
        this.maxLogFileSize = maxLogFileSize;
        this.format = format;
    }

    public String getLogFileName() {
        return logFileName;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public int getMaxLogFileSize() {
        return maxLogFileSize;
    }

    public String getFormat() {
        return format;
    }
}
