package com.example.demo.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Categoria;
import com.example.demo.repositorio.ICategoriaRepositorio;
import com.example.demo.servicios.ICategoriaServicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Service

public class CategoriaServicioImpl implements ICategoriaServicio {
	@PersistenceContext
    private EntityManager entityManager;
	@Autowired
	ICategoriaRepositorio categoriaRepo;
	@Override
	public void insertarCategoria(Categoria nuevoCategoria) {
		// TODO Auto-generated method stub
		
		try {
			categoriaRepo.save(nuevoCategoria);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void actualizarCategorias(Categoria editarCategoria) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Categoria> listarCategoria() {
		// TODO Auto-generated method stub
		try {
			return categoriaRepo.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;

		}
	}

	@Override
	public List<Categoria> buscarCategoriaPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> buscarCategoriaPorDescripcionContiene(String descripcion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> buscarCategoriaPorTipo(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria buscarCategoriaId(int idCategoria) {
		// TODO Auto-generated method stub
		return categoriaRepo.findById(idCategoria).get();
	}

	@Override
	public boolean eliminarCategoriaId(int idCategoria) {
		// TODO Auto-generated method stub
		
		try {
			categoriaRepo.deleteById(idCategoria);
			return true;		

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;		

		}
	}

}
