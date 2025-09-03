package br.com.fiap.MoneyWay.controller;


import br.com.fiap.MoneyWay.model.Transaction;
import br.com.fiap.MoneyWay.repository.TransactionRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@Slf4j
public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;


    @GetMapping
    public List<Transaction> index(){
        return transactionRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction create(@RequestBody @Valid Transaction transaction){
        log.info("cadastrando transação" + transaction);
        return transactionRepository.save(transaction);
    }


}
