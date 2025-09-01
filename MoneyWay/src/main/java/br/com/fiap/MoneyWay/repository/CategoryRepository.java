package br.com.fiap.MoneyWay.repository;

import br.com.fiap.MoneyWay.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Métodos de consulta customizados podem ser adicionados aqui se necessário
    // Por exemplo:
    // List<Category> findByNameContainingIgnoreCase(String name);
    // Optional<Category> findByName(String name);
}
