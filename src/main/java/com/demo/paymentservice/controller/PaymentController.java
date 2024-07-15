package com.demo.paymentservice.controller;

import com.demo.paymentservice.model.PaymentRequest;
import com.demo.paymentservice.model.PaymentResponse;
import com.demo.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest) {
        return new ResponseEntity<>(
                paymentService.doPayment(paymentRequest),
                HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<PaymentResponse> getPaymentDetailByOrderId(@PathVariable long orderId){
        return  new ResponseEntity<>(paymentService.getPaymentDetailByOrderId(orderId),HttpStatus.OK);
    }
}
