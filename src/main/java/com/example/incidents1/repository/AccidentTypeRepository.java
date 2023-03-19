package com.example.incidents1.repository;

import com.example.incidents1.model.AccidentType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccidentTypeRepository  extends CrudRepository <AccidentType, Integer> {
    List <AccidentType> findall();
}
