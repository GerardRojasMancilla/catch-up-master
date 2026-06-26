package com.contractflow.platform.u202413142.contract_management.interfaces.rest.resources;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response resource representing a service contract")
public record ServiceContractResource(
        @Schema(description = "Persistent identifier", example = "1")
        Long id,

        @Schema(description = "Unique contract identifier", example = "CNT-2024-001")
        String contractIdentifier,

        @Schema(description = "Customer identifier", example = "1")
        String customerId,

        @Schema(description = "Contract status", example = "DRAFT")
        String status,

        @Schema(description = "Description of the contract")
        String description
) { }