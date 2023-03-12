package com.example.incidents1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="type")
//где пометить аанотацией будет помечен иквелс
public class AccidentType {
    @EqualsAndHashCode.Include
    //указывает на Id таблицы Type
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;


    private String name;


}
