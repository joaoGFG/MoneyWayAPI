package br.com.fiap.MoneyWay.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.MoneyWay.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

    //@Query("SELECT t FROM Transaction WHERE date > now()")
    //List<Transaction> findByDescriptionContainingIgnoreCase(String description);

    //List<Transaction> findByDescriptionContainingIgnoreCaseAndDate(String description, LocalDate date);
    
}
