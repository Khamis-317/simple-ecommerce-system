package com.khamis.product;

import java.time.LocalDate;

public interface Expirable {

    LocalDate getExpiryDate();
    default boolean isExpired() {
        return LocalDate.now().isAfter(getExpiryDate());
    }

    Expirable NO_EXPIRY = () -> LocalDate.MAX;
}
