package com.uce.edu.demo.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Producto;
import com.uce.edu.demo.repository.IProductoRepository;
@Service
public class ProductoServiceimpl implements IProductoService{

	@Autowired
	private IProductoRepository productoRepository;
	
	
	@Override
	public Producto buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.productoRepository.buscar(id);
	}
	
	
	
	@Override
	public void insertar(Producto p) {
    
		// TODO Auto-generated method stub
		Producto prod = this.productoRepository.buscarProductoBarra(p.getCodigoBarras());
		if (prod==null) {
			this.productoRepository.insertarProducto(p);
		}else {
			Integer stockactual = prod.getStock()+p.getStock();
			prod.setStock(stockactual);
			this.productoRepository.actualizarProducto(prod);
		}
		
	}

	@Override
	public void actualizar(Producto p) {
		// TODO Auto-generated method stub
		this.productoRepository.actualizarProducto(p);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public Producto buscarProductoBarra(String codigoBarra) {
		// TODO Auto-generated method stub
		return this.productoRepository.buscarProductoBarra(codigoBarra);
	}

	@Override
	public Producto buscarProductoStock(String codigoBarra) {
		// TODO Auto-generated method stub
		return this.productoRepository.buscarProductoStock(codigoBarra);
	}
	
	@Override
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		return this.productoRepository.buscarTodos();
	}
	



	
	
	

}
