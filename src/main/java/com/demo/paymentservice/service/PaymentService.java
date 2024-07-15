package com.demo.paymentservice.service;

import com.demo.paymentservice.model.PaymentRequest;
import com.demo.paymentservice.model.PaymentResponse;

public interface PaymentService {

    public Long doPayment(PaymentRequest paymentRequest);
    public PaymentResponse getPaymentDetailByOrderId(long orderId) ;
}
