package br.com.fiap.MoneyWay.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.MoneyWay.model.PaymentMethod;

@RestController
public class PaymentMethodController {
    
    @GetMapping("/payment-methods")
    public List<PaymentMethod> index(){
        List<PaymentMethod> paymentMethods = new ArrayList<>();
        paymentMethods.add(new PaymentMethod(1L, "Credit Card"));
        paymentMethods.add(new PaymentMethod(2L, "Debit Card"));
        paymentMethods.add(new PaymentMethod(3L, "Pix"));
        paymentMethods.add(new PaymentMethod(4L, "PayPal"));
        
        return paymentMethods;
    }
}
