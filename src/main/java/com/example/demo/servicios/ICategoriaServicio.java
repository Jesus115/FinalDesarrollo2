package com.example.demo.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.modelo.Categoria;


@Service

public interface ICategoriaServicio {
	public void insertarCategoria(Categoria nuevoCategoria);
	public void actualizarCategorias(Categoria editarCategoria);
	public List<Categoria> listarCategoria();
	public List<Categoria> buscarCategoriaPorTitulo(String titulo);
    public List<Categoria> buscarCategoriaPorDescripcionContiene(String descripcion);
    public List<Categoria> buscarCategoriaPorTipo(String tipo);
	public Categoria buscarCategoriaId(int idCategoria);
	public boolean eliminarCategoriaId(int idCategoria);
}
