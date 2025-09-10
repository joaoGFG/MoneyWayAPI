package br.com.fiap.MoneyWay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.MoneyWay.model.PaymentMethod;
import br.com.fiap.MoneyWay.repository.PaymentMethodRepository;

@Service
public class PaymentMethodService {

    @Autowired
    private PaymentMethodRepository repository;

    public PaymentMethod save(PaymentMethod paymentMethod) {
        paymentMethod.setName(paymentMethod.getName().trim());

        if (paymentMethod.getDescription() != null) {
            paymentMethod.setDescription(paymentMethod.getDescription().trim());
        }

        return repository.save(paymentMethod);
    }

    public PaymentMethod findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Método de pagamento não encontrado com id " + id
                ));
    }

    public PaymentMethod update(PaymentMethod paymentMethod, Long id) {
        findById(id);

        paymentMethod.setName(paymentMethod.getName().trim());

        if (paymentMethod.getDescription() != null) {
            paymentMethod.setDescription(paymentMethod.getDescription().trim());
        }

        paymentMethod.setId(id);
        return repository.save(paymentMethod);
    }

    public void delete(Long id) {
        PaymentMethod paymentMethod = findById(id);
        repository.delete(paymentMethod);
    }
}