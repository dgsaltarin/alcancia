package com.dgsaltarin.alcancia.Dao;

public interface CoinsDao {

    int getTotalMoney();

    int getTotalCoins();

    int getTotalMoney(short coinValue);

    int getTotalCoins(short coinValue);

    void insertCoins(short coinsQuantity, short coinValue);
}
