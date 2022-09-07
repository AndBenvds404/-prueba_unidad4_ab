package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.modelo.Producto;

public interface IProductoRepository {

	public void insertarProducto(Producto poducto);
	public void actualizarProducto(Producto producto);
	public Producto buscarProductoBarra(String codigoBarra);
	public Producto buscarProductoStock(String codigoBarra);
	public List<Producto> buscarTodos();
	public Producto buscar (Integer id);


}
