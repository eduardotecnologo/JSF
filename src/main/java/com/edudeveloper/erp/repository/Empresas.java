package com.edudeveloper.erp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.edudeveloper.erp.model.Empresa;

public class Empresas {
	@Inject
	private EntityManager manager;

	public Empresas() {

	}

	public Empresas(EntityManager manager) {
		this.manager = manager;
	}
	public Empresa porId(Long id) {
		return manager.find(Empresa.class, id);
	}
	public List<Empresa> pesquisar(String nome) {

		String jpql = "from Empresa where razaoSocial like :nomeFantasia";

		TypedQuery<Empresa> query = manager.createQuery(jpql, Empresa.class);
		query.setParameter("nomeFantasia", nome + "%");

		return query.getResultList();
	}
	public List<Empresa> todas() {
         return manager.createQuery("from Empresa", Empresa.class).getResultList();
    }

	public Empresa guardar(Empresa empresa) {
		return manager.merge(empresa);
	}

	public void remover(Empresa empresa) {
		empresa = porId(empresa.getId());
		manager.remove(empresa);
	}
}