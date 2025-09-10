package br.com.fiap.MoneyWay.validation;

import java.math.BigDecimal;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AmountValidator implements ConstraintValidator<ValidAmount, BigDecimal> {

    @Override
    public boolean isValid(BigDecimal value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        return value.compareTo(BigDecimal.ZERO) > 0 &&
                value.compareTo(new BigDecimal("999999.99")) <= 0;
    }
}