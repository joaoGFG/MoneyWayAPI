package br.com.fiap.MoneyWay.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.MoneyWay.model.Category;
import br.com.fiap.MoneyWay.model.PaymentMethod;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PaymentMethodController {

    private List<PaymentMethod> repository = new ArrayList<>();

    @GetMapping("/payment-methods")
    public List<PaymentMethod> index(){
        return repository;
    }

    @PostMapping("/payment-methods")
    @ResponseStatus(code = HttpStatus.CREATED)
    public PaymentMethod create(@RequestBody PaymentMethod paymentMethod){
        paymentMethod.setId(Math.abs(new Random().nextLong()));
        log.info("métodos de pagamento: " + paymentMethod);
        repository.add(paymentMethod);
        return paymentMethod;
    }
}
