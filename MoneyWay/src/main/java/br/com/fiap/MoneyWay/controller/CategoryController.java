package br.com.fiap.MoneyWay.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.MoneyWay.model.Category;
import br.com.fiap.MoneyWay.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> index(){
        return categoryRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category){
        log.info("criando categoria: " + category);

        Category savedCategory = categoryRepository.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> get(@PathVariable Long id){
        return categoryRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> destroy(@PathVariable Long id){
        log.info("apagando categoria com id: {}", id);

        if (!categoryRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        categoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Category> update(@RequestBody Category categoryUpdated, @PathVariable Long id){
        log.info("atualizando categoria {} com id {}", categoryUpdated, id);

        return categoryRepository.findById(id)
                .map(existingCategory -> {
                    categoryUpdated.setId(id);
                    Category updatedCategory = categoryRepository.save(categoryUpdated);
                    return ResponseEntity.ok(updatedCategory);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

