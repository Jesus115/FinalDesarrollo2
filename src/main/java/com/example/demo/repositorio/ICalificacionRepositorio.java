package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Calificacion;

public interface ICalificacionRepositorio extends JpaRepository<Calificacion, Integer>{

}
