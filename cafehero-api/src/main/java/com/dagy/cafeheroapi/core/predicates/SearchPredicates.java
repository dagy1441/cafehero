package com.dagy.cafeheroapi.core.predicates;


import com.dagy.cafeheroapi.core.params.DateRangeParam;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

public class SearchPredicates {
    public static <T> List<Predicate> dateRangeParamPredicates(
            CriteriaBuilder criteriaBuilder,
            DateRangeParam param,
            Root<T> mainRoot
    ) {
        List<Predicate> predicates = new ArrayList<>();

        if (!isEmpty(param.getEndDate())) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(mainRoot.get("createdAt"), param.getEndDate().atStartOfDay()));
        }

        if (!isEmpty(param.getStartDate())) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(mainRoot.get("createdAt"), param.getStartDate().atStartOfDay()));
        }

        return predicates;
    }

    public static <T> List<Predicate> activeRecordPredicate(
            CriteriaBuilder criteriaBuilder,
            Boolean isActiveRecord,
            Root<T> mainRoot
    ) {
        List<Predicate> predicates = new ArrayList<>();
        if (isActiveRecord) {
            predicates.add(criteriaBuilder.isTrue(mainRoot.get("isActiveStatus").as(Boolean.class)));
        }
        if (!isActiveRecord) {
            predicates.add(criteriaBuilder.isFalse(mainRoot.get("isActiveStatus").as(Boolean.class)));
        }
        return predicates;
    }

    public static <T> Predicate createdByPredicate(
            CriteriaBuilder criteriaBuilder,
            String username,
            Root<T> mainRoot
    ) {
        return criteriaBuilder.equal(mainRoot.get("createdBy"), username);
    }

    public static <T> Predicate createdAtPredicate(CriteriaBuilder criteriaBuilder, LocalDate date, Root<T> mainRoot) {
        LocalDateTime startDateTime = date.atTime(LocalTime.MIN); // Midnight
        LocalDateTime endDateTime = date.atTime(LocalTime.MAX); // 23:59:59

        return criteriaBuilder.between(mainRoot.get("createdAt"), startDateTime, endDateTime);
    }

}
