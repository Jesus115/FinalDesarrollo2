package com.example.demo.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Receta;
import com.example.demo.repositorio.IRecetaRepositorio;
import com.example.demo.servicios.IRecetaServicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Service

public class RecetaServicioImpl implements IRecetaServicio{
	@PersistenceContext
    private EntityManager entityManager;
	@Autowired
	IRecetaRepositorio recetaRepo;
	
	@Override
	public void insertarReceta(Receta nuevoReceta) {
		// TODO Auto-generated method stub
		try {
			recetaRepo.save(nuevoReceta);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void actualizarRecetas(Receta editarReceta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Receta> listarReceta() {
		// TODO Auto-generated method stub
		try {
			return recetaRepo.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;

		}
	}

	@Override
	public List<Receta> buscarRecetaPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Receta> buscarRecetaPorDescripcionContiene(String descripcion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Receta> buscarRecetaPorTipo(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Receta buscarRecetaId(int idReceta) {
		// TODO Auto-generated method stub
		return recetaRepo.findById(idReceta).get();
	}

	@Override
	public boolean eliminarRecetaId(int idReceta) {
		try {
			recetaRepo.deleteById(idReceta);
			return true;		

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;		

		}
	}

	@Override
	public List<Receta> traerTodosMisRecetas(String name) {
		// TODO Auto-generated method stub
		return recetaRepo.traerTodosMisRecetas(name);	
	}

	@Override
	public List<Receta> traerTodosMisRecetasPorCalificacion() {
		// TODO Auto-generated method stub
		try {
			return recetaRepo.traerTodosMisRecetasPorCalificacion();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;

		}
	}

}
