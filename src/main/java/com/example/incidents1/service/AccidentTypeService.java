package com.example.incidents1.service;

import com.example.incidents1.model.AccidentType;
import com.example.incidents1.repository.AccidentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AccidentTypeService {
    private final AccidentTypeRepository accidentTypeRepository;


    public AccidentTypeService(AccidentTypeRepository accidentTypeRepository) {
        this.accidentTypeRepository = accidentTypeRepository;
    }

    public List<AccidentType> getAll() {
        return accidentTypeRepository.findAll();
    }

    public Optional <AccidentType>  getAccidentTypeById(int id) {
        return  Optional.ofNullable(accidentTypeRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Не найдено")));

    }

}
