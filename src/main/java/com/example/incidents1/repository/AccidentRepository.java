package com.example.incidents1.repository;

import com.example.incidents1.model.Accident;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccidentRepository extends CrudRepository <Accident, Integer> {
    @Override
    List<Accident> findAll();

}
