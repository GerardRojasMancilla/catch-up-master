package com.contractflow.platform.u202413142.contract_management.infrastructure.persistence.jpa.converters;

import com.contractflow.platform.u202413142.contract_management.domain.model.valueobjects.ContractIdentifier;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.UUID;

/**
 * JPA converter for persisting ContractIdentifier value objects as strings.
 */
@Converter(autoApply = true)
public class ContractIdentifierAttributeConverter implements AttributeConverter<ContractIdentifier, String> {

    @Override
    public String convertToDatabaseColumn(ContractIdentifier attribute) {
        // Convierte el Value Object a String para la base de datos
        return attribute == null ? null : attribute.value().toString();
    }

    @Override
    public ContractIdentifier convertToEntityAttribute(String dbData) {
        // Convierte el String de la base de datos de vuelta al Value Object
        return dbData == null ? null : new ContractIdentifier(UUID.fromString(dbData));
    }
}