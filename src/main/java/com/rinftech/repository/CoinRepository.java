package com.rinftech.repository;

import com.rinftech.model.Coin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.Properties;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

/**
 * Created by Cristian Popovici on 3/12/2017.
 */
@Repository
public class CoinRepository {

    private Properties coinProperties;

    @Value("${repository.path}")
    private String coinRepoPath;

    CoinRepository() {
        coinProperties = new Properties();
    }

    @PostConstruct
    public void setUp() {
        if (coinRepoPath != null && !coinRepoPath.isEmpty()) {
            tryToLoadFile();
        } else {
            tryToLoadDefaultFileFromClassPath();
        }
    }

    public int getAmountFor(Coin coin) {
        return tryToGetIntegerAmount(coin);
    }

    public void substractAmountFor(Coin coin) {
        int previousAmount = tryToGetIntegerAmount(coin);
        coinProperties.setProperty(Integer.toString(coin.getDenomination()), valueOf(previousAmount - 1));
        tryToUpdateFile();
    }

    private int tryToGetIntegerAmount(Coin coin) {
        try {
            return parseInt(coinProperties.getProperty(Integer.toString(coin.getDenomination())));
        } catch (NumberFormatException e) {
            System.err.print("could not get the amount from " + coinRepoPath +
                    " for:" + coin);
        }
        throw new IllegalStateException("Should not reach this place");
    }

    private void tryToLoadFile() {
        try (final InputStream fis =
                     new FileInputStream(coinRepoPath)) {
            coinProperties.load(fis);
        } catch (FileNotFoundException e) {
            System.out.println("Coin file not found");
        } catch (IOException e) {
            System.out.println("Could not read from coin file");
        }
    }

    private void tryToLoadDefaultFileFromClassPath() {
        try (final InputStream is =
                     this.getClass().getResourceAsStream("coin-inventory.properties")) {
            if (is != null) {
                coinProperties.load(is);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Coin file not found");
        } catch (IOException e) {
            System.out.println("Could not read from coin file");
        }
    }

    private void tryToUpdateFile() {
        if (coinRepoPath == null || coinRepoPath.isEmpty()) {
            return;
        }
        try (final FileOutputStream fos = new FileOutputStream(coinRepoPath)) {
            coinProperties.store(fos, "UPDATED");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
