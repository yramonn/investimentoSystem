package com.ramon.investmentAggregator.controller;

import com.ramon.investmentAggregator.dtos.CreateStockDto;
import com.ramon.investmentAggregator.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

@RequestMapping("/v1/stocks")
@Controller
public class StockController {

    private StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateStockDto createStockDto) {

          stockService.createStock(createStockDto);

        return ResponseEntity.ok().build();
    }
}
