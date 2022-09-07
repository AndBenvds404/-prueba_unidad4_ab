package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Producto;
@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository{

	Logger log = LoggerFactory.getLogger(ProductoRepositoryImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Producto buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Producto.class, id);
	}
	
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertarProducto(Producto poducto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(poducto);
	}
	
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizarProducto(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}
	
	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscarProductoBarra(String codigoBarra) {
		
			try {
				TypedQuery<Producto> miTypedQuery = (TypedQuery<Producto>) this.entityManager
						.createQuery("SELECT p FROM Producto p  WHERE p.codigoBarras = :datocodigoBarra", Producto.class);
				miTypedQuery.setParameter("datocodigoBarra", codigoBarra);
				return miTypedQuery.getSingleResult();
			}catch(NoResultException e) {
				log.info("no hay stock");
				return null;
			}
	}

	@Override
	@Transactional (value = TxType.NOT_SUPPORTED)
	public Producto buscarProductoStock(String codigoBarra) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Producto> myQuery = myCriteria.createQuery(Producto.class);

		Root<Producto> myTabla = myQuery.from(Producto.class);

		Predicate predicado = myCriteria.equal(myTabla.get("codigoBarras"), codigoBarra);

		myQuery.select(myTabla).where(predicado);
		TypedQuery<Producto> myQueryFinal = this.entityManager.createQuery(myQuery);

		return myQueryFinal.getSingleResult();
	}

	
	@Override
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT p FROM Producto p",Producto.class);
		return myQuery.getResultList();
	}
	




}
