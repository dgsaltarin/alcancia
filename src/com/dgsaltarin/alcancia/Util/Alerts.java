package com.dgsaltarin.alcancia.Util;

import javafx.scene.control.Alert;

public class Alerts {

    public static void alertMessage(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
