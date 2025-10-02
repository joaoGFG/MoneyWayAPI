package br.com.fiap.MoneyWay.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionsFilters(
    String description,
    LocalDate startDate,
    LocalDate endDate,
    BigDecimal minAmount,
    BigDecimal maxAmount,
    Category categoryId
 ) {}
