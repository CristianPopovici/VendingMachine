package com.rinftech.repository;

import com.rinftech.model.Coin;
import org.junit.Test;

import java.util.Properties;

import static com.rinftech.integration.util.BaseTestClass.setPrecondition;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.util.ReflectionTestUtils.setField;

/**
 * Created by Cristian Popovici on 3/12/2017.
 */
public class CoinRepositoryTest {

    @Test
    public void getAmountFor() throws Exception {
        CoinRepository coinRepository = new CoinRepository();
        Properties properties = setPrecondition(1, 0, 0, 0, 0, 0, 0);
        setField(coinRepository, "coinProperties", properties);

        assertEquals(coinRepository.getAmountFor(Coin.ONE_POUND), 1);
    }

    @Test
    public void substractAmountFor1Pound() throws Exception {
        CoinRepository coinRepository = new CoinRepository();
        Properties properties = setPrecondition(1, 2, 0, 3, 5, 8, 9);
        setField(coinRepository, "coinProperties", properties);

        coinRepository.substractAmountFor(Coin.ONE_POUND);

        assertEquals(coinRepository.getAmountFor(Coin.ONE_POUND), 0);
    }


}