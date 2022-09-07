package com.uce.edu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.modelo.Producto;
import com.uce.edu.demo.service.IProductoService;

@Controller
@RequestMapping("productos")
public class ProductosController {
	
	
	@Autowired
	private IProductoService productoService;
	
	
	
	@GetMapping("/buscar")
    public String buscarProductosTodos(Model modelo) {

        List<Producto> listaProductos = this.productoService.buscarTodos();
        modelo.addAttribute("productos",listaProductos);
        
        return "vistaListaProductos";
    }
	
	
	@GetMapping("/buscarUno/{idProducto}") // {idPersona} será una variable
	public String buscarPersona(@PathVariable("idProducto") Integer id, Model modelo) { //se mapea el parametro a la etiketa 
		System.out.println("El Id: "+ id);
		Producto p = this.productoService.buscar(id);
		modelo.addAttribute("producto", p);
		return "vista";
	}
	

	
	@PostMapping("/insertar")
	public String insertarProducto (Producto producto) {
		this.productoService.insertar(producto);
		return "redirect:/productos/buscar";
	}
	
	//MEtodos de redireccinamientos a paginas
	@GetMapping("/nuevoProducto")
	public String paginaNuevaPersona(Producto producto) {
		return "vistaProductoIngresar";
	}
	
	

}
