package edu.hillel.lesson19.variant1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger implements Logger {
    private final FileLoggerConfiguration loggerConfiguration;
    private File file;

    public FileLogger() {
        FileLoggerConfigurationLoader loggerConfigurationLoader = new FileLoggerConfigurationLoader();
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

    private File getNewFile() {
        String fileName;
        File file;
        int i = 0;
        try {
            Files.createDirectories(Paths.get(loggerConfiguration.getLogFileName()));
            do {
                i++;
                fileName = loggerConfiguration.getLogFileName() + "/log_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy-HH:mm:ss")) + "." + i + ".txt";
                file = new File(fileName);
            } while (!file.createNewFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

    private void logging(String message) {
        if (file == null || file.length() >= loggerConfiguration.getMaxLogFileSize()) {
            file = getNewFile();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
