package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.modelo.Producto;

public interface IProductoService {
	
	public void insertar(Producto poducto);
	public void actualizar(Producto producto);
	public Producto buscarProductoBarra(String codigoBarra);
	public Producto buscarProductoStock(String  codigoBarra);
	public List<Producto> buscarTodos();
	public Producto buscar(Integer id);

}
