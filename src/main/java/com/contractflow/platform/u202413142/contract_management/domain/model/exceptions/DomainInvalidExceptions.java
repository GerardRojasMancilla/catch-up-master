package com.contractflow.platform.u202413142.contract_management.domain.model.exceptions;

public abstract class DomainInvalidExceptions extends RuntimeException{
    public DomainInvalidExceptions(String message) {
        super(message);
    }
}