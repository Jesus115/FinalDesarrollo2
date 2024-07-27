package com.example.demo.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.modelo.Receta;

@Service

public interface IRecetaServicio {
	public void insertarReceta(Receta nuevoReceta);
	public void actualizarRecetas(Receta editarReceta);
	public List<Receta> listarReceta();
	public List<Receta> buscarRecetaPorTitulo(String titulo);
    public List<Receta> buscarRecetaPorDescripcionContiene(String descripcion);
    public List<Receta> buscarRecetaPorTipo(String tipo);
	public Receta buscarRecetaId(int idReceta);
	public boolean eliminarRecetaId(int idReceta);
	public List<Receta> traerTodosMisRecetas(String name);
	public List<Receta> traerTodosMisRecetasPorCalificacion();
}
