package com.huios.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huios.metier.Stock;
import com.huios.service.IService;
import com.huios.service.exceptions.ArticleNotFoundException;
import com.huios.service.exceptions.NotEnoughArticleException;
import com.huios.service.exceptions.QteNegativeException;

public class Lanceur {

	public static void main(String[] args) throws ArticleNotFoundException, QteNegativeException, NotEnoughArticleException {
		// TODO Auto-generated method stub
		// 1 chargement du contexte
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2 recuperation des beans
		IService service = (IService) appContext.getBean("serviceImp");
		Stock s= (Stock) appContext.getBean("stock");
		
		s.setNom("ordi");
		s.setQte(40);
		service.ajouter(s);
		s.setNom("clavier");
		s.setQte(60);
		service.ajouter(s);
		s.setNom("souris");
		s.setQte(50);
		service.ajouter(s);
		s.setNom("ecran");
		s.setQte(10);
		service.ajouter(s);
		
		try {
			service.sortArticleDuStock(3,90);
		} catch (ArticleNotFoundException e) {
		e.printStackTrace();
		}
		
		
		appContext.close();
		
		

	}

}
