package com.example.HelloWorld.exceptions;

public class NoSuchElementFoundException extends RuntimeException {
    public NoSuchElementFoundException(String msg) {
        super(msg);
    }
}