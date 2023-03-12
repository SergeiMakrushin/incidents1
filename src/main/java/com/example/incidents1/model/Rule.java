package com.example.incidents1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
//говорим к какой таблице будет привязан класс
@Table(name="rule")
@Entity
@Data
// этоот класс используем для создания конструктора
@AllArgsConstructor
//для создания конструктора
@NoArgsConstructor
//для JPA
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Rule {
    @EqualsAndHashCode.Include
//стратегия генерации Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int Id;
}
