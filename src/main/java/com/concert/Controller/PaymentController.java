package com.concert.Controller;

import com.concert.Entity.Payment;
import com.concert.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> processPayment(@RequestParam Long bookingId, @RequestParam double amount) {
        return ResponseEntity.ok(paymentService.processPayment(bookingId, amount));
    }

    // Other endpoints...
}
