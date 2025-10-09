package br.com.fiap.MoneyWay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.MoneyWay.filter.TransactionSpecification;
import br.com.fiap.MoneyWay.model.Transaction;
import br.com.fiap.MoneyWay.model.TransactionsFilters;
import br.com.fiap.MoneyWay.repository.TransactionRepository;
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
    private TransactionRepository repository;


    @Autowired
    private TransactionService transactionService;


    @GetMapping
    public Page<Transaction> index(TransactionsFilters filters, @PageableDefault(size = 10, sort = "date", direction = Direction.DESC) Pageable pageable){
        var specification = TransactionSpecification.build(filters);
        return transactionService.getTransactions(specification, pageable);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction create(@RequestBody @Valid Transaction transaction){
        log.info("criando transação " + transaction);
        return repository.save(transaction);
    }
    
}
