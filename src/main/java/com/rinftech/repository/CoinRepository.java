package com.rinftech.repository;

import com.rinftech.model.Coin;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.Properties;

import static com.rinftech.constants.Constants.COIN_REPO_NAME;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

/**
 * Created by Cristian Popovici on 3/12/2017.
 */
@Repository
public class CoinRepository {

    private Properties coinProperties;

    CoinRepository() {
        coinProperties = new Properties();
        loadFile();
    }

    public int getAmountFor(Coin coin) {
        return tryToGetIntegerAmount(coin);
    }

    public void substractAmountFor(Coin coin) {
        int previousAmount = tryToGetIntegerAmount(coin);
        coinProperties.setProperty(Integer.toString(coin.getDenomination()), valueOf(previousAmount-1));
        tryToUpdateFile();
    }

    private int tryToGetIntegerAmount(Coin coin) {
        try {
            return parseInt(coinProperties.getProperty(Integer.toString(coin.getDenomination())));
        } catch (NumberFormatException e) {
            System.err.print("could not get the amount from " + COIN_REPO_NAME +
                    " for:" + coin);
        }
        throw new IllegalStateException("Should not reach this place");
    }

    private void loadFile() {
        try (final InputStream fis =
                     new FileInputStream(COIN_REPO_NAME)) {
            coinProperties.load(fis);
        } catch (FileNotFoundException e) {
            System.out.println("Coin file not found");
        } catch (IOException e) {
            System.out.println("Could not read from coin file");
        }
    }

    private void tryToUpdateFile() {
        try (final FileOutputStream fos = new FileOutputStream(COIN_REPO_NAME)) {
            coinProperties.store(fos, "UPDATED");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
