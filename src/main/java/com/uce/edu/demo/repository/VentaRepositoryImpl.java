package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Venta;

@Repository
@Transactional
public class VentaRepositoryImpl implements IVentaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	@Transactional (value = TxType.MANDATORY)
	public void realizarVenta(Venta v) {
		// TODO Auto-generated method stub
		this.entityManager.persist(v);
		//throw new RuntimeException();
	}
	
	
}
