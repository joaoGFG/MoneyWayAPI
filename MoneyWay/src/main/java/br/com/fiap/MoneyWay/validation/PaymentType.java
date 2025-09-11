package br.com.fiap.MoneyWay.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PaymentTypeValidator.class)
public @interface PaymentType {

    String message() default "{paymentMethod.type.invalid}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
