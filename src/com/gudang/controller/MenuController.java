package com.gudang.controller;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class MenuController {

    @FXML
    private void openBarang() throws Exception {
        Stage stage = (Stage) new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Barang.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setTitle("Manajemen Barang");
        stage.show();
    }

    @FXML
    private void openSupplier() throws Exception {
        Stage stage = (Stage) new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Supplier.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setTitle("Manajemen Supplier");
        stage.show();
    }
}

