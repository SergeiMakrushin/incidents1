package com.example.incidents1.repository;

import com.example.incidents1.model.Rule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RuleRepository  extends CrudRepository <Rule, Integer> {
    @Override
    List<Rule> findAll();
}
