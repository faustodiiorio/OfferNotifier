package it.offerNotifier.dao.impl;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import it.offerNotifier.dao.CategoriaDao;
import it.offerNotifier.model.Categoria;

@Repository
public class CategoriaDaoImpl implements CategoriaDao {
	@PersistenceContext(unitName="offerNotifierDS")
	private EntityManager entityManager;
	private Logger logger = Logger.getLogger(CategoriaDaoImpl.class);
	
	@Override
	public Set<Categoria> getAllCategories() {
		logger.info("STARTING getAllCategories");
		return (Set<Categoria>) entityManager.createNamedQuery("getAllCategories").getResultList();
	}

	@Override
	public Categoria getCategoryByName(String nomeCategoria) {
		logger.info("STARTING getCategoryByName");
		if(!nomeCategoria.equals("") && !nomeCategoria.isEmpty()){
			logger.info("getCategoryByName SUCCESSFULLY RETURNING OBJECT");
			return (Categoria) entityManager.createNamedQuery("getCategoryByName").setParameter("nomeCategoria", nomeCategoria).getSingleResult();
		}
		logger.info("getCategoryByName UNSUCCESSFULLY RETURNING OBJECT");
		return null;
	}

	public EntityManager getEntityManager() {
		if(!entityManager.equals(null) && !entityManager.isOpen()){
			logger.info("getEntityManager CategoriaDaoImpl SUCCESSFULLY returning object");
			return entityManager;
		}
		logger.info("getEntityManager CategoriaDaoImpl UNSUCCESSFULLY returning object");
		return null;
	}

	@Override
	public Set<Categoria> getCategoriesById(Integer idCategoria) {
		logger.info("STARTING getCategoriesById");
		if(!idCategoria.equals("") && !idCategoria.toString().isEmpty()){
			logger.info("getCategoriesById SUCCESSFULLY RETURNING OBJECT");
			return (Set<Categoria>) entityManager.createNamedQuery("getCategoriesById").setParameter("idCategoria", idCategoria).getResultList();
		}
		logger.info("getCategoryByName UNSUCCESSFULLY RETURNING OBJECT");
		return null;
	}

	@Override
	public Categoria getCategoryByPK(int id) {
		return entityManager.find(Categoria.class, id);
	}

	@Override
	public void persist(Categoria categoria) {
		entityManager.persist(categoria);
	}
}