package com.edudeveloper.erp.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class EntityManagerProducer {
private EntityManagerFactory factory;
	
	public EntityManagerProducer() {
		this.factory = Persistence.createEntityManagerFactory("EdudeveloperPU");
	}
	
	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		return this.factory.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes EntityManager manager) {
		manager.close();
	}
}