package br.com.fiap.MoneyWay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.MoneyWay.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
