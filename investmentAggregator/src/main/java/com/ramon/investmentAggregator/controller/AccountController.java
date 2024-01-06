package com.ramon.investmentAggregator.controller;

import com.ramon.investmentAggregator.dtos.AccountStockResponseDto;
import com.ramon.investmentAggregator.dtos.AssociateAccountStockDto;
import com.ramon.investmentAggregator.entity.Account;
import com.ramon.investmentAggregator.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/accounts")
@Controller
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/{accountId}/stocks")
    public ResponseEntity<Void> associateStock(@PathVariable("accountId") String accountId,
                                              @RequestBody AssociateAccountStockDto associateAccountStockDto) {
        accountService.associateStock(accountId, associateAccountStockDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{accountId}/stocks")
    public ResponseEntity<List<AccountStockResponseDto>> associateStock(@PathVariable("accountId") String accountId) {

        var stocks =  accountService.listStocks(accountId);

        return ResponseEntity.ok(stocks);
    }

}
