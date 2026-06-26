package com.contractflow.platform.u202413142.contract_management.infrastructure.persistence.jpa.mappers;

import com.contractflow.platform.u202413142.contract_management.domain.model.aggregates.ServiceContract;
import com.contractflow.platform.u202413142.contract_management.infrastructure.persistence.jpa.entities.ServiceContractJpaEntity;

public final class ServiceContractPersistenceMapper {

    private ServiceContractPersistenceMapper() {
    }

    public static ServiceContractJpaEntity toJpaEntity(ServiceContract aggregate) {
        return new ServiceContractJpaEntity(
                aggregate.getContractIdentifier(),
                aggregate.getCustomerId(),
                aggregate.getPeriod(),
                aggregate.getTotalValue(),
                aggregate.getStatus(),
                aggregate.getDescription()
        );
    }

    public static ServiceContract toDomain(ServiceContractJpaEntity entity) {
        // Aquí asumimos que tienes un método 'rehydrate' o un constructor
        // específico en tu dominio para reconstruir el Aggregate desde la DB.
        return ServiceContract.rehydrate(
                entity.getId(),
                entity.getContractIdentifier(),
                entity.getCustomerId(),
                entity.getPeriod(),
                entity.getTotalValue(),
                entity.getStatus(),
                entity.getDescription(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}