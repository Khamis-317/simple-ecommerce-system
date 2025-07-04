package com.khamis.Exceptions;

import java.time.LocalDate;

public class ExpiredProductException extends RuntimeException {
    public ExpiredProductException(String productName, LocalDate expiryDate) {
        super("Sorry Product '" + productName + "' is expired. Expiry date was: " + expiryDate);
    }
}
