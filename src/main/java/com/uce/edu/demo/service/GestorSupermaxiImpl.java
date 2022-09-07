package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.DetalleVenta;
import com.uce.edu.demo.modelo.Producto;
import com.uce.edu.demo.modelo.ProductoVenta;
import com.uce.edu.demo.repository.IDetalleVentaRespository;
import com.uce.edu.demo.repository.IProductoRepository;

@Service
public class GestorSupermaxiImpl implements IGestorSupermaxi {


	@Autowired
	private IVentaService ventaService;
	@Autowired
	private IProductoRepository productoRepository;

	@Autowired
	private IDetalleVentaRespository detalleVentaRespository;
	
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void realizarVenta(List<ProductoVenta> listaProductos, String cedulaCliente, String numeroVenta) {

		Producto producto = new Producto();
		DetalleVenta detalle = new DetalleVenta();

		List<DetalleVenta> detalles = new ArrayList<DetalleVenta>();
		BigDecimal totalVenta = BigDecimal.ZERO;
		Integer cantidad = 0;

		for (ProductoVenta p : listaProductos) {
			producto = this.productoRepository.buscarProductoBarra(p.getCodigoBarras());
			cantidad = p.getCantidad();

			if (producto == null || producto.getStock() == 0) {
				throw new RuntimeException();
			}
			if (cantidad > producto.getStock()) {
				cantidad = producto.getStock();
			}
			detalle.setProducto(producto);
			detalle.setCantidad(cantidad);

			producto.setStock(producto.getStock() - cantidad);
			this.productoRepository.actualizarProducto(producto);

			detalle.setPrecioUnitario(producto.getPrecio());
			BigDecimal subtotal = producto.getPrecio().multiply(new BigDecimal(cantidad));
			detalle.setSubtotal(subtotal);
			totalVenta.add(subtotal);
			detalles.add(detalle);
		}

		this.ventaService.realizarVenta(detalles, cedulaCliente, numeroVenta, totalVenta);

	}
	
	
	@Override
	public void reporteVenta(LocalDateTime fechaVenta, String categoria, Integer cantidad) {
		// TODO Auto-generated method stub

	}
	
	
	
	


	

}
