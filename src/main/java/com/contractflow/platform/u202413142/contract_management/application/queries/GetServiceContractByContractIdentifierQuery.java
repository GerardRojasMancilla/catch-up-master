package com.contractflow.platform.u202413142.contract_management.application.queries;

import com.contractflow.platform.u202413142.contract_management.domain.model.valueobjects.ContractIdentifier;

public record GetServiceContractByContractIdentifierQuery(ContractIdentifier contractIdentifier) {
    public GetServiceContractByContractIdentifierQuery {
        if (contractIdentifier == null) {
            throw new IllegalArgumentException("contractIdentifier cannot be null");
        }
    }
}