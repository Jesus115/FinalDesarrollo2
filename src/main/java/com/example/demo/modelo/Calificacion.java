package com.example.demo.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data

public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // @ManyToOne
    // @JoinColumn(name = "receta_id")
    // private Receta receta;

    private Integer puntuacion;

    // Getters and setters
}