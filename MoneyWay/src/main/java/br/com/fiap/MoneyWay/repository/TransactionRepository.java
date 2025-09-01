package br.com.fiap.MoneyWay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.MoneyWay.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    
}
