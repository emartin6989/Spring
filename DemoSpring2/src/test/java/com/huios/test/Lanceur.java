package com.huios.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huios.metier.User;
import com.huios.service.IService;

public class Lanceur {

	public static void main(String[] args) {
		// 1 chargement du contexte
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		// 2 récupération des beans user et service créés par les annotations
		User u = (User) appContext.getBean("user");
		User u2 = (User) appContext.getBean("user");

		u.setNom("fanchon");
		u.setPrenom("tutute");
		u2.setNom("Titi");

		System.out.println("bean user =" + u.getNom());
		System.out.println("bean user2 =" + u2.getNom());
		IService service = (IService) appContext.getBean("serviceImp");

		// 3 utilisation des méthodes des beans
		System.out.println("--------------------------------AJOUTER-----------------------------------");
		service.ajouterUser(u);
		System.out.println("--------------------------------LISTE-----------------------------------");
		List<User> listeU = service.listerUser();
		for (User u3 : listeU) {
			System.out.println(u3);
		}

		System.out.println("--------------------------------SUPPRIMER-----------------------------------");
		//service.supprimerUser(26);
		
		
		System.out.println("--------------------------------MC-----------------------------------");
		List<User> listeMC = service.listerUserParMc("f");
		for (User u4 : listeMC) {
			System.out.println(u4);
		}

		System.out.println("--------------------------------NOM-----------------------------------");
		User u5 = service.listerUserParNom("Toto");
			System.out.println(u5);
	
		// 4 fermeture du contexte
		appContext.close();
	}

}
