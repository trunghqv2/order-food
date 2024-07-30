package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "Categories")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredientsItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne
    private IngredientCategory category;

    @JsonIgnore
    @ManyToOne
    private Restaurant restaurant;

    private boolean inStoke = true;
}
