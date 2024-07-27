package com.example.demo;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.modelo.Calificacion;
import com.example.demo.modelo.Categoria;
import com.example.demo.servicios.ICalificacionServicio;
import com.example.demo.servicios.ICategoriaServicio;
import com.example.demo.servicios.IRecetaServicio;

@SpringBootTest
class UisraelApplicationTests {
	@Autowired
	public ICategoriaServicio cateService;
	@Autowired
	public IRecetaServicio recetaService;
	@Autowired
	public ICalificacionServicio calificacionService;
	@Test
	void contextLoads() {
		Calificacion nuevo5 =new Calificacion();
		nuevo5.setPuntuacion(5);
		calificacionService.insertarCalificacion(nuevo5);
		Calificacion nuevo4 =new Calificacion();
		nuevo4.setPuntuacion(4);
		calificacionService.insertarCalificacion(nuevo4);
		Calificacion nuevo3 =new Calificacion();
		nuevo3.setPuntuacion(3);
		calificacionService.insertarCalificacion(nuevo3);
		Calificacion nuevo2 =new Calificacion();
		nuevo2.setPuntuacion(2);
		calificacionService.insertarCalificacion(nuevo2);
		Calificacion nuevo =new Calificacion();
		nuevo.setPuntuacion(1);
		calificacionService.insertarCalificacion(nuevo);
		
		Categoria nuevoCategoria =new Categoria();
		nuevoCategoria.setNombre("Postre");
		cateService.insertarCategoria(nuevoCategoria);
		Categoria nuevoCategoriaGourmet =new Categoria();
		nuevoCategoriaGourmet.setNombre("Gourmet");
		cateService.insertarCategoria(nuevoCategoriaGourmet);
		Categoria nuevoCategoriaHogar =new Categoria();
		nuevoCategoriaHogar.setNombre("Hogar");
		cateService.insertarCategoria(nuevoCategoriaHogar);
	}

}
