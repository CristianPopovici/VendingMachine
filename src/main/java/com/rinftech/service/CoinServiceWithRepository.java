package com.rinftech.service;

import com.rinftech.exception.OutOfMoneyException;
import com.rinftech.model.Coin;
import com.rinftech.strategy.impl.InternalCoinWithRepositoryStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by Cristian Popovici on 3/13/2017.
 */
@Component
public class CoinServiceWithRepository {

    @Resource
    private InternalCoinWithRepositoryStrategy internalCoinWithRepositoryService;

    public Collection<Coin> getChangeFor(int pence) throws OutOfMoneyException {
        GreedyCoinsReturnService greedyCoinsReturnService = new GreedyCoinsReturnService(
                internalCoinWithRepositoryService);
        return greedyCoinsReturnService.getChangeFor(pence);
    }
}
