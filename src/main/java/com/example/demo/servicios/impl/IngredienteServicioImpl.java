package com.example.demo.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Ingrediente;
import com.example.demo.repositorio.IIngredienteRepositorio;
import com.example.demo.servicios.IIngredienteServicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class IngredienteServicioImpl implements IIngredienteServicio {
	@PersistenceContext
    private EntityManager entityManager;
	@Autowired
	IIngredienteRepositorio ingRepo;
	@Override
	public Ingrediente buscarIngredienteId(int id) {
		return ingRepo.findById(id).get();

	}

	@Override
	public boolean eliminarIngredienteId(int id) {
		// TODO Auto-generated method stub
		try {
			ingRepo.deleteById(id);
			return true;		

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;		

		}
	}

	@Override
	public void insertarIngrediente(Ingrediente nuevoIngrediente) {
		// TODO Auto-generated method stub
		try {
			ingRepo.save(nuevoIngrediente);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Ingrediente> listarIngrediente() {
		// TODO Auto-generated method stub
		try {
			return ingRepo.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;

		}
	}

}
