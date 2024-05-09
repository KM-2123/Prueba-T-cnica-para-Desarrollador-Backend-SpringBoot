package org.maravilla.pruebatecnicasb.controllers;

import org.maravilla.pruebatecnicasb.dto.PaymentDetailsDTO;
import org.maravilla.pruebatecnicasb.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/process")
    public ResponseEntity<String> processPayment(@RequestBody PaymentDetailsDTO paymentDetailsDTO){
        boolean paymentProcessed = paymentService.processPayment(paymentDetailsDTO);
        if(paymentProcessed){
            return new ResponseEntity<>("Payment processed successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Payment processing failed", HttpStatus.BAD_REQUEST);
        }
    }

}
