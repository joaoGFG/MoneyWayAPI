package br.com.fiap.MoneyWay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.MoneyWay.model.PaymentMethod;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
    
}
