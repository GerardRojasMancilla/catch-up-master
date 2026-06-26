package com.contractflow.platform.u202413142.contract_management.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.util.UUID;

/**
 * Value object for the unique document identifier generated in another context.
 */
@Embeddable
public record ContractIdentifier(UUID value) {
    public ContractIdentifier {
        if (value == null) throw new IllegalArgumentException("ContractIdentifier cannot be null");
    }
}