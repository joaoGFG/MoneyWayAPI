package br.com.fiap.MoneyWay.config;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.MoneyWay.model.Category;
import br.com.fiap.MoneyWay.model.Goal;
import br.com.fiap.MoneyWay.model.Transaction;
import br.com.fiap.MoneyWay.model.TransactionType;
import br.com.fiap.MoneyWay.repository.CategoryRepository;
import br.com.fiap.MoneyWay.repository.GoalRepository;
import br.com.fiap.MoneyWay.repository.TransactionRepository;
import jakarta.annotation.PostConstruct;

@Component
public class DatabaseSeeder {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private GoalRepository goalRepository;

    private Random random = new Random();

    @PostConstruct
    public void seeder(){
        var categories = List.of(
            Category.builder().name("Educação").icon("Book").build(),
            Category.builder().name("Transporte").icon("Bus").build(),
            Category.builder().name("Lazer").icon("Dices").build()
        );

        categoryRepository.saveAll(categories);

        var descriptions = List.of(
            "Livro de Java", "Mensalidade da Faculdade", "Bilhete Único", "Taxa do uber",
            "Cinema domingo", "Futebol com amigos", "Cerveja gelada", "Entretenimento"); 

        for(int i = 0; i < 50; i++){
        transactionRepository.saveAll(List.of(
            Transaction.builder()
                .description(descriptions.get(random.nextInt(descriptions.size())))
                .amount(BigDecimal.valueOf(random.nextDouble() * 500))
                .date(LocalDate.now().minusDays(random.nextInt(90)))
                .type(TransactionType.EXPENSE)
                .category(categories.get(random.nextInt(categories.size())))
                .build()
            ));
        }

        seedGoals();
    }

    private void seedGoals() {
        var goalTitles = List.of(
            "Comprar Casa Própria",
            "Viagem para Europa",
            "Carro Novo",
            "Fundo de Emergência",
            "Casamento",
            "Intercâmbio",
            "Notebook Gamer",
            "Investimento em Ações",
            "Curso de Pós-Graduação",
            "Reforma da Casa",
            "Viagem para Disney",
            "Moto Nova",
            "Home Office",
            "Aposentadoria",
            "Festa de 15 Anos"
        );

        var goalDescriptions = List.of(
            "Economizar para realizar o sonho",
            "Planejamento financeiro de longo prazo",
            "Meta para os próximos meses",
            "Guardando dinheiro aos poucos",
            "Juntando para realizar esse objetivo"
        );

        for (int i = 0; i < 30; i++) {
            String title = goalTitles.get(random.nextInt(goalTitles.size()));
            BigDecimal targetAmount = BigDecimal.valueOf(1000 + random.nextDouble() * 49000); // Entre 1000 e 50000
            BigDecimal currentAmount = BigDecimal.valueOf(random.nextDouble() * targetAmount.doubleValue()); // Progresso aleatório
            LocalDate deadline = LocalDate.now().plusDays(30 + random.nextInt(730)); // Entre 30 dias e 2 anos
            boolean completed = random.nextDouble() < 0.3; // 30% de chance de estar completa

            if (completed) {
                currentAmount = targetAmount.add(BigDecimal.valueOf(random.nextDouble() * 1000));
            }

            Goal goal = new Goal();
            goal.setTitle(title + " " + (i + 1));
            goal.setDescription(goalDescriptions.get(random.nextInt(goalDescriptions.size())));
            goal.setTargetAmount(targetAmount);
            goal.setCurrentAmount(currentAmount);
            goal.setDeadline(deadline);
            goal.setCompleted(completed);

            goalRepository.save(goal);
        }
    
    }
}
