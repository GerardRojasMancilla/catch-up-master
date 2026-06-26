package com.contractflow.platform.u202413142.contract_management.domain.model.repositories;

import com.contractflow.platform.u202413142.contract_management.domain.model.aggregates.ServiceContract;
import com.contractflow.platform.u202413142.contract_management.domain.model.valueobjects.ContractIdentifier;
import java.util.Optional;

// YA NO extiende JpaRepository, NI tiene @Repository
public interface ServiceContractRepository {
    ServiceContract save(ServiceContract contract);
    Optional<ServiceContract> findByContractIdentifier(ContractIdentifier contractIdentifier);
    boolean existsByContractIdentifier(ContractIdentifier contractIdentifier);
    // AGREGA ESTA LÍNEA para que coincida con tu Adaptador:
    Optional<ServiceContract> findById(Long id);
}