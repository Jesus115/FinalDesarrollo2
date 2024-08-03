package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.Calificacion;
import com.example.demo.modelo.Categoria;
import com.example.demo.servicios.ICalificacionServicio;
import com.example.demo.servicios.ICategoriaServicio;

@Controller
public class CalificacionControlador {
	@Autowired
	public ICalificacionServicio caliService;
	@GetMapping("/listar_calificacion") 
	public String listarCalificacion(Model model) {
		List<Calificacion> listarCalificacion = caliService.listarCalificacion();
		model.addAttribute("lista", listarCalificacion);
		return "calificacion/listarCalificacion";//ruta fisica de pagina
	} 
	
	@GetMapping("/nuevo_calificacion") 

	public String agregarCalificacion(Model model) {
		model.addAttribute("nuevoCalificacion", new Calificacion());

		return "calificacion/nueva";//ruta fisica de pagina
	} 
	@PostMapping("/insertar_calificacion")
	public String guardarCalificacion(@ModelAttribute("nuevoCalificacion") Calificacion nuevoCalificacion) {
		caliService.insertarCalificacion(nuevoCalificacion);
		return "redirect:/listar_calificacion";
	}
	@GetMapping("/editar_calificacion/{id}")
	public String editarCalificacion(@PathVariable(value="id") int id,Model model ){
		Calificacion nuevoCategoria = caliService.bucarCalificacionId(id);
		model.addAttribute("nuevoCategoria", nuevoCategoria);
		return "calificacion/nueva";
	}
	@GetMapping("/eliminar_calificacion/{id}")
	public String eliminarReceta(@PathVariable(value="id") int id) {
		boolean recetaEliminado = caliService.eliminarCalificacionId(id);
		return "redirect:/listar_calificacion";
		
	}
}
