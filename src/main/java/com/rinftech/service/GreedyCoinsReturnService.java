package com.rinftech.service;

import com.rinftech.exception.OutOfMoneyException;
import com.rinftech.model.Coin;
import com.rinftech.strategy.InternalCoinStrategy;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Cristian Popovici on 3/12/2017.
 */
public class GreedyCoinsReturnService  {

    private final InternalCoinStrategy internalCoinStrategy;

    public GreedyCoinsReturnService(InternalCoinStrategy service) {
        internalCoinStrategy = service;
    }

    public Collection<Coin> getChangeFor(int remainingPence) throws OutOfMoneyException {
        Collection<Coin> coinList = new ArrayList<>();
        for (Coin coinDenomination : Coin.values()) {
            int denomination = coinDenomination.getDenomination();
            while (remainingPence >= denomination && internalCoinStrategy.hasAnyAmount(coinDenomination)) {
                coinList.add(coinDenomination);
                internalCoinStrategy.substractAmount(coinDenomination);
                remainingPence = remainingPence - denomination;
            }
        }
        checkIfChangeCanBeProvided(remainingPence);
        return coinList;
    }

    private void checkIfChangeCanBeProvided(int remainingPence) throws OutOfMoneyException {
        if (remainingPence != 0) {
            throw new OutOfMoneyException();
        }
    }
}
