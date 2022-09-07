package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.demo.modelo.DetalleVenta;
import com.uce.edu.demo.modelo.Venta;

public interface IVentaService {
	
	void realizarVenta(Venta v);
	
	public void realizarVenta(List<DetalleVenta> detalles, String cedulaCliente,String numeroVenta, BigDecimal totalVenta);



}
