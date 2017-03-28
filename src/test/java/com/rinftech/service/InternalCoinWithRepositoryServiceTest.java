package com.rinftech.service;

import com.rinftech.model.Coin;
import com.rinftech.repository.CoinRepository;
import com.rinftech.strategy.impl.InternalCoinWithRepositoryStrategy;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.rinftech.model.Coin.*;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.easymock.EasyMock.*;

/**
 * Created by Cristian Popovici on 3/12/2017.
 */
@RunWith(EasyMockRunner.class)
public class InternalCoinWithRepositoryServiceTest {

    @TestSubject
    private InternalCoinWithRepositoryStrategy internalCoinWithRepositoryService =
            new InternalCoinWithRepositoryStrategy();

    @Mock
    private CoinRepository repositoryMock;

    @Test
    public void testHasAnyAmountIfRepositoryHasCoinShouldPass() throws Exception {
        expect(repositoryMock.getAmountFor(anyObject(Coin.class))).andReturn(1);
        replay(repositoryMock);

        boolean result = internalCoinWithRepositoryService.hasAnyAmount(FIFTY_PENCE);

        assertTrue(result);
    }
    @Test
    public void testHasAnyAmountIfRepositoryHasntCoinShouldPass() throws Exception {
        expect(repositoryMock.getAmountFor(anyObject(Coin.class))).andReturn(0);
        replay(repositoryMock);

        boolean result = internalCoinWithRepositoryService.hasAnyAmount(FIFTY_PENCE);

        assertFalse(result);
    }

    @Test
    public void testsubstractAmountIfRepositoryHasCoinShouldPass() throws Exception {
        repositoryMock.substractAmountFor(anyObject(Coin.class));
        EasyMock.expectLastCall().once();
        replay(repositoryMock);

        internalCoinWithRepositoryService.substractAmount(FIFTY_PENCE);
    }

}