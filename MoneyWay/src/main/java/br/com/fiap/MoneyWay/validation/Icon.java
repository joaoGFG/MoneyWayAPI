package br.com.fiap.MoneyWay.validation;

import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IconValidator.class)
public @interface Icon {

    String message() default "{icon.valid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
