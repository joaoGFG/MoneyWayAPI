package br.com.fiap.MoneyWay.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @Column(nullable = false, length = 50)
    private String name;

    @Size(min = 2, max = 200, message = "{paymentMethod.description.size}")
    @Column(length = 200)
    private String description;
}
