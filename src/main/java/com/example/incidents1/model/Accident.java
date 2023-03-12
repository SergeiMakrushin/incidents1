package com.example.incidents1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
//генерирует стринги
@AllArgsConstructor
//
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//обозначает что работает с бд
@Entity
//javax
@Table(name = "accident")

public class Accident {
    @EqualsAndHashCode.Include
    //lombok
    @Id
    //hibernet
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private String address;
@ManyToOne (fetch = FetchType.EAGER)
@JoinColumn(name="tape_id")
private AccidentType type;

@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
@JoinTable(
     name="accident_rule",
        joinColumns = {@JoinColumn (name="accident_id")},
        inverseJoinColumns = {@JoinColumn(name = "rule_id")}
)
private Set<Rule> rule;

}
