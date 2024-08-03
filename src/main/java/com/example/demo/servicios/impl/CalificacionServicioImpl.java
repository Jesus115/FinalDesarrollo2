package com.example.demo.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Calificacion;
import com.example.demo.repositorio.ICalificacionRepositorio;
import com.example.demo.servicios.ICalificacionServicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Service

public class CalificacionServicioImpl implements ICalificacionServicio {
	@PersistenceContext
    private EntityManager entityManager;
	@Autowired
	ICalificacionRepositorio caliRepo;
	@Override
	public List<Calificacion> listarCalificacion() {
		try {
			return caliRepo.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;

		}
	}
	@Override
	public void insertarCalificacion(Calificacion nuevoCalificacion) {
		// TODO Auto-generated method stub
		caliRepo.save(nuevoCalificacion);
	}
	@Override
	public Calificacion bucarCalificacionId(int id) {
		// TODO Auto-generated method stub
		return caliRepo.findById(id).get();

	}
	@Override
	public boolean eliminarCalificacionId(int id) {
		// TODO Auto-generated method stub
		try {
			caliRepo.deleteById(id);
			return true;		

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;		

		}
	}

}
