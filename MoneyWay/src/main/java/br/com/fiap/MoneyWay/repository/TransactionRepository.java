package br.com.fiap.MoneyWay.repository;

import br.com.fiap.MoneyWay.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
