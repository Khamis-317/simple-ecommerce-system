package com.khamis.Exceptions;

public class InvalidProductException extends RuntimeException {
    public InvalidProductException(String field, String reason) {
        super("Invalid product field: '" + field + "'. Reason: " + reason);
    }
}
