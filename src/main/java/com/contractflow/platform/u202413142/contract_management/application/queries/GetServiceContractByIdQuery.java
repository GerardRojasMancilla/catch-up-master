package com.contractflow.platform.u202413142.contract_management.application.queries;

public record GetServiceContractByIdQuery(Long id) {
    public GetServiceContractByIdQuery {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("service.contract.error.id.invalid");
        }
    }
}