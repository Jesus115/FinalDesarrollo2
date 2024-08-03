package com.example.demo.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.RecetaIngrediente;
import com.example.demo.repositorio.IRecetaIngredienteRepositorio;
import com.example.demo.servicios.IRecetaIngredienteServicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Service
public class RecetaIngredienteServicioImpl implements IRecetaIngredienteServicio{
	@PersistenceContext
    private EntityManager entityManager;
	@Autowired
	IRecetaIngredienteRepositorio ringRepo;
	@Override
	public List<RecetaIngrediente> buscarRecIngredienteId(int id) {
		// TODO Auto-generated method stub
		return ringRepo.buscarRecIngredienteId(id);
	}

	@Override
	public boolean eliminarRecIngredienteId(int id) {
		// TODO Auto-generated method stub
		try {
			ringRepo.deleteById(id);
			return true;		

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;		

		}
	}

	@Override
	public void insertarRecIngrediente(RecetaIngrediente nuevo) {
		// TODO Auto-generated method stub
		try {
			ringRepo.save(nuevo);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<RecetaIngrediente> listarRecIngrediente() {
		// TODO Auto-generated method stub
		try {
			return ringRepo.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;

		}
	}

}
