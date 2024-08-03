package com.example.demo.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.modelo.Categoria;
import com.example.demo.modelo.Ingrediente;

@Service
public interface IIngredienteServicio {
	public Ingrediente buscarIngredienteId(int id);
	public boolean eliminarIngredienteId(int id);
	public void insertarIngrediente(Ingrediente nuevoIngrediente);
	public List<Ingrediente> listarIngrediente();
}
