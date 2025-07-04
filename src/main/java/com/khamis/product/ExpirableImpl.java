package com.khamis.product;

import java.time.LocalDate;

public class ExpirableImpl implements Expirable {
    private final LocalDate expiryDate;

    public ExpirableImpl(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
