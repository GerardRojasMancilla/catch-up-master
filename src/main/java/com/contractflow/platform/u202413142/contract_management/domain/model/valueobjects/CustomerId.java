package com.contractflow.platform.u202413142.contract_management.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.util.UUID;

/**
 * Value object for the customer identifier originatd in another context.
 */
@Embeddable
public record CustomerId(UUID value) {
    public CustomerId {
        if (value == null) throw new IllegalArgumentException("CustomerId cannot be null");
    }
}

