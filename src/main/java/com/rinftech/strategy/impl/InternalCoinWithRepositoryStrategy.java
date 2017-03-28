package com.rinftech.strategy.impl;

import com.rinftech.model.Coin;
import com.rinftech.repository.CoinRepository;
import com.rinftech.strategy.InternalCoinStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Cristian Popovici on 3/12/2017.
 */
@Component
@Qualifier("internalCoinWithRepositoryService")
public class InternalCoinWithRepositoryStrategy implements InternalCoinStrategy {

    @Autowired
    private CoinRepository repository;

    @Override
    public boolean hasAnyAmount(Coin coin) {
        return repository.getAmountFor(coin) != 0;

    }

    @Override
    public void substractAmount(Coin coin) {
        repository.substractAmountFor(coin);
    }
}
