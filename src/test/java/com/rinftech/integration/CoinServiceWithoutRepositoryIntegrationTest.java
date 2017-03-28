package com.rinftech.integration;

import com.rinftech.integration.util.BaseTestClass;
import com.rinftech.model.Coin;
import com.rinftech.service.CoinServiceWithoutRepository;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cristian Popovici on 3/12/2017.
 */
public class CoinServiceWithoutRepositoryIntegrationTest extends BaseTestClass {
    @Autowired
    private CoinServiceWithoutRepository coinServiceWithoutRepository;


    @Test
    public void testGetOptimalChangeFor23Pence() {
        Collection<Coin> result = coinServiceWithoutRepository.getOptimalChangeFor(23);
        String expectedResult = "[20 pence, 2 pence, 1 pence]";
        assertThat(result.toString(), Is.is(expectedResult));
    }

    @Test
    public void testGetOptimalChangeFor581Pence() {
        Collection<Coin> result = coinServiceWithoutRepository.getOptimalChangeFor(581);
        String expectedResult = "[100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 50 pence, 20 pence, 10 pence, 1 pence]";
        assertThat(result.toString(), Is.is(expectedResult));
    }

    @Test
    public void testGetOptimalChangeFor7682Pence() {
        Collection<Coin> result = coinServiceWithoutRepository.getOptimalChangeFor(7682);
        String expectedResult = "[100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 50 pence, 20 pence, 10 pence, 2 pence]";
        assertThat(result.toString(), Is.is(expectedResult));
    }

    @Test
    public void testGetOptimalChangeFor9586Pence() {
        Collection<Coin> result = coinServiceWithoutRepository.getOptimalChangeFor(9586);
        String expectedResult = "[100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 100 pence, 50 pence, 20 pence, 10 pence, 5 pence, 1 pence]";
        assertThat(result.toString(), Is.is(expectedResult));
    }

}
