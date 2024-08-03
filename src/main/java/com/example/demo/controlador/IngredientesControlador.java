package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.modelo.Categoria;
import com.example.demo.servicios.ICategoriaServicio;

@Controller
public class IngredientesControlador {
	@Autowired
	public ICategoriaServicio cateService;
	@GetMapping("/listar_categoria") 
	public String listarCurso(Model model) {
		List<Categoria> listarCategoria = cateService.listarCategoria();
		model.addAttribute("lista", listarCategoria);
		return "categoria/listaCategoria";//ruta fisica de pagina
	} 
}
