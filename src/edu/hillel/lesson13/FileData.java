package edu.hillel.lesson13;

import java.util.Objects;

public class FileData {
    private final String name;
    private final int size;
    private final String path;

    public FileData(String name, int size, String path) {
        this.name = name;
        this.size = size;
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileData fileData = (FileData) o;
        return Objects.equals(name, fileData.name) && Objects.equals(path, fileData.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, path);
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "FileData{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", path='" + path + '\'' +
                '}';
    }
}
