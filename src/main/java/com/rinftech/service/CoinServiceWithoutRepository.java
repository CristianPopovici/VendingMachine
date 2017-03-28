package com.rinftech.service;

import com.rinftech.exception.OutOfMoneyException;
import com.rinftech.model.Coin;
import com.rinftech.strategy.impl.InternalCoinWithoutRepositoryStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by Cristian Popovici on 3/27/2017.
 */
@Component
public class CoinServiceWithoutRepository {

    @Resource
    private InternalCoinWithoutRepositoryStrategy internalCoinWithoutRepositoryService;

    public Collection<Coin> getOptimalChangeFor(int pence) {
        GreedyCoinsReturnService greedyCoinsReturnService = new GreedyCoinsReturnService(
                internalCoinWithoutRepositoryService);
        try {
            return greedyCoinsReturnService.getChangeFor(pence);
        } catch (OutOfMoneyException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Should not reach this place");
    }
}
