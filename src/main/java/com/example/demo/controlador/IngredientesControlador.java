package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.Categoria;
import com.example.demo.modelo.Ingrediente;
import com.example.demo.servicios.ICategoriaServicio;
import com.example.demo.servicios.IIngredienteServicio;

@Controller
public class IngredientesControlador {
	@Autowired
	public IIngredienteServicio ingService;
	@GetMapping("/listar_ingredientes") 
	public String listarCurso(Model model) {
		List<Ingrediente> listarCategoria = ingService.listarIngrediente();
		model.addAttribute("lista", listarCategoria);
		return "ingrediente/listaIngrediente";//ruta fisica de pagina
	} 
	@GetMapping("/nuevo_ingrediente") 

	public String agregarIngrediente(Model model) {
		model.addAttribute("nuevoIngrediente", new Ingrediente());

		return "ingrediente/nueva";//ruta fisica de pagina
	} 
	@PostMapping("/insertar_ingrediente")
	public String guardarIngrediente(@ModelAttribute("nuevoIngrediente") Ingrediente nuevoIngrediente) {
		ingService.insertarIngrediente(nuevoIngrediente);
		return "redirect:/listar_ingredientes";
	}
	@GetMapping("/editar_ingrediente_unico/{id}")
	public String editarCateoria(@PathVariable(value="id") int id,Model model ){
		Ingrediente nuevoCategoria = ingService.buscarIngredienteId(id);
		model.addAttribute("nuevoIngrediente", nuevoCategoria);
		return "ingrediente/nueva";
	}
	@GetMapping("/eliminar_ingrediente/{id}")
	public String eliminarReceta(@PathVariable(value="id") int id) {
		boolean recetaEliminado = ingService.eliminarIngredienteId(id);
		return "redirect:/listar_ingredientes";
		
	}
}
