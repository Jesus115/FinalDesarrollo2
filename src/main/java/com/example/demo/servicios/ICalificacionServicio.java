package com.example.demo.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.modelo.Calificacion;
import com.example.demo.modelo.Categoria;
@Service

public interface ICalificacionServicio {
	public List<Calificacion> listarCalificacion();
	public void insertarCalificacion(Calificacion nuevoCalificacion);
	public Calificacion bucarCalificacionId(int id);
	public boolean eliminarCalificacionId(int id);
}

