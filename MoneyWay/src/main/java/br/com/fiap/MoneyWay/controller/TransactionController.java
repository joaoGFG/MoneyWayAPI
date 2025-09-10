package br.com.fiap.MoneyWay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.MoneyWay.model.Transaction;
import br.com.fiap.MoneyWay.service.TransactionService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/transactions")
@Slf4j
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> index() {
        return transactionService.findAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction create(@RequestBody @Valid Transaction transaction){
        log.info("criando transação " + transaction);
        return transactionService.save(transaction);
    }
}