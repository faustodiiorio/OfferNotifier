package it.offerNotifier.dao.impl;

import java.util.List;

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
	public List<Categoria> getAllCategories() {
		logger.info("STARTING getAllCategories");
		return (List<Categoria>) entityManager.createNamedQuery("getAllCategories").getResultList();
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

	@Override
	public Categoria getCategoryById(Integer idCategoria) {
		logger.info("STARTING getCategoryById");
		if(!idCategoria.equals("") && !idCategoria.toString().isEmpty()){
			logger.info("getCategoryById SUCCESSFULLY RETURNING OBJECT");
			return (Categoria) entityManager.createNamedQuery("getCategoryById").setParameter("idCategoria", idCategoria).getSingleResult();
		}
		logger.info("getCategoryById UNSUCCESSFULLY RETURNING OBJECT");
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
}