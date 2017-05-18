package com.huios.service;

import com.huios.metier.Stock;
import com.huios.service.exceptions.ArticleNotFoundException;
import com.huios.service.exceptions.NotEnoughArticleException;
import com.huios.service.exceptions.QteNegativeException;

public interface IService {

	public void sortArticleDuStock(int id, int qte) throws ArticleNotFoundException, QteNegativeException, NotEnoughArticleException;

	public int getQteStock(int id) throws ArticleNotFoundException;
	
	public void ajouter(Stock s);

}