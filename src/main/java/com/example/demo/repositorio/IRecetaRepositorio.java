package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.modelo.Receta;


public interface IRecetaRepositorio  extends JpaRepository<Receta, Integer>{
	@Query("SELECT r FROM Receta r where r.titulo = :name")
	public List<Receta> traerTodosMisRecetas(@Param("name")String name);
	@Query("SELECT r FROM Receta r JOIN r.calificaciones c ORDER BY c.puntuacion DESC")
	public List<Receta> traerTodosMisRecetasPorCalificacion();

}
