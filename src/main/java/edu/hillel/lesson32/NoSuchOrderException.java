package edu.hillel.lesson32;

public class NoSuchOrderException extends RuntimeException{
    public NoSuchOrderException(String message) {
        super(message);
    }
}
