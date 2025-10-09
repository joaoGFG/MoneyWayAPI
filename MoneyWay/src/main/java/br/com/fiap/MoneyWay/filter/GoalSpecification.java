package br.com.fiap.MoneyWay.filter;

import org.springframework.data.jpa.domain.Specification;
import br.com.fiap.MoneyWay.model.Goal;
import br.com.fiap.MoneyWay.model.GoalFilters;

public class GoalSpecification {

    public static Specification<Goal> build(GoalFilters filters) {
        Specification<Goal> spec = Specification.unrestricted(); 

        if (filters == null) {
            return spec;
        }

        if (filters.title() != null && !filters.title().isBlank()) {
            spec = spec.and((root, query, cb) ->
                cb.like(cb.upper(root.get("title")), "%" + filters.title().toUpperCase() + "%")
            );
        }

        if (filters.completed() != null) {
            spec = spec.and((root, query, cb) ->
                cb.equal(root.get("completed"), filters.completed())
            );
        }

        if (filters.minTargetAmount() != null) {
            spec = spec.and((root, query, cb) ->
                cb.greaterThanOrEqualTo(root.get("targetAmount"), filters.minTargetAmount())
            );
        }

        if (filters.maxTargetAmount() != null) {
            spec = spec.and((root, query, cb) ->
                cb.lessThanOrEqualTo(root.get("targetAmount"), filters.maxTargetAmount())
            );
        }

        if (filters.deadlineBefore() != null) {
            spec = spec.and((root, query, cb) ->
                cb.lessThanOrEqualTo(root.get("deadline"), filters.deadlineBefore())
            );
        }

        if (filters.deadlineAfter() != null) {
            spec = spec.and((root, query, cb) ->
                cb.greaterThanOrEqualTo(root.get("deadline"), filters.deadlineAfter())
            );
        }

        return spec;
    }
}
