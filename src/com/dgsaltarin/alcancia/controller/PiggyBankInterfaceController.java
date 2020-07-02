package com.dgsaltarin.alcancia.controller;

import com.dgsaltarin.alcancia.Dao.CoinsDaoImplement;
import com.dgsaltarin.alcancia.Util.Alerts;
import com.dgsaltarin.alcancia.model.Coins;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PiggyBankInterfaceController implements Initializable {

    @FXML
    private ComboBox coinsValueCB1;
    @FXML
    private TextField coinsQuantity;
    @FXML
    private TextField responseTextField;
    @FXML
    private ComboBox coinsValueCB2;

    private CoinsDaoImplement _coinsDao = new CoinsDaoImplement();

    /**
     * coloca los valores dentro de cada comboBox correspondiente
     * */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        coinsValueCB1.setItems(FXCollections.observableArrayList(
                Coins.coin50, Coins.coin100, Coins.coin200, Coins.coin500, Coins.coin1000
        ));
        coinsValueCB2.setItems(FXCollections.observableArrayList("todas",
                Coins.coin50, Coins.coin100, Coins.coin200, Coins.coin500, Coins.coin1000
        ));
    }

    /**
     * recibe la cantidad y el tipo de moneda e invoca al método que las guarda
     * */
    public void insertCoins() {
        String coinsQuantityStringValue = coinsQuantity.getText();
        if (!coinsQuantityStringValue.isEmpty()) {
            if (!coinsValueCB1.getSelectionModel().isEmpty()) {
                short coinsQuantity = Short.parseShort(coinsQuantityStringValue);
                short selectedCoinValue = Short.valueOf(coinsValueCB1.getSelectionModel().getSelectedItem().toString());
                _coinsDao.insertCoins(coinsQuantity, selectedCoinValue);
                Alerts.alertMessage("Nuevas monedas ingresadas a la alcancia!");
            } else
                Alerts.alertMessage("debe seleccionar el valor de las monedas a ingresar");
        } else
            Alerts.alertMessage("Debe colocar la cantidad de monedas que desea ingresar");
    }

    /**
     * recibe el tipo de moneda y llama al método correspondiente para mostrar el total de dinero
     * */
    public void getTotalMoney() {
        String totalMoney = "";
        if (!coinsValueCB2.getSelectionModel().isEmpty()){
            if (coinsValueCB2.getSelectionModel().getSelectedItem().toString().equals("todas")) {
                totalMoney = String.valueOf(_coinsDao.getTotalMoney());
            } else {
                short selectedCoinValue = Short.valueOf(coinsValueCB2.getSelectionModel().getSelectedItem().toString());
                totalMoney = String.valueOf(_coinsDao.getTotalMoney(selectedCoinValue));
            }
        } else
            Alerts.alertMessage("debe seleccionar el tipo de moneda primero");
        responseTextField.setText(totalMoney);
    }

    /**
     * recibe el tipo de moneda y llama al método correspondiente para mostrar el total de monedas
     * */
    public void getTotalCoins() {
        String totalCoins = "";
        if (!coinsValueCB2.getSelectionModel().isEmpty()){
            if (coinsValueCB2.getSelectionModel().getSelectedItem().toString().equals("todas")) {
                totalCoins = String.valueOf(_coinsDao.getTotalCoins());
            } else {
                short selectedCoinValue = Short.valueOf(coinsValueCB2.getSelectionModel().getSelectedItem().toString());
                totalCoins = String.valueOf(_coinsDao.getTotalCoins(selectedCoinValue));
            }
        } else
            Alerts.alertMessage("debe seleccionar el tipo de moneda primero");
        responseTextField.setText(totalCoins);
    }

    /**
     * Evalua y permite que solo valores númericos sean ingresado en el campo de "cantidad de monedas"
     * */
    public void evaluateEnteredValue() {
        coinsQuantity.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("\\d*")) return;
            coinsQuantity.setText(newValue.replaceAll("[^\\d]", ""));
        });
    }
}
