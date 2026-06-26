package com.contractflow.platform.u202413142.contract_management.infrastructure.persistence.jpa.repositories;

import com.contractflow.platform.u202413142.contract_management.domain.model.valueobjects.ContractIdentifier;
import com.contractflow.platform.u202413142.contract_management.infrastructure.persistence.jpa.entities.ServiceContractJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceContractJpaRepository extends JpaRepository<ServiceContractJpaEntity, Long> {

    // Método necesario para cumplir la regla de negocio de unicidad
    boolean existsByContractIdentifier(ContractIdentifier contractIdentifier);

    // Método para recuperar por el identificador de dominio
    Optional<ServiceContractJpaEntity> findByContractIdentifier(ContractIdentifier contractIdentifier);
}