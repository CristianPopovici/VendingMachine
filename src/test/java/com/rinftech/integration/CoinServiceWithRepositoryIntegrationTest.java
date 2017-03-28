package com.rinftech.integration;

import com.rinftech.exception.OutOfMoneyException;
import com.rinftech.integration.util.BaseTestClass;
import com.rinftech.model.Coin;
import com.rinftech.repository.CoinRepository;
import com.rinftech.service.CoinServiceWithRepository;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.util.ReflectionTestUtils.setField;

/**
 * Created by Cristian Popovici on 3/12/2017.
 */
public class CoinServiceWithRepositoryIntegrationTest extends BaseTestClass {
    @Autowired
    private CoinServiceWithRepository coinServiceWithRepository;
    @Autowired
    private CoinRepository coinRepository;

    @Test
    public void testGetChangeFor23Pence() throws OutOfMoneyException {
        Properties properties = setPrecondition(1, 1, 0, 1, 2, 1, 1);
        setField(coinRepository, "coinProperties", properties);
        Collection<Coin> result = coinServiceWithRepository.getChangeFor(23);
        String expectedResult = "[10 pence, 5 pence, 5 pence, 2 pence, 1 pence]";
        assertThat(result.toString(), Is.is(expectedResult));
    }

    @Test
    public void testGetChangeFor581Pence() throws OutOfMoneyException {
        Properties properties = setPrecondition(3, 5, 0, 1, 4, 10, 1);
        setField(coinRepository, "coinProperties", properties);
        Collection<Coin> result = coinServiceWithRepository.getChangeFor(581);
        String expectedResult = "[100 pence, 100 pence, 100 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 10 pence, 5 pence, 5 pence, 5 pence, 5 pence, 1 pence]";
        assertThat(result.toString(), Is.is(expectedResult));
    }

    @Test
    public void testGetChangeFor7682Pence() throws OutOfMoneyException {
        Properties properties = setPrecondition(60, 30, 40, 1, 4, 10, 1);
        setField(coinRepository, "coinProperties", properties);
        Collection<Coin> result = coinServiceWithRepository.getChangeFor(7682);
        String expectedResult = "[100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 20 pence, 20 pence, 20 pence, 20 pence, 20 pence, 20 pence, 20 pence, 20 pence, 20 pence, 2 pence]";
        assertThat(result.toString(), Is.is(expectedResult));
    }

    @Test
    public void testGetChangeFor9586Pence() throws OutOfMoneyException {
        Properties properties = setPrecondition(80, 30, 40, 1, 4, 10, 1);
        setField(coinRepository, "coinProperties", properties);
        Collection<Coin> result = coinServiceWithRepository.getChangeFor(9586);
        String expectedResult = "[100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 20 pence, 20 pence, 20 pence, 20 pence, 5 pence, 1 pence]";
        assertThat(result.toString(), Is.is(expectedResult));
    }

    @Test(expected = OutOfMoneyException.class)
    public void testGetChangeFor9586PenceInsuficientRepository() throws OutOfMoneyException {
        Properties properties = setPrecondition(40, 30, 40, 1, 4, 10, 1);
        setField(coinRepository, "coinProperties", properties);
        Collection<Coin> result = coinServiceWithRepository.getChangeFor(9586);
        String expectedResult = "[100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 20 pence, 20 pence, 20 pence, 20 pence, 5 pence, 1 pence]";
        assertThat(result.toString(), Is.is(expectedResult));
    }

    @Test(expected = OutOfMoneyException.class)
    public void testGetChangeFor23PenceInsuficientRepository() throws OutOfMoneyException {
        Properties properties = setPrecondition(40, 30, 0, 1, 0, 0, 1);
        setField(coinRepository, "coinProperties", properties);
        Collection<Coin> result = coinServiceWithRepository.getChangeFor(9586);
        String expectedResult = "[100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 50 pence, 20 pence, 20 pence, 20 pence, 20 pence, 5 pence, 1 pence]";
        assertThat(result.toString(), Is.is(expectedResult));
    }

}
