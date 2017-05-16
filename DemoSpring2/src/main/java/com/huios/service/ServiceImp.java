package com.huios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.huios.dao.IDao;
import com.huios.metier.User;

@Service
public class ServiceImp implements IService {

	@Autowired
	@Qualifier("daoImpJPA")
	private IDao dao;

	@Override
	public void ajouterUser(User u) {
		dao.ajouterUser(u);

	}

	@Override
	public List<User> listerUser() {
		// TODO Auto-generated method stub
		return dao.listerUser();
	}

	@Override
	public void supprimerUser(long id) {
		dao.supprimerUser(id);

	}

	@Override
	public User trouverUser(long id) {
		// TODO Auto-generated method stub
		return dao.trouverUser(id);
	}

	@Override
	public List<User> listerUserParMc(String nom) {
		// TODO Auto-generated method stub
		return dao.listerUserParMc(nom);
	}

	@Override
	public User listerUserParNom(String nom) {
		// TODO Auto-generated method stub
		return dao.listerUserParNom(nom);
	}

}
