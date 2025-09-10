package br.com.fiap.MoneyWay.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.MoneyWay.model.Transaction;
import br.com.fiap.MoneyWay.repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public Transaction save(Transaction transaction) {
        transaction.setDescription(transaction.getDescription().trim());

        if (transaction.getDate() == null) {
            transaction.setDate(LocalDate.now());
        }

        return repository.save(transaction);
    }

    public Transaction findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Transação não encontrada com id " + id
                ));
    }

    public List<Transaction> findAll() {
        return repository.findAll();
    }
}