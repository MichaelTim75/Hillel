package edu.hillel.lesson24.v2;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileStorage implements Storage {

    private static final String FILE_PATH = "src/main/java/edu/hillel/lesson24/v2";
    private static final String FILE_NAME = "data.txt";

    private final File file;

    @SneakyThrows(IOException.class)
    public FileStorage() {
        Files.createDirectories(Paths.get(FILE_PATH));
        file = new File(FILE_PATH, FILE_NAME);
    }

    @Override
    @SneakyThrows(IOException.class)
    public void saveData(List<String> data) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (String c : data) {
                writer.write(c);
                writer.newLine();
            }
        }
    }

    @Override
    @SneakyThrows(IOException.class)
    public List<String> getData() {
        List<String> data = new ArrayList<>();
        try (BufferedReader r = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = r.readLine()) != null) {
                data.add(line);
            }
        }

        return data;
    }

    @SneakyThrows
    @Override
    public void clearData() {
        file.deleteOnExit();
        file.createNewFile();
    }

}
