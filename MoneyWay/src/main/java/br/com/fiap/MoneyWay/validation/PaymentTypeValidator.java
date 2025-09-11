package br.com.fiap.MoneyWay.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class PaymentTypeValidator implements ConstraintValidator<PaymentType, String> {

    private final List<String> validTypes = List.of(
            "CreditCard",
            "DebitCard",
            "Pix",
            "Boleto",
            "Cash"
    );

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) return false; 
        return validTypes.contains(value);
    }
}
