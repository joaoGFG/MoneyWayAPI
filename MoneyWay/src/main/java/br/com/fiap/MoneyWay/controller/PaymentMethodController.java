package br.com.fiap.MoneyWay.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("{id}")
    public ResponseEntity<PaymentMethod> getPaymentMethodId(@PathVariable Long id){
        log.info("buscando método de pagamento com id: " + id);

        return paymentMethodRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PaymentMethod> create(@RequestBody PaymentMethod paymentMethod){
        log.info("criando método de pagamento: " + paymentMethod);

        PaymentMethod savedPaymentMethod = paymentMethodRepository.save(paymentMethod);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPaymentMethod);
    }

    @PutMapping("{id}")
    public ResponseEntity<PaymentMethod> updatePaymentMethod(@RequestBody PaymentMethod paymentMethodUp, @PathVariable Long id){
        return paymentMethodRepository.findById(id)
                .map(existingPaymentMethod -> {
                    paymentMethodUp.setId(id);
                    PaymentMethod updatedPaymentMethod = paymentMethodRepository.save(paymentMethodUp);
                    return ResponseEntity.ok(updatedPaymentMethod);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> destroy(@PathVariable Long id){
        if (!paymentMethodRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        paymentMethodRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

