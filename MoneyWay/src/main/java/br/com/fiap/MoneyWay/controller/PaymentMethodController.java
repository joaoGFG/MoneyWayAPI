package br.com.fiap.MoneyWay.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.MoneyWay.model.Category;
import br.com.fiap.MoneyWay.model.PaymentMethod;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/payment-methods")
public class PaymentMethodController {

    private List<PaymentMethod> repository = new ArrayList<>();

    @GetMapping
    public List<PaymentMethod> index(){
        return repository;
    }

    @GetMapping("{id}")
    public ResponseEntity<PaymentMethod> getPaymentMethodId(@PathVariable Long id){
        log.info("buscando metodo de pagamento com id" + id);
        var paymentMethodFound = getPaymentMethodById(id);

        return paymentMethodFound.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());


    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<PaymentMethod> create(@RequestBody PaymentMethod paymentMethod){
        paymentMethod.setId(Math.abs(new Random().nextLong()));
        log.info("métodos de pagamento: " + paymentMethod);
        repository.add(paymentMethod);
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentMethod);
    }

    @PutMapping("{id}")
    public ResponseEntity<PaymentMethod> updatePaymentMethod(@RequestBody PaymentMethod paymentMethodUp , @PathVariable Long id){
        var paymentMethodFound = getPaymentMethodById(id);

        if(paymentMethodFound.isEmpty()) return ResponseEntity.notFound().build();

        repository.remove(paymentMethodFound.get());
        paymentMethodUp.setId(id);
        repository.add(paymentMethodUp);

        return ResponseEntity.ok(paymentMethodUp);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> destroy(@PathVariable Long id){
        var paymentMethodFound = getPaymentMethodById(id);

        if (paymentMethodFound.isEmpty())return ResponseEntity.notFound().build();

        repository.remove(paymentMethodFound.get());
        return ResponseEntity.noContent().build();
    }


    private Optional<PaymentMethod> getPaymentMethodById(Long id) {
        var paymentMethodFound = repository.stream()
                .filter(paymentMethod -> paymentMethod.getId().equals(id))
                .findFirst();
        return paymentMethodFound;
    }

}
