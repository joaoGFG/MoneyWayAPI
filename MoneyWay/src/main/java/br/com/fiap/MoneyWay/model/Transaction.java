package br.com.fiap.MoneyWay.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 255)
    private String description;

    @Positive
    private BigDecimal amount;

    @PastOrPresent
    private LocalDate date;


    @Enumerated(EnumType.STRING)
    private TransactionType type;
}
