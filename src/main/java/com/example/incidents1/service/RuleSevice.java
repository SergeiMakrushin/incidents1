package com.example.incidents1.service;

import com.example.incidents1.model.Rule;
import com.example.incidents1.repository.RuleRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RuleSevice {
    private final RuleRepository ruleRepository;

    public RuleSevice(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }
    public List<Rule> getAll() {
        return ruleRepository.findAll();
    }

    public Set<Rule> getRuleById(List <Integer> id) {
        Set <Rule> rules = new HashSet<>();
        for (Integer type : id) {
            Optional<Rule> rule = ruleRepository.findById(type);
            rule.ifPresent(rules::add);
        }
        return rules;
    }
}
