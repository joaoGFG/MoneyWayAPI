package br.com.fiap.MoneyWay.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.MoneyWay.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class CategoryController {

    @GetMapping("/categories")
    public List<Category> index(){
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1L, "Leisure", "movie"));
        categories.add(new Category(2L, "Transport", "bus"));

        return categories;
    }
    
}
