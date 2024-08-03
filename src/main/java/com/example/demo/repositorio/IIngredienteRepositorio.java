package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Ingrediente;

public interface IIngredienteRepositorio extends JpaRepository<Ingrediente, Integer>{

}
