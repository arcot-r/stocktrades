package com.hackerrank.stocktrades.service;

import java.util.List;
import java.util.Optional;

import com.hackerrank.stocktrades.model.StockTrade;

public interface StockTradeService {

	public List<StockTrade> getAllTrades() ;

	public Optional<StockTrade> createNewTrade(StockTrade stockTrade) ;

	public Optional<StockTrade> getById(Long id);

}
