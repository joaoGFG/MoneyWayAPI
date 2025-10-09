package br.com.fiap.MoneyWay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import br.com.fiap.MoneyWay.model.Goal;
import br.com.fiap.MoneyWay.repository.GoalRepository;

@Service
public class GoalService {
    
    @Autowired
    private GoalRepository repository;

    public Page<Goal> getGoals(Specification<Goal> specification, Pageable pageable) {
        return repository.findAll(specification, pageable);
    }
}
