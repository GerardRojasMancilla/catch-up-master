package com.contractflow.platform.u202413142.shared.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.math.BigDecimal;

/**
 * Value object representing the monetary value of a contract.
 * @author [Tu Nombre]
 */
@Embeddable
public record ContractValue(BigDecimal amount, String currency) {
    public ContractValue {
        // Regla: monto debe ser >= 0
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Contract value amount must be greater than or equal to zero.");
        }
        // Regla: moneda no debe ser nula o vacía
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("Contract value currency cannot be null or blank.");
        }
    }

    /**
     * Multiplies the value by a factor and returns a new ContractValue.
     */
    public ContractValue multiply(BigDecimal factor) {
        return new ContractValue(this.amount.multiply(factor), this.currency);
    }
}