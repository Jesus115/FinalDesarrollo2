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
import com.example.demo.servicios.ICategoriaServicio;

@Controller

public class CategoriaControlador {
	@Autowired
	public ICategoriaServicio cateService;
	@GetMapping("/listar_categoria") 
	public String listarCurso(Model model) {
		List<Categoria> listarCategoria = cateService.listarCategoria();
		model.addAttribute("lista", listarCategoria);
		return "categoria/listaCategoria";//ruta fisica de pagina
	} 
	@GetMapping("/nuevo_categoria") 

	public String agregarCategoria(Model model) {
		model.addAttribute("nuevoCategoria", new Categoria());

		return "categoria/nueva";//ruta fisica de pagina
	} 
	@PostMapping("/insertar_categoria")
	public String guardarCategoria(@ModelAttribute("nuevoCategoria") Categoria nuevoCategoria) {
		cateService.insertarCategoria(nuevoCategoria);
		return "redirect:/listar_categoria";
	}
	@GetMapping("/editar_categoria/{id}")
	public String editarCateoria(@PathVariable(value="id") int id,Model model ){
		Categoria nuevoCategoria = cateService.buscarCategoriaId(id);
		model.addAttribute("nuevoCategoria", nuevoCategoria);
		return "categoria/nueva";
	}
	@GetMapping("/eliminar_categoria/{id}")
	public String eliminarReceta(@PathVariable(value="id") int id) {
		boolean recetaEliminado = cateService.eliminarCategoriaId(id);
		return "redirect:/listar_categoria";
		
	}
	
}
