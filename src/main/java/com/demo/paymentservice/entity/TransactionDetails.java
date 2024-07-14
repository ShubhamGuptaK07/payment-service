package com.demo.paymentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name="TRANSACTION_DETAILS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private long orderId;
    @Column
    private String paymentMode;
    @Column
    private String referenceNumber;
    @Column
    private Instant paymentDate;
    @Column
    private String paymentStatus;
    @Column
    private long amount;


}
