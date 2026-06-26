package com.contractflow.platform.u202413142.contract_management.application.commands;

import com.contractflow.platform.u202413142.contract_management.domain.model.valueobjects.ContractIdentifier;
import com.contractflow.platform.u202413142.contract_management.domain.model.valueobjects.CustomerId;
import com.contractflow.platform.u202413142.shared.domain.model.valueobjects.ContractPeriod;
import com.contractflow.platform.u202413142.shared.domain.model.valueobjects.ContractValue;

/**
 * Command for creating a service contract.
 */
public record CreateServiceContractCommand(
        ContractIdentifier contractIdentifier,
        CustomerId customerId,
        ContractPeriod period,
        ContractValue totalValue,
        String description
) {
    /**
     * Compact constructor for validation.
     */
    public CreateServiceContractCommand {
        if (contractIdentifier == null)
            throw new IllegalArgumentException("contractIdentifier cannot be null");
        if (customerId == null)
            throw new IllegalArgumentException("customerId cannot be null");
        if (period == null)
            throw new IllegalArgumentException("period cannot be null");
        if (totalValue == null)
            throw new IllegalArgumentException("totalValue cannot be null");
        if (description == null || description.isBlank())
            throw new IllegalArgumentException("description cannot be null or blank");
    }
}