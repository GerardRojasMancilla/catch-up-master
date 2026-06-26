package com.contractflow.platform.u202413142.contract_management.application.internal.queryservices;

import com.contractflow.platform.u202413142.contract_management.application.queries.GetServiceContractByContractIdentifierQuery;
import com.contractflow.platform.u202413142.contract_management.application.queries.GetServiceContractByIdQuery;
import com.contractflow.platform.u202413142.contract_management.application.queryservices.ServiceContractQueryService;
import com.contractflow.platform.u202413142.contract_management.domain.model.aggregates.ServiceContract;
import com.contractflow.platform.u202413142.contract_management.domain.model.repositories.ServiceContractRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ServiceContractQueryServiceImpl implements ServiceContractQueryService {

    private final ServiceContractRepository repository;

    public ServiceContractQueryServiceImpl(ServiceContractRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<ServiceContract> handle(GetServiceContractByIdQuery query) {
        return repository.findById(query.id());
    }

    @Override
    public Optional<ServiceContract> handle(GetServiceContractByContractIdentifierQuery query) {
        return repository.findByContractIdentifier(query.contractIdentifier());
    }
}