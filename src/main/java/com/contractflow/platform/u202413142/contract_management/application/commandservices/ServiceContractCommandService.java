package com.contractflow.platform.u202413142.contract_management.application.commandservices;

import com.contractflow.platform.u202413142.contract_management.application.commands.CreateServiceContractCommand;
import com.contractflow.platform.u202413142.contract_management.domain.model.aggregates.ServiceContract;
import com.contractflow.platform.u202413142.shared.application.result.Result;

public interface ServiceContractCommandService {
    Result<ServiceContract, ServiceContractCommandFailure> handle(CreateServiceContractCommand command);
}