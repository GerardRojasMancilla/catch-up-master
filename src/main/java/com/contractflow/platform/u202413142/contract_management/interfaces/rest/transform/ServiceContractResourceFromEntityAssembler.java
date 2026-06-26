package com.contractflow.platform.u202413142.contract_management.interfaces.rest.transform;

import com.contractflow.platform.u202413142.contract_management.domain.model.aggregates.ServiceContract;
import com.contractflow.platform.u202413142.contract_management.interfaces.rest.resources.ServiceContractResource;

public class ServiceContractResourceFromEntityAssembler {
    public static ServiceContractResource toResourceFromEntity(ServiceContract entity) {
        /*
        return new ServiceContractResource(
                entity.getId(),
                //entity.getContractIdentifier().value(),
                //entity.getCustomerId().value(),
                entity.getStatus().name(),
                entity.getDescription());

         */
        return new ServiceContractResource( Long ,"ad" );
    }
}