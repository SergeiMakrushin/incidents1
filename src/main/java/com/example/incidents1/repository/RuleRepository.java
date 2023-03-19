package com.example.incidents1.repository;

import com.example.incidents1.model.Rule;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RuleRepository  extends CrudRepository <Rule, Integer> {
    @Override
    List<Rule> findAll();
}
