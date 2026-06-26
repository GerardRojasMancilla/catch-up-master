package com.contractflow.platform.u202413142.contract_management.application.internal.commandservices;

import com.contractflow.platform.u202413142.contract_management.application.commands.CreateServiceContractCommand;
import com.contractflow.platform.u202413142.contract_management.application.commandservices.ServiceContractCommandFailure;
import com.contractflow.platform.u202413142.contract_management.application.commandservices.ServiceContractCommandService;
import com.contractflow.platform.u202413142.contract_management.domain.model.aggregates.ServiceContract;
import com.contractflow.platform.u202413142.contract_management.domain.model.repositories.ServiceContractRepository;
import com.contractflow.platform.u202413142.shared.application.result.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceContractCommandServiceImpl implements ServiceContractCommandService {

    private final ServiceContractRepository repository;

    public ServiceContractCommandServiceImpl(ServiceContractRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Result<ServiceContract, ServiceContractCommandFailure> handle(CreateServiceContractCommand command) {
        // Validación mínima de duplicado
        if (repository.existsByContractIdentifier(command.contractIdentifier())) {
            return Result.failure(new ServiceContractCommandFailure.Duplicate(command.contractIdentifier().value()));
        }

        // Creación y guardado
        var contract = new ServiceContract(
                command.contractIdentifier(),
                command.customerId(),
                command.period(),
                command.totalValue(),
                command.description()
        );

        return Result.success(repository.save(contract));
    }
}