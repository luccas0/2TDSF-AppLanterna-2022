package com.fiap.luccas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.fiap.luccas.model.Serie;


public class SerieDao {
	
	EntityManagerFactory  factory = Persistence.createEntityManagerFactory("progamer-persistence-unit");
	EntityManager manager = factory.createEntityManager();
	
	//private EntityManager manager;
	
	public void create (Serie serie) {
		manager.getTransaction().begin();
		manager.persist(serie);
		manager.getTransaction().commit();
		
		manager.clear();
	}
	
	public List<Serie> listAll() {
		TypedQuery<Serie> query = manager.createQuery("SELECT s FROM User s", Serie.class);
		return query.getResultList();
	}
	
	public void remove (Serie serie) {
		manager.getTransaction().begin();
		manager.remove(serie);
		manager.getTransaction().commit();
	}
	
	public void update (Serie serie) {
		manager.getTransaction().begin();
		manager.merge(serie);
		manager.getTransaction().begin();
	}

}
