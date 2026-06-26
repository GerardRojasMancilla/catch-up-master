package com.contractflow.platform.u202413142.contract_management.application.queryservices;

import com.contractflow.platform.u202413142.contract_management.domain.model.aggregates.ServiceContract;
import com.contractflow.platform.u202413142.contract_management.application.queries.GetServiceContractByIdQuery;
import com.contractflow.platform.u202413142.contract_management.application.queries.GetServiceContractByContractIdentifierQuery;

import java.util.Optional;

/**
 * Service contract providing read access to service contracts.
 */
public interface ServiceContractQueryService {

    /**
     * Retrieves a service contract by its identifier.
     */
    Optional<ServiceContract> handle(GetServiceContractByIdQuery query);

    /**
     * Retrieves a service contract by its contract identifier value object.
     */
    Optional<ServiceContract> handle(GetServiceContractByContractIdentifierQuery query);
}