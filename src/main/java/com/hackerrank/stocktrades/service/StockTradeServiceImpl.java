package com.hackerrank.stocktrades.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.stocktrades.model.StockTrade;
import com.hackerrank.stocktrades.repository.StockTradeRepository;
@Service
public class StockTradeServiceImpl implements StockTradeService {

	@Autowired
	StockTradeRepository stockTradeRepository;

	@Override
	public List<StockTrade> getAllTrades() {
		return stockTradeRepository.findAll();
	}

	@Override
	public Optional<StockTrade> createNewTrade(StockTrade stockTrade) {
		Optional<StockTrade> fetchedTrade = stockTradeRepository.findById(stockTrade.getId());
		if (!fetchedTrade.isPresent()) {
			return Optional.of(stockTradeRepository.save(stockTrade));
		}else return Optional.empty();
	}

	@Override
	public Optional<StockTrade> getById(Long id) {
		return stockTradeRepository.findById(id.intValue());
	}

}
