package br.com.fiap.MoneyWay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.MoneyWay.model.PaymentMethod;
import br.com.fiap.MoneyWay.repository.PaymentMethodRepository;
import br.com.fiap.MoneyWay.service.PaymentMethodService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/payment-methods")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping
    public List<PaymentMethod> index(){
        return paymentMethodRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentMethod create(@RequestBody @Valid PaymentMethod paymentMethod){
        log.info("criando método de pagamento " + paymentMethod);
        return paymentMethodService.save(paymentMethod);
    }

    @GetMapping("{id}")
    public PaymentMethod get(@PathVariable Long id){
        log.info("buscando método de pagamento com id " + id);
        return paymentMethodService.findById(id);
    }

    @PutMapping("{id}")
    public PaymentMethod update(@RequestBody @Valid PaymentMethod paymentMethodUpdated, @PathVariable Long id){
        log.info("atualizando método de pagamento {} com id {}", paymentMethodUpdated, id);
        return paymentMethodService.update(paymentMethodUpdated, id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id){
        log.info("apagando método de pagamento com id {}", id);
        paymentMethodService.delete(id);
    }
}