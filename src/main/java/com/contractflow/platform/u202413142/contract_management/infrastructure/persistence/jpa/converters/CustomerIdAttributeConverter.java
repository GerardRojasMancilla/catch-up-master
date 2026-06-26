package com.contractflow.platform.u202413142.contract_management.infrastructure.persistence.jpa.converters;

import com.contractflow.platform.u202413142.contract_management.domain.model.valueobjects.CustomerId;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.UUID;

// Crea este archivo siguiendo la misma lógica:
@Converter(autoApply = true)
public class CustomerIdAttributeConverter implements AttributeConverter<CustomerId, String> {
    @Override
    public String convertToDatabaseColumn(CustomerId attribute) {
        return attribute == null ? null : attribute.value().toString();
    }

    @Override
    public CustomerId convertToEntityAttribute(String dbData) {
        return dbData == null ? null : new CustomerId(UUID.fromString(dbData));
    }
}