package com.contractflow.platform.u202413142.contract_management.application.commandservices;

import java.util.UUID;

public sealed interface ServiceContractCommandFailure permits ServiceContractCommandFailure.Duplicate {
    String messageKey();

    // Cambia String por java.util.UUID (o el tipo que uses en tu Value Object)
    record Duplicate(UUID identifier) implements ServiceContractCommandFailure {
        @Override
        public String messageKey() {
            return "service.contract.error.duplicate";
        }
    }
}