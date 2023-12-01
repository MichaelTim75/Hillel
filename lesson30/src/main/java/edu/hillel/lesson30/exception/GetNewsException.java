package edu.hillel.lesson30.exception;

public class GetNewsException extends RuntimeException{
    public GetNewsException(Throwable cause) {
        super(cause);
    }
}
