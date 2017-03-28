package com.rinftech.service;


import com.rinftech.model.Coin;
import com.rinftech.strategy.impl.InternalCoinWithoutRepositoryStrategy;
import org.easymock.Mock;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.MockType.STRICT;
import static org.junit.Assert.assertTrue;

/**
 * Created by Cristian Popovici on 3/12/2017.
 */
public class InternalCoinWithoutRepositoryServiceTest {
    private InternalCoinWithoutRepositoryStrategy internalCoinWithoutRepositoryService;

    @Mock(type = STRICT)
    private Coin coinMock;

    @Before
    public void setUp() {
        internalCoinWithoutRepositoryService = new InternalCoinWithoutRepositoryStrategy();
    }

    @Test
    public void hasAnyAmountShouldAlwaysReturnTrue(){
        boolean response = internalCoinWithoutRepositoryService.hasAnyAmount(coinMock);
        assertTrue(response);
    }

    @Test
    public void subtractAmountShouldntDoAnything(){
        internalCoinWithoutRepositoryService.substractAmount(coinMock);
    }

}