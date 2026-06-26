package com.contractflow.platform.u202413142.shared.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.time.LocalDate;

/**
 * Value object representing a time period for a contract.
 * @author [Tu Nombre]
 */
@Embeddable
public record ContractPeriod(LocalDate startDate, LocalDate endDate) {
    public ContractPeriod {
        // Regla: endDate no debe ser menor o igual a startDate
        if (endDate != null && startDate != null && !endDate.isAfter(startDate)) {
            throw new IllegalArgumentException("EndDate must be after StartDate");
        }
    }

    /**
     * Checks if the period has expired relative to a check date.
     * @param checkDate The date to compare.
     * @return true if checkDate is after endDate.
     */
    public boolean isExpired(LocalDate checkDate) {
        return checkDate.isAfter(endDate);
    }
}