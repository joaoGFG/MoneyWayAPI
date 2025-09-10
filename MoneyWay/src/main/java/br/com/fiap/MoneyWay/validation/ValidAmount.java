package br.com.fiap.MoneyWay.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AmountValidator.class)
public @interface ValidAmount {

    String message() default "{transaction.amount.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}