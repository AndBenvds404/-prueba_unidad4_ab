package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.modelo.Producto;
import com.uce.edu.demo.modelo.ProductoVenta;
import com.uce.edu.demo.service.IGestorSupermaxi;
import com.uce.edu.demo.service.IProductoService;

@SpringBootApplication
public class PruebaUnidad4AbApplication  implements CommandLineRunner {

	Logger log = LoggerFactory.getLogger(PruebaUnidad4AbApplication.class);
	
	@Autowired
	private IGestorSupermaxi gestorSupermaxi;
	@Autowired
	private IProductoService productoService;
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad4AbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		

		Producto p2 = new Producto();
		p2.setCodigoBarras("0005");
		p2.setNombre("leche");
		p2.setCategoria("lacteo");
		p2.setPrecio(new BigDecimal(2));
		p2.setStock(20);
		//si se vuelve a ingresar se sumara al stock en caso de existir el producto
		//caso contario se insertará uno nuevo
		//this.productoService.insertar(p2);
	
		List<ProductoVenta> listaProd = new ArrayList<>();
		ProductoVenta pv = new ProductoVenta();
		pv.setCantidad(1);
		pv.setCodigoBarras("0006");
		listaProd.add(pv);
		
		this.gestorSupermaxi.realizarVenta(listaProd, "1728", "002");
		
		
		
		
	}

}
