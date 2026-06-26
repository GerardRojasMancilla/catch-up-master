package com.contractflow.platform.u202413142.contract_management.infrastructure.persistence.jpa.entities;

import com.contractflow.platform.u202413142.contract_management.domain.model.valueobjects.ContractIdentifier;
import com.contractflow.platform.u202413142.contract_management.domain.model.valueobjects.ContractStatus;
import com.contractflow.platform.u202413142.contract_management.domain.model.valueobjects.CustomerId;
import com.contractflow.platform.u202413142.contract_management.infrastructure.persistence.jpa.converters.ContractIdentifierAttributeConverter;
import com.contractflow.platform.u202413142.contract_management.infrastructure.persistence.jpa.converters.CustomerIdAttributeConverter;
import com.contractflow.platform.u202413142.shared.domain.model.valueobjects.ContractPeriod;
import com.contractflow.platform.u202413142.shared.domain.model.valueobjects.ContractValue;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "service_contracts")
public class ServiceContractJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = ContractIdentifierAttributeConverter.class)
    @Column(name = "contract_identifier", nullable = false, unique = true)
    private ContractIdentifier contractIdentifier;

    @Convert(converter = CustomerIdAttributeConverter.class)
    @Column(name = "customer_id", nullable = false)
    private CustomerId customerId;

    // Para Value Objects complejos como Period y Value, usamos @Embedded
    // (o @AttributeOverride si quisieras mapear las columnas manualmente)
    @Embedded
    private ContractPeriod period;

    @Embedded
    private ContractValue totalValue;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ContractStatus status;

    @Column(length = 1000)
    private String description;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public ServiceContractJpaEntity(ContractIdentifier contractIdentifier, CustomerId customerId,
                                    ContractPeriod period, ContractValue totalValue,
                                    ContractStatus status, String description) {
        this.contractIdentifier = contractIdentifier;
        this.customerId = customerId;
        this.period = period;
        this.totalValue = totalValue;
        this.status = status;
        this.description = description;
    }
}