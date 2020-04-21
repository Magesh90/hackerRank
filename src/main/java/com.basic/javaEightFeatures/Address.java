package com.basic.javaEightFeatures;

import java.time.Instant;
import java.util.Optional;

class Address {
    private Instant validFrom;

    Optional<Instant> getInstant() {
        return Optional.ofNullable(validFrom);
    }

    Address(Instant instant) {
        this.validFrom = instant;
    }
}
