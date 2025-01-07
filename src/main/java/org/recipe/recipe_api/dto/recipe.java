package org.recipe.recipe_api.dto;

import java.sql.Time;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String ingredients;
    private String instructions;

    @DateTimeFormat(pattern = "mm:ss")
    private Time prepTime;
    
}
