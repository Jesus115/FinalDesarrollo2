package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.modelo.RecetaIngrediente;

public interface IRecetaIngredienteRepositorio extends JpaRepository<RecetaIngrediente, Integer>{
	
	@Query("SELECT ri FROM RecetaIngrediente ri WHERE ri.receta.id = :id")
    public List<RecetaIngrediente> buscarRecIngredienteId(@Param("id") Integer id);
}
