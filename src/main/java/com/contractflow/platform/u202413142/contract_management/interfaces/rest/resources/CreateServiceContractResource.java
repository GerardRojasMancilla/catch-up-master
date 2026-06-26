package com.contractflow.platform.u202413142.contract_management.interfaces.rest.resources;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Request resource used to create a service contract")
public record CreateServiceContractResource(
        @Schema(description = "Unique contract identifier", example = "CNT-2024-001", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank @Size(max = 50) String contractIdentifier,

        @Schema(description = "Customer identifier", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank String customerId,

        @Schema(description = "Contract period (start date to end date)", example = "2024-01-01 to 2024-12-31")
        @NotBlank String period,

        @Schema(description = "Total contract value", example = "1000.00")
        @NotBlank String totalValue,

        @Schema(description = "Contract description", example = "Maintenance services agreement")
        String description
) { }