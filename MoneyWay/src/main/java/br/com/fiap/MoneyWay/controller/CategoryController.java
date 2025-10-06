package br.com.fiap.MoneyWay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.MoneyWay.model.Category;
import br.com.fiap.MoneyWay.repository.CategoryRepository;
import io.swagger.v3.oas.annotations.Operation;
//import br.com.fiap.MoneyWay.service.CategoryService;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/categories")
@RestController
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    //@Autowired
    //private CategoryService categoryService;

    @GetMapping
    public List<Category> index(){
        return categoryRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
        summary = "Cria uma categoria de movimentação",
        description = "Criando"    
    )
    public Category create(@RequestBody Category category){
        log.info("criando categoria " + category);

        return categoryRepository.save(category);
    }

    @GetMapping("{id}")
    public Category get(@PathVariable Long id){
        log.info("buscando categoria com id " + id);
        return getCategoryById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id){
        log.info("apagando categoria com id {}", id);
        categoryRepository.delete(getCategoryById(id));
    }

    @PutMapping("{id}")
    public Category update(@RequestBody Category categoryUpdated, @PathVariable Long id){
        log.info("atualizando categoria {} com id {}", categoryUpdated, id);
        getCategoryById(id);
        categoryUpdated.setId(id);
        return categoryRepository.save(categoryUpdated);
    }

    private Category getCategoryById(Long id) {
        return categoryRepository
                        .findById(id)
                        .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada com id " + id));
    }
}
    


