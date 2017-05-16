package com.huios.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.huios.metier.User;

@Repository
@Transactional
public class DaoImpHibernate implements IDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void ajouterUser(User u) {
		getSession().save(u);
		System.out.println("AJOUTER VIA HIBERNATE");

	}

	@Override
	public List<User> listerUser() {
		String hql = "FROM User";
		Query query = getSession().createQuery(hql);
		return query.list();
	}
	
	@Override
	public void supprimerUser(long id) {
	getSession().delete(trouverUser(id));
	}

	@Override
	public User trouverUser(long id) {
		 User u= getSession().get(User.class, id);
		return u;
	}

	@Override
	public List<User> listerUserParMc(String nom) {
		String hql = "FROM User as u WHERE u.nom like :nom";
	Query query = getSession().createQuery(hql);
	query.setParameter("nom", "%"+nom+"%");
		return query.list();
	}

	@Override
	public User listerUserParNom(String nom) {
		String hql = "FROM User as u WHERE u.nom like :nom";
		Query query = getSession().createQuery(hql);
		query.setParameter("nom", nom);
		query.setMaxResults(1);
			return (User) query.getSingleResult();
	}

}
