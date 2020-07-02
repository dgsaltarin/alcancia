package com.dgsaltarin.alcancia.Dao;

import com.dgsaltarin.alcancia.model.Coins;
import com.dgsaltarin.alcancia.model.PiggyBank;


public class CoinsDaoImplement implements CoinsDao {
    private PiggyBank piggyBank = new PiggyBank();
    private int[] coinsArray = piggyBank.getCoinsArray();
    private int totalMoney;
    private int totalCoins;

    /**
     * retorna la cantidad de dinero total en la alcancia
     * */
    public int getTotalMoney() {
        totalMoney = 0;
        for (int coin = 0; coin<coinsArray.length;coin++){
            totalMoney += coinsArray[coin]*Coins.coinsValueArray[coin];
        }
        return totalMoney;
    }

    /**
     * retorna la cantidad total de monedas en la alcancia
     * */
    public int getTotalCoins() {
        totalCoins = 0;
        for (int coins:coinsArray){
            totalCoins += coins;
        }
        return totalCoins;
    }

    /**
     * retorna el total de dinero en la alcancia de acuerdo a un tipo de moneda
     * */
    public int getTotalMoney(short coinValue) {
        totalMoney = 0;
        switch (coinValue){
            case Coins.coin50:
                totalMoney = coinsArray[0] * coinValue;
                break;
            case Coins.coin100:
                totalMoney = coinsArray[1] * coinValue;
                break;
            case Coins.coin200:
                totalMoney = coinsArray[2] * coinValue;
                break;
            case Coins.coin500:
                totalMoney = coinsArray[3] * coinValue;
                break;
            case Coins.coin1000:
                totalMoney = coinsArray[4] * coinValue;
                break;
        }
        return totalMoney;
    }

    /**
     * retorna el total de monedas en la alcancia de acuerdo a un tipo de moneda
     * */
    public int getTotalCoins(short coinValue) {
        totalCoins = 0;
        switch (coinValue){
            case Coins.coin50:
                totalCoins = coinsArray[0];
                break;
            case Coins.coin100:
                totalCoins = coinsArray[1];
                break;
            case Coins.coin200:
                totalCoins = coinsArray[2];
                break;
            case Coins.coin500:
                totalCoins = coinsArray[3];
                break;
            case Coins.coin1000:
                totalCoins = coinsArray[4];
                break;
        }
        return totalCoins;
    }

    /**
     * guarda las nuevas monedas dentro de la alcancia
     * */
    public void insertCoins(short coinsQuantity, short coinValue) {
        switch (coinValue) {
            case Coins.coin50:
                coinsArray[0] += coinsQuantity;
                break;
            case Coins.coin100:
                coinsArray[1] += coinsQuantity;
                break;
            case Coins.coin200:
                coinsArray[2] += coinsQuantity;
                break;
            case Coins.coin500:
                coinsArray[3] += coinsQuantity;
                break;
            case Coins.coin1000:
                coinsArray[4] += coinsQuantity;
                break;
        }
        piggyBank.setCoinsArray(coinsArray);
    }
}
