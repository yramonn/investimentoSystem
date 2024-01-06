package com.ramon.investmentAggregator.service;

import com.ramon.investmentAggregator.dtos.CreateStockDto;
import com.ramon.investmentAggregator.entity.Stock;
import com.ramon.investmentAggregator.repository.StockRepository;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public void createStock(CreateStockDto createStockDto) {

        // DTO -> ENTITY
        var stock = new Stock(
                createStockDto.stockId(),
                createStockDto.description()
        );

        stockRepository.save(stock);
    }
}