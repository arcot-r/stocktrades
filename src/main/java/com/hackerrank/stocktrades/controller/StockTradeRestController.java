package com.hackerrank.stocktrades.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.stocktrades.model.StockTrade;
import com.hackerrank.stocktrades.service.StockTradeService;

@RestController
@RequestMapping("/trades")
public class StockTradeRestController {
	@Autowired
	private StockTradeService tradeService;

	@GetMapping
	private ResponseEntity<List<StockTrade>> allTrades() {
		return new ResponseEntity<>(tradeService.getAllTrades(), HttpStatus.OK);
	}

	@PostMapping
	private ResponseEntity<StockTrade> addNewTrade(@RequestBody StockTrade stockTrade) {
		Optional<StockTrade> response = tradeService.createNewTrade(stockTrade);
		if (response.isPresent()) {
			return new ResponseEntity<>(response.get(), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{id}")
	private ResponseEntity<StockTrade> getTradeById(@PathVariable(value = "id") Long id) {
		Optional<StockTrade> response = tradeService.getById(id);
		if (response.isPresent()) {
			return new ResponseEntity<>(response.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<String> deleteTradeById(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
	}

	@PutMapping("/{id}")
	private ResponseEntity<String> partialUpdateTrade(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
	}

	@PatchMapping("/{id}")
	private ResponseEntity<String> patchUpdateTrade(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
	}
}
