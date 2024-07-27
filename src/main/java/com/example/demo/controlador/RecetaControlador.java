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
import com.example.demo.modelo.Receta;
import com.example.demo.servicios.ICalificacionServicio;
import com.example.demo.servicios.ICategoriaServicio;
import com.example.demo.servicios.IRecetaServicio;

@Controller

public class RecetaControlador {
	@Autowired
	public ICategoriaServicio cateService;
	@Autowired
	public IRecetaServicio recetaService;
	@Autowired
	public ICalificacionServicio calificacionService;
	@GetMapping("/listar_receta") 
	public String listarReceta(Model model) {
		List<Receta> listarReceta = recetaService.traerTodosMisRecetasPorCalificacion();
		model.addAttribute("lista", listarReceta);
		return "receta/listaReceta";//ruta fisica de pagina
	} 
	@GetMapping("/receta_nuevo")
	public String nuevoReceta(Model model) {
		List<Categoria> listarCategoria = cateService.listarCategoria();
		List<Receta> listarReceta = recetaService.listarReceta();
		List<Calificacion> listarCalificacion = calificacionService.listarCalificacion();
		
		model.addAttribute("listarCalificacion", listarCalificacion);
		model.addAttribute("listarCategoria", listarCategoria);
		model.addAttribute("listarReceta", listarReceta);
		model.addAttribute("receta", new Receta());
		return "receta/nueva";//ruta fisica de pagina
	}
	@PostMapping("/insertar_receta")
	public String guardarCursoContenido(@ModelAttribute("receta") Receta nuevoReceta) {
		recetaService.insertarReceta(nuevoReceta);
		return "redirect:/listar_receta";
	}
	@GetMapping("/editar_receta/{idreceta}")
	public String editarReceta(@PathVariable(value="idreceta") int idReceta,Model model ){
		List<Categoria> listarCategoria = cateService.listarCategoria();
		model.addAttribute("listarCategoria", listarCategoria);
		List<Calificacion> listarCalificacion = calificacionService.listarCalificacion();
		
		model.addAttribute("listarCalificacion", listarCalificacion);
		Receta recetaRecuperado = recetaService.buscarRecetaId(idReceta);
		model.addAttribute("receta", recetaRecuperado);
		return "receta/nueva";
	}
	
	@GetMapping("/eliminar_receta/{idreceta}")
	public String eliminarReceta(@PathVariable(value="idreceta") int idReceta) {
		boolean recetaEliminado = recetaService.eliminarRecetaId(idReceta);
		return "redirect:/listar_receta";
		
	}
	@GetMapping("/")
	public String redirigirPrincipal() {
		return "redirect:/listar_receta";
		
	}
	@GetMapping("/buscar_receta/{titulo}")
    public String listarRecetaTitulo(@PathVariable(value = "titulo") String titulo, Model model) {
        List<Receta> listarReceta = recetaService.traerTodosMisRecetas(titulo);
        model.addAttribute("lista", listarReceta);
        return "receta/listaReceta";
    }
	
}
