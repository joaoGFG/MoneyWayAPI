package br.com.fiap.MoneyWay.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

import br.com.fiap.MoneyWay.validation.ValidAmount;

@Data
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Descrição é obrigatória")
    @Size(min = 2, max = 255, message = "Descrição deve ter entre 2 e 255 caracteres")
    private String description;

    @ValidAmount
    @NotNull(message = "Valor é obrigatório")
    private BigDecimal amount;

    @PastOrPresent(message = "Data não pode ser futura")
    @NotNull(message = "Data é obrigatória")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Tipo da transação é obrigatório")
    private TransactionType type;
}
