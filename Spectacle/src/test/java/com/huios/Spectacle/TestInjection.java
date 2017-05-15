package com.huios.Spectacle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import metier.MultiInstrumentiste;
import metier.Performeur;

public class TestInjection {

	public static void main(String[] args) {
		// 1- chargement du conteneur et création des beans
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("spectacle.xml");

		// 2- récupération des beans musiciens
		Performeur olivier = (Performeur) appContext.getBean("olivier");
		Performeur caroline = (Performeur) appContext.getBean("caroline");
		Performeur jeanmarc = (Performeur) appContext.getBean("jeanmarc");
		MultiInstrumentiste julien = (MultiInstrumentiste) appContext.getBean("julien");
		MultiInstrumentiste alain = (MultiInstrumentiste) appContext.getBean("alain");
		Performeur louis = (Performeur) appContext.getBean("louis");
		Performeur michel = (Performeur) appContext.getBean("michel");
		Performeur maurice = (Performeur) appContext.getBean("maurice");
		Performeur martin = (Performeur) appContext.getBean("martin");
		Performeur monMusicien= (Performeur) appContext.getBean("monMusicien");
		
		// 3- traitement (affichage des musiciens)
		System.out.println("Olivier");
		olivier.performe();

		System.out.println("Jean-Marc");
		jeanmarc.performe();

		System.out.println("Caroline");
		caroline.performe();

		System.out.println("Julien");
		julien.performe();

		System.out.println("Alain");
		alain.performe();

		System.out.println("Louis");
		louis.performe();

		System.out.println("Michel");
		michel.performe();

		System.out.println("Maurice");
		maurice.performe();
		
		System.out.println("Martin");
		martin.performe();
		
		System.out.println("mon Musicien");
		monMusicien.performe();

		// 4- tuer le contexte
		appContext.close();
	}

}
