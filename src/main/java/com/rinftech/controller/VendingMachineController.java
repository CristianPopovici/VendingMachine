package com.rinftech.controller;

import com.rinftech.exception.OutOfMoneyException;
import com.rinftech.service.CoinServiceWithRepository;
import com.rinftech.service.CoinServiceWithoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Cristian Popovici on 3/27/2017.
 */
@RestController
@RequestMapping("/vending-machine/v1")
public class VendingMachineController {

    @Autowired
    private CoinServiceWithoutRepository coinServiceWithoutRepository;
    @Autowired
    private CoinServiceWithRepository coinServiceWithRepository;

    @RequestMapping(value = "/optimal-coin-changer/{changeAmount}", method = RequestMethod.GET)
    @ResponseBody
    String getOptimalChange(@PathVariable(value = "changeAmount") int changeAmount) {
        return coinServiceWithoutRepository.getOptimalChangeFor(changeAmount).toString();
    }

    @RequestMapping(value = "/repository-coin-changer/{changeAmount}", method = RequestMethod.POST)
    @ResponseBody
    String getChange(@PathVariable(value = "changeAmount") int changeAmount) {
        try {
            return coinServiceWithRepository.getChangeFor(changeAmount).toString();
        } catch (OutOfMoneyException e) {
            return "Not enough change!";
        }
    }
}
