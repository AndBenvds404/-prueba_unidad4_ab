package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.modelo.DetalleVenta;

public interface IDetalleVentaRespository {

	public List<DetalleVenta> buscar(LocalDateTime fecha, String categoria, Integer cant);
}
