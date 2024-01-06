package com.ramon.investmentAggregator.service;

import com.ramon.investmentAggregator.dtos.AccountStockResponseDto;
import com.ramon.investmentAggregator.dtos.AssociateAccountStockDto;
import com.ramon.investmentAggregator.entity.AccountStock;
import com.ramon.investmentAggregator.entity.AccountStockId;
import com.ramon.investmentAggregator.repository.AccountRepository;
import com.ramon.investmentAggregator.repository.AccountStockRepository;
import com.ramon.investmentAggregator.repository.StockRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {
    private AccountRepository accountRepository;
    private StockRepository stockRepository;

    private AccountStockRepository accountStockRepository;

    public AccountService(AccountRepository accountRepository, StockRepository stockRepository, AccountRepository accountRepository1) {
        this.accountRepository = accountRepository;
        this.stockRepository = stockRepository;
        this.accountRepository = accountRepository1;
    }

    public void associateStock(String accountId, AssociateAccountStockDto associateAccountStockDto) {

        var account = accountRepository.findById(UUID.fromString(accountId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        var stock = stockRepository.findById(associateAccountStockDto.stockId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        //DTO -> ENTITY
        var id = new AccountStockId(account.getAccountId(), stock.getStockId());
        var entity = new AccountStock(
                id,
                account,
                stock,
                associateAccountStockDto.quantity()
        );

        accountStockRepository.save(entity);
    }

    public List<AccountStockResponseDto> listStocks(String accountId) {

        var account = accountRepository.findById(UUID.fromString(accountId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return account.getAccountStocks()
                .stream()
                .map(accountStock ->
                        new AccountStockResponseDto(accountStock.getStock().getStockId(), accountStock.getQuantity(), 0.0))
                .toList();
    }
}
