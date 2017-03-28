package com.rinftech.service;

import com.rinftech.exception.OutOfMoneyException;
import com.rinftech.model.Coin;
import com.rinftech.strategy.InternalCoinStrategy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static com.rinftech.model.Coin.*;
import static java.util.Arrays.asList;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Cristian Popovici on 3/12/2017.
 */
public class GreedyCoinsReturnServiceTest {

    @Test
    public void testStrategyWithUnlimitedRepository() throws OutOfMoneyException {
        InternalCoinStrategy internalCoinServiceMock = createNiceMock(InternalCoinStrategy.class);
        expect(internalCoinServiceMock.hasAnyAmount(anyObject(Coin.class)))
                .andReturn(true).anyTimes();
        internalCoinServiceMock.substractAmount(anyObject(Coin.class));
        expectLastCall().anyTimes();
        replay(internalCoinServiceMock);
        GreedyCoinsReturnService greedyCoinsReturnStrategy = new GreedyCoinsReturnService(internalCoinServiceMock);
        Collection<Coin> expectedList = new ArrayList<>(asList(ONE_POUND, ONE_POUND, ONE_POUND, ONE_POUND, ONE_POUND,
                ONE_POUND, ONE_POUND, ONE_POUND, ONE_POUND, ONE_POUND, ONE_POUND, ONE_POUND, ONE_POUND, ONE_POUND, ONE_POUND,
                ONE_POUND, ONE_POUND, ONE_POUND, ONE_POUND, ONE_POUND));

        Collection<Coin> result = greedyCoinsReturnStrategy.getChangeFor(2000);

        assertEquals(expectedList, result);
    }


    @Test(expected = OutOfMoneyException.class)
    public void testStrategyWithNoMoneyInRepository() throws OutOfMoneyException {
        InternalCoinStrategy internalCoinServiceMock = createNiceMock(InternalCoinStrategy.class);
        expect(internalCoinServiceMock.hasAnyAmount(anyObject(Coin.class)))
                .andReturn(false).anyTimes();
        internalCoinServiceMock.substractAmount(anyObject(Coin.class));
        expectLastCall().anyTimes();
        replay(internalCoinServiceMock);
        GreedyCoinsReturnService greedyCoinsReturnStrategy = new GreedyCoinsReturnService(internalCoinServiceMock);

        Collection<Coin> result = greedyCoinsReturnStrategy.getChangeFor(188);
    }

    @Test
    public void testStrategyWithLimitedMoneyInRepository() throws OutOfMoneyException {
        InternalCoinStrategy internalCoinServiceMock = createNiceMock(InternalCoinStrategy.class);
        expect(internalCoinServiceMock.hasAnyAmount(anyObject(Coin.class)))
                .andReturn(false).once();
        expect(internalCoinServiceMock.hasAnyAmount(anyObject(Coin.class)))
                .andReturn(true).once();
        expect(internalCoinServiceMock.hasAnyAmount(anyObject(Coin.class)))
                .andReturn(false).once();
        expect(internalCoinServiceMock.hasAnyAmount(anyObject(Coin.class)))
                .andReturn(true).anyTimes();
        internalCoinServiceMock.substractAmount(anyObject(Coin.class));
        expectLastCall().anyTimes();
        replay(internalCoinServiceMock);
        GreedyCoinsReturnService greedyCoinsReturnStrategy = new GreedyCoinsReturnService(internalCoinServiceMock);
        Collection<Coin> expectedList = new ArrayList<>(asList(FIFTY_PENCE, TWENTY_PENCE, TWENTY_PENCE, TEN_PENCE));

        Collection<Coin> result = greedyCoinsReturnStrategy.getChangeFor(100);

        assertEquals(expectedList, result);
    }

}