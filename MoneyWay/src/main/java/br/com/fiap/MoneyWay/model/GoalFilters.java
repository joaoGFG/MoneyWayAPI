package br.com.fiap.MoneyWay.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record GoalFilters(
    String title,
    Boolean completed,
    BigDecimal minTargetAmount,
    BigDecimal maxTargetAmount,
    LocalDate deadlineBefore,
    LocalDate deadlineAfter
) {}
