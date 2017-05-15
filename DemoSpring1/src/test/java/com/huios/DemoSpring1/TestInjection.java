package com.huios.DemoSpring1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInjection {

	public static void main(String[] args) {
		// 1- chargement du conteneur et création des beans
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		// 2- récupération du bean societe
		SocieteDevLogiciel societe = (SocieteDevLogiciel) appContext.getBean("societe");

		// 3- traitement (affichage du bean société)
		System.out.println(societe);

		// 4- tuer le contexte
		appContext.close();
	}

}
