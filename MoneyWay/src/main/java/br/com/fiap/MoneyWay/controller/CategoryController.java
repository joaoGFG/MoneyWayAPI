package br.com.fiap.MoneyWay.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.MoneyWay.model.Category;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;



@RestController
@Slf4j
public class CategoryController {

    private List<Category> repository = new ArrayList<>();

    @GetMapping("/categories")
    public List<Category> index(){
        return repository;
    }


    @PostMapping("/categories")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Category create(@RequestBody Category category){
        category.setId(Math.abs(new Random().nextLong()));
        repository.add(category);
        return category;
    }

}
