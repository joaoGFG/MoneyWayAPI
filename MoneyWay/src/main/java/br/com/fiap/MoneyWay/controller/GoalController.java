package br.com.fiap.MoneyWay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


import br.com.fiap.MoneyWay.filter.GoalSpecification;
import br.com.fiap.MoneyWay.model.Goal;
import br.com.fiap.MoneyWay.model.GoalFilters;
import br.com.fiap.MoneyWay.service.GoalService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/goals")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @GetMapping
    public Page<Goal> index(GoalFilters filters, @PageableDefault(size = 10, sort = "deadline", direction = Direction.ASC) Pageable pageable){
        var specification = GoalSpecification.build(filters);
        return goalService.getGoals(specification, pageable);
    }
}
