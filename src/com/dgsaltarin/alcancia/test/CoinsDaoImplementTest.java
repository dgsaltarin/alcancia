package com.dgsaltarin.alcancia.test;

import com.dgsaltarin.alcancia.Dao.CoinsDaoImplement;
import com.dgsaltarin.alcancia.model.Coins;

import static org.junit.Assert.*;

public class CoinsDaoImplementTest {


    @org.junit.Test
    public void getTotalMoney() {
        CoinsDaoImplement coinsDaoImplement = new CoinsDaoImplement();
        coinsDaoImplement.insertCoins((short) 10, Coins.coin1000);
        coinsDaoImplement.insertCoins((short) 5, Coins.coin200);
        coinsDaoImplement.insertCoins((short) 3, Coins.coin500);
        assertEquals(coinsDaoImplement.getTotalMoney(), 12500);
    }

    @org.junit.Test
    public void getTotalCoins() {
        CoinsDaoImplement coinsDaoImplement = new CoinsDaoImplement();
        coinsDaoImplement.insertCoins((short) 7, Coins.coin500);
        coinsDaoImplement.insertCoins((short) 2, Coins.coin200);
        coinsDaoImplement.insertCoins((short) 4, Coins.coin1000);
        assertEquals(coinsDaoImplement.getTotalCoins(), 13);
    }

    @org.junit.Test
    public void testGetTotalMoney() {
        CoinsDaoImplement coinsDaoImplement = new CoinsDaoImplement();
        coinsDaoImplement.insertCoins((short) 6, Coins.coin500);
        assertEquals(coinsDaoImplement.getTotalMoney(Coins.coin500), 3000);
    }

    @org.junit.Test
    public void testGetTotalCoins() {
        CoinsDaoImplement coinsDaoImplement = new CoinsDaoImplement();
        coinsDaoImplement.insertCoins((short) 10, Coins.coin1000);
        assertEquals(coinsDaoImplement.getTotalCoins(Coins.coin1000), 10);
    }
}