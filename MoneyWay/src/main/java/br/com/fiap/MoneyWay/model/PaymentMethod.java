package br.com.fiap.MoneyWay.model;

import br.com.fiap.MoneyWay.validation.PaymentType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PaymentMethod {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{paymentMethod.name.notblank}")
    @Size(min = 2, max = 50, message = "{paymentMethod.name.size}")
    private String name;

    @Size(min = 2, max = 200, message = "{paymentMethod.description.size}")
    private String description;

    @PaymentType
    private String type;
}
