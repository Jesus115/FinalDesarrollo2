package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Ingrediente;
import com.example.demo.modelo.RecetaIngrediente;

public interface IRecetaIngredienteRepositorio extends JpaRepository<RecetaIngrediente, Integer>{

}
