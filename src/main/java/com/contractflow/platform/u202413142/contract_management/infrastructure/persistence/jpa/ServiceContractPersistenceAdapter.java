package com.contractflow.platform.u202413142.contract_management.infrastructure.persistence.jpa;

import com.contractflow.platform.u202413142.contract_management.domain.model.aggregates.ServiceContract;
import com.contractflow.platform.u202413142.contract_management.domain.model.repositories.ServiceContractRepository;
import com.contractflow.platform.u202413142.contract_management.domain.model.valueobjects.ContractIdentifier;
import com.contractflow.platform.u202413142.contract_management.infrastructure.persistence.jpa.mappers.ServiceContractPersistenceMapper;
import com.contractflow.platform.u202413142.contract_management.infrastructure.persistence.jpa.repositories.ServiceContractJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ServiceContractPersistenceAdapter implements ServiceContractRepository {

    private final ServiceContractJpaRepository repository;

    public ServiceContractPersistenceAdapter(ServiceContractJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ServiceContract save(ServiceContract serviceContract) {
        var entity = ServiceContractPersistenceMapper.toJpaEntity(serviceContract);
        var savedEntity = repository.save(entity);
        return ServiceContractPersistenceMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<ServiceContract> findByContractIdentifier(ContractIdentifier contractIdentifier) {
        return repository.findByContractIdentifier(contractIdentifier)
                .map(ServiceContractPersistenceMapper::toDomain);
    }


    @Override
    public boolean existsByContractIdentifier(ContractIdentifier contractIdentifier) {
        return repository.existsByContractIdentifier(contractIdentifier);
    }
    
    @Override
    public Optional<ServiceContract> findById(Long id) {
        return repository.findById(id)
                .map(ServiceContractPersistenceMapper::toDomain);
    }


}