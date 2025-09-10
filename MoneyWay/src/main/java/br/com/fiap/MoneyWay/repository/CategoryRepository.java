package br.com.fiap.MoneyWay.repository;

import br.com.fiap.MoneyWay.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
