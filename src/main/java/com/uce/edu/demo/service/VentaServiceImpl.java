package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.DetalleVenta;
import com.uce.edu.demo.modelo.Venta;
import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.IVentaRepository;
@Service
public class VentaServiceImpl implements IVentaService {
	
	@Autowired
	private IVentaRepository ventaRepository;

	
	@Override
	public void realizarVenta(Venta v) {
		// TODO Auto-generated method stub
		this.ventaRepository.realizarVenta(v);
	}
	
	@Override
	public void realizarVenta(List<DetalleVenta> detalles, String cedulaCliente, String numeroVenta, BigDecimal totalVenta) {
		// TODO Auto-generated method stub
		Venta v = new Venta();
		v.setCedulaCliente(cedulaCliente);
		v.setNumero(numeroVenta);
		v.setFecha(LocalDateTime.now());
		v.setDetalles(detalles);
		v.setTotalVenta(totalVenta);
		this.ventaRepository.realizarVenta(v);
		
	}

}
