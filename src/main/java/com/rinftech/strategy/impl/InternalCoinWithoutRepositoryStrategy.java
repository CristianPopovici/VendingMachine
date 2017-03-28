package com.rinftech.strategy.impl;

import com.rinftech.model.Coin;
import com.rinftech.strategy.InternalCoinStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Cristian Popovici on 3/12/2017.
 */
@Component
@Qualifier("internalCoinWithoutRepositoryService")
public class InternalCoinWithoutRepositoryStrategy implements InternalCoinStrategy {

    @Override
    public boolean hasAnyAmount(Coin coin) {
        return true;
    }

    @Override
    public void substractAmount(Coin coin) {

    }
}
