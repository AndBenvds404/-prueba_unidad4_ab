package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.modelo.Producto;
import com.uce.edu.demo.modelo.ProductoVenta;

public interface IGestorSupermaxi {
	

	void realizarVenta(List<ProductoVenta> listaProductos, String cedulaCliente, String numeroVenta);
	
	public void reporteVenta(LocalDateTime fechaVenta, String categoria, Integer cantidad);
}
