package com.demo.paymentservice.service;

import com.demo.paymentservice.entity.TransactionDetails;
import com.demo.paymentservice.model.PaymentRequest;
import com.demo.paymentservice.model.PaymentResponse;
import com.demo.paymentservice.repository.TransactionDetailsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private TransactionDetailsRepository transactionDetailsRepository;

    @Override
    public Long doPayment(PaymentRequest paymentRequest) {
        log.info("Recording Payment Details : {}", paymentRequest);
        TransactionDetails transactionDetails=TransactionDetails.builder()
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .paymentStatus("SUCCESS")
                .orderId(paymentRequest.getOrderId())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .amount(paymentRequest.getAmount())
                .build();
        transactionDetailsRepository.save(transactionDetails);
        log.info("Payment Completed....");
        return 0L;
    }

    @Override
    public PaymentResponse getPaymentDetailByOrderId(long orderId) {
        log.info("Getting Payment Details for order id: {}", orderId);
        TransactionDetails transactionDetails = transactionDetailsRepository.findByOrderId(orderId);
        return PaymentResponse.builder()
                .id(transactionDetails.getId())
                .orderId(transactionDetails.getOrderId())
                .paymentMode(transactionDetails.getPaymentMode())
                .paymentDate(transactionDetails.getPaymentDate())
                .paymentStatus(transactionDetails.getPaymentStatus())
                .amount(transactionDetails.getId())
                .build();
    }
}
