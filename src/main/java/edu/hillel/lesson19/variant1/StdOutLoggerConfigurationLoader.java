package edu.hillel.lesson19.variant1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StdOutLoggerConfigurationLoader implements LoggerConfigurationLoader<StdOutLoggerConfiguration> {
    @Override
    public StdOutLoggerConfiguration load(String fileName) {
        Map<String, String> params = new HashMap<>();
        try (BufferedReader r = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = r.readLine()) != null) {
                final String[] s = line.split("=");
                params.put(s[0].trim().toUpperCase(), s[1].trim());
            }
            return new StdOutLoggerConfiguration(
                    LoggingLevel.valueOf(params.get("LEVEL")),
                    params.get("FORMAT"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
