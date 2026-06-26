package com.contractflow.platform.u202413142.contract_management.domain.model.aggregates;

import com.contractflow.platform.u202413142.contract_management.domain.model.valueobjects.ContractIdentifier;
import com.contractflow.platform.u202413142.contract_management.domain.model.valueobjects.ContractStatus;
import com.contractflow.platform.u202413142.contract_management.domain.model.valueobjects.CustomerId;
import com.contractflow.platform.u202413142.shared.domain.model.valueobjects.ContractPeriod;
import com.contractflow.platform.u202413142.shared.domain.model.valueobjects.ContractValue;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * Aggregate Root representing a Service Contract.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
public class ServiceContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "contract_identifier", unique = true, nullable = false))
    private ContractIdentifier contractIdentifier;

    @Embedded
    private CustomerId customerId;

    @Embedded
    private ContractPeriod period;

    @Embedded
    private ContractValue totalValue;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ContractStatus status;

    private String description;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    // Constructor protegido para JPA
    protected ServiceContract() {}

    // Constructor público para crear nuevos contratos (Lógica de negocio inicial)
    public ServiceContract(ContractIdentifier contractIdentifier, CustomerId customerId,
                           ContractPeriod period, ContractValue totalValue, String description) {
        this.contractIdentifier = contractIdentifier;
        this.customerId = customerId;
        this.period = period;
        this.totalValue = totalValue;
        this.description = description;
        this.status = ContractStatus.DRAFT;
    }

    // Constructor privado para reconstrucción desde la DB (Rehidratación)
    private ServiceContract(Long id, ContractIdentifier contractIdentifier, CustomerId customerId,
                            ContractPeriod period, ContractValue totalValue, ContractStatus status,
                            String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.contractIdentifier = contractIdentifier;
        this.customerId = customerId;
        this.period = period;
        this.totalValue = totalValue;
        this.status = status;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Método de fábrica para que el PersistenceMapper pueda usar el constructor privado
    public static ServiceContract rehydrate(Long id, ContractIdentifier contractIdentifier, CustomerId customerId,
                                            ContractPeriod period, ContractValue totalValue, ContractStatus status,
                                            String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new ServiceContract(id, contractIdentifier, customerId, period, totalValue, status, description, createdAt, updatedAt);
    }
}