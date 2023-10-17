package edu.hillel.lesson19.variant2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoggerConfigurationLoader {
    public LoggerConfiguration load(String fileName) {
        Map<String, String> params = new HashMap<>();
        try (BufferedReader r = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = r.readLine()) != null) {
                final String[] s = line.split("=");
                params.put(s[0].trim().toUpperCase(), s[1].trim());
            }
            return new LoggerConfiguration(
                    params.get("FILE"),
                    LoggingLevel.valueOf(params.get("LEVEL")),
                    Integer.parseInt(params.get("MAX-SIZE")),
                    params.get("FORMAT"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
