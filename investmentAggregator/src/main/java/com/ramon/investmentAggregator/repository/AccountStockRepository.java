package com.ramon.investmentAggregator.repository;

import com.ramon.investmentAggregator.entity.AccountStock;
import com.ramon.investmentAggregator.entity.AccountStockId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountStockRepository
        extends JpaRepository<AccountStock, AccountStockId> {
}
