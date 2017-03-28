package com.rinftech.integration.util;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Properties;

/**
 * Created by Cristian Popovici on 3/12/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public abstract class BaseTestClass {

    @Configuration
    @ComponentScan(basePackages = {"com.rinftech"})
    static class TestConfiguration {
    }

    public static Properties setPrecondition(int pounds, int fiftyPence, int twentyPence, int tenPence, int fivePence, int twoPence, int penny) {
        Properties properties = new Properties();
        properties.setProperty("100", Integer.toString(pounds));
        properties.setProperty("50", Integer.toString(fiftyPence));
        properties.setProperty("20", Integer.toString(twentyPence));
        properties.setProperty("10", Integer.toString(tenPence));
        properties.setProperty("5", Integer.toString(fivePence));
        properties.setProperty("2", Integer.toString(twoPence));
        properties.setProperty("1", Integer.toString(penny));
        return properties;
    }
}
