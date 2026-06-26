package com.contractflow.platform.u202413142.contract_management.interfaces.rest;

import com.contractflow.platform.u202413142.contract_management.application.commandservices.ServiceContractCommandService;
import com.contractflow.platform.u202413142.contract_management.interfaces.rest.resources.CreateServiceContractResource;
import com.contractflow.platform.u202413142.contract_management.interfaces.rest.resources.ServiceContractResource;
import com.contractflow.platform.u202413142.contract_management.interfaces.rest.transform.ServiceContractResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/service-contracts", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Service Contracts", description = "Endpoints for service contracts")
public class ServiceContractController {

    private final ServiceContractCommandService serviceContractCommandService;

    public ServiceContractController(ServiceContractCommandService commandService) {
        this.serviceContractCommandService = commandService;
    }

    @PostMapping
    public ResponseEntity<ServiceContractResource> createServiceContract(
            @RequestBody CreateServiceContractResource resource) {

        // 1. Transformas (aquí usas el assembler que ya corregimos antes)
        var command = CreateServiceContractCommandFromResourceAssembler.toCommandFromResource(resource);

        // 2. Ejecutas
        var serviceContract = serviceContractCommandService.handle(command);

        // 3. Respondes (devuelves el recurso directamente)
        return new ResponseEntity<>(ServiceContractResourceFromEntityAssembler.toResourceFromEntity(serviceContract), HttpStatus.CREATED);
    }
}