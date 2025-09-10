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
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.MoneyWay.model.PaymentMethod;
import br.com.fiap.MoneyWay.repository.PaymentMethodRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/payment-methods")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @GetMapping
    public List<PaymentMethod> index(){
        return paymentMethodRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentMethod create(@RequestBody PaymentMethod paymentMethod){
        log.info("criando método de pagamento " + paymentMethod);
        return paymentMethodRepository.save(paymentMethod);
    }

    @GetMapping("{id}")
    public PaymentMethod get(@PathVariable Long id){
        log.info("buscando método de pagamento com id " + id);
        return getPaymentMethodById(id);
    }

    @PutMapping("{id}")
    public PaymentMethod update(@RequestBody PaymentMethod paymentMethodUpdated, @PathVariable Long id){
        log.info("atualizando método de pagamento {} com id {}", paymentMethodUpdated, id);
        getPaymentMethodById(id);
        paymentMethodUpdated.setId(id);
        return paymentMethodRepository.save(paymentMethodUpdated);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id){
        log.info("apagando método de pagamento com id {}", id);
        paymentMethodRepository.delete(getPaymentMethodById(id));
    }

    private PaymentMethod getPaymentMethodById(Long id) {
        return paymentMethodRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Método de pagamento não encontrado com id " + id
                ));
    }
}