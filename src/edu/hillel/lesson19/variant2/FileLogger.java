package edu.hillel.lesson19.variant2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger extends Logger {
    private File file;

    public LoggerConfiguration getLoggerConfiguration() {
        return super.loggerConfiguration;
    }

    private File getNewFile() {
        String fileName;
        File file;
        int i = 0;
        try {
            Files.createDirectories(Paths.get(getLoggerConfiguration().getLogFileName()));
            do {
                i++;
                fileName = getLoggerConfiguration().getLogFileName() + "/log_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy-HH:mm:ss")) + "." + i + ".txt";
                file = new File(fileName);
            } while (!file.createNewFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

    void logging(String message) {
        if (file == null || file.length() >= getLoggerConfiguration().getMaxLogFileSize()) {
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
