package com.example.demo.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.modelo.RecetaIngrediente;

@Service
public interface IRecetaIngredienteServicio {
	public RecetaIngrediente buscarRecIngredienteId(int id);
	public boolean eliminarRecIngredienteId(int id);
	public void insertarRecIngrediente(RecetaIngrediente nuevo);
	public List<RecetaIngrediente> listarRecIngrediente();
}
