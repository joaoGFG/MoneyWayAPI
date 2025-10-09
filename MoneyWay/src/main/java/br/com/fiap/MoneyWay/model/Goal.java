package br.com.fiap.MoneyWay.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{goal.title.notblank}")
    @Size(min = 3, max = 100, message = "{goal.title.size}")
    private String title;

    @Size(max = 255, message = "{goal.description.size}")
    private String description;

    @NotNull(message = "{goal.targetAmount.notnull}")
    @DecimalMin(value = "0.0", inclusive = false, message = "{goal.targetAmount.min}")
    private BigDecimal targetAmount;

    @NotNull(message = "{goal.currentAmount.notnull}")
    @DecimalMin(value = "0.0", inclusive = true, message = "{goal.currentAmount.min}")
    private BigDecimal currentAmount;

    @Future(message = "{goal.deadline.future}")
    private LocalDate deadline;

    private boolean completed;
}
