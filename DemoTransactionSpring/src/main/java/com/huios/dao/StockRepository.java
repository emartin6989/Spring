package com.huios.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.huios.metier.Stock;
import com.huios.service.exceptions.ArticleNotFoundException;

@Transactional
public interface StockRepository extends JpaRepository<Stock,Integer>{
	
	@Modifying
	@Query("Update Stock s SET s.qte=s.qte-?2 where s.id = ?1")
	public void sortArticleDuStock(int id, int qte) ;
	
	@Query("Select s.qte from Stock s where s.id= ?1")
	public int getQteStock(int id);
	
	
	
	

	
}
