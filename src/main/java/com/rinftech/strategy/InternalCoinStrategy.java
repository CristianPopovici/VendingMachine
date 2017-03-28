package com.rinftech.strategy;

import com.rinftech.model.Coin;

/**
 * Created by Cristian Popovici on 3/12/2017.
 */
public interface InternalCoinStrategy {

    boolean hasAnyAmount(Coin coin);

    void substractAmount(Coin coin);
}
