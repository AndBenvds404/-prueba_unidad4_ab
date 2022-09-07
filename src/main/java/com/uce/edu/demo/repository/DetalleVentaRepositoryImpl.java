package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.DetalleVenta;

@Repository
@Transactional
public class DetalleVentaRepositoryImpl implements IDetalleVentaRespository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<DetalleVenta> buscar(LocalDateTime fecha, String categoria, Integer cant) {
		// TODO Auto-generated method stub
		
		TypedQuery<DetalleVenta> myQuery = this.entityManager.createQuery("SELECT d FROM DetalleVenta d JOIN FETCH d.venta ve, d.producto pr WHERE ve.fecha = :datoFecha AND pr.categoria = :datoCategoria AND d.cantidad >= datoCantidad",DetalleVenta.class);
		myQuery.setParameter("datoFecha", fecha);
		myQuery.setParameter("datoCategoria", categoria);
		myQuery.setParameter("datoCantidad", cant);

		return myQuery.getResultList();
	}

}
