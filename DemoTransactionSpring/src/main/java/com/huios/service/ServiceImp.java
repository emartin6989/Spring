package com.huios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huios.dao.StockRepository;
import com.huios.metier.Stock;
import com.huios.service.exceptions.ArticleNotFoundException;
import com.huios.service.exceptions.NotEnoughArticleException;
import com.huios.service.exceptions.QteNegativeException;

@Service
public class ServiceImp implements IService {
	
	@Autowired
	private StockRepository stock;
	
	/* (non-Javadoc)
	 * @see com.huios.service.IService#sortArticleDuStock(int, int)
	 */
	public void sortArticleDuStock(int id, int qte) throws ArticleNotFoundException, QteNegativeException, NotEnoughArticleException {
		
		if(qte<0){
			throw new QteNegativeException();
		}
		if(!stock.exists(id)){
			throw new ArticleNotFoundException();
		}
		if(qte>=stock.findOne(id).getQte()){
			throw new NotEnoughArticleException();
		}
		stock.sortArticleDuStock(id, qte);
	}
	
	/* (non-Javadoc)
	 * @see com.huios.service.IService#getQteStock(int)
	 */
	public int getQteStock(int id) throws ArticleNotFoundException {
		if(!stock.exists(id)){
			throw new ArticleNotFoundException();
		}
		return stock.getQteStock(id);
	}
	
	public void ajouter(Stock s){
		stock.save(s);
	}

}
