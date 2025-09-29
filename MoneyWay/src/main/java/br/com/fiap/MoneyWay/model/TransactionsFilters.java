package br.com.fiap.MoneyWay.model;

import java.time.LocalDate;

public record TransactionsFilters(
    String description,
    LocalDate date
 ) {}
