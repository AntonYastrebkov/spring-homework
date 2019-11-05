package com.epam.homework.exception;

public class TaskOverflowException extends RuntimeException {
    public TaskOverflowException(String message) {
        super(message);
    }
}