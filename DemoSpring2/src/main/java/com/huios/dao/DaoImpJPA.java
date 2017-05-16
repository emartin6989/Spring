package com.huios.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.huios.metier.User;
@Repository
@Transactional
public class DaoImpJPA implements IDao {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public void ajouterUser(User u) {
	em.persist(u);

	}

	@Override
	public List<User> listerUser() {
		return  em.createQuery("Select u from User u").getResultList();
	}

	@Override
	public void supprimerUser(long id) {
		em.remove(em.find(User.class, id));

	}

	@Override
	public User trouverUser(long id) {
		
		return em.find(User.class, id);
	}

	@Override
	public List<User> listerUserParMc(String nom) {
		Query query = em.createQuery("Select u from User u where u.nom like :nom");
		query.setParameter("nom", "%" + nom + "%");
	 	return query.getResultList();
	}

	@Override
	public User listerUserParNom(String nom) {
		Query query = em.createQuery("Select u from User u where u.nom like :nom");
		query.setParameter("nom", nom );
		query.setMaxResults(1);
	 	return (User) query.getSingleResult();
	}

}
