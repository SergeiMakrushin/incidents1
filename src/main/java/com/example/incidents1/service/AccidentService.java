package com.example.incidents1.service;

import com.example.incidents1.model.Accident;
import com.example.incidents1.repository.AccidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
public class AccidentService {
    private final AccidentRepository accidentRepository;

    @Autowired
    AccidentService(AccidentRepository accidentRepository) {
        this.accidentRepository = accidentRepository;
    }

    public Accident saveAccident(Accident accident) {
        return accidentRepository.save(accident);
    }

    public void removeAccidentById(int id) {
        //нашли  accident
        Accident accident = accidentRepository.findById(id)
//функциональный интерфейс используется, для выброса исключения
                .orElseThrow(() -> new EntityNotFoundException("Случай с указанным id не найден"));
        //удалили его
        accidentRepository.delete(accident);
    }

    public boolean updateAccident(Accident accident) {
        Map<Integer, Accident> accidentMap = new HashMap<>();
        List<Accident> accidentList = accidentRepository.findAll();
        for (Accident accident1 : accidentList) {
            accidentMap.put(accident.getId(), accident1);
        }
        return accidentMap.computeIfPresent(accident.getId(), (accidentId, oldAccident) -> new Accident(
                accidentId, accident.getName(), accident.getDescription(), accident.getAddress())) != null;
    }

    public List<Accident> findAllAccident() {
        return accidentRepository.findAll();
    }

    public Optional<Accident> findAccidentById(int id){
        Accident accident =accidentRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Случай с указанным id не найден"));
return Optional.ofNullable(accident);

    }



}

//public boolean update(Task task) {
//        var updateTask = taskMap.computeIfPresent(
//                task.getId(), (taskId, oldTask) -> new Task(
//                        taskId, task.getName(), task.getDiscription())) != null;
//
//        return updateTask;
//    }