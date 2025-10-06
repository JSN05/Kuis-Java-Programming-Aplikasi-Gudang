package com.gudang.controller;

import com.gudang.model.Supplier;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TambahSupplierController {

    @FXML private TextField kodeSupplier;
    @FXML private TextField namaSupplier;
    @FXML private TextField alamatSupplier;
    @FXML private TextField teleponSupplier;

    private SupplierController supplierController;

    public void setSupplierController(SupplierController supplierController) {
        this.supplierController = supplierController;
    }

    @FXML
    private void simpanSupplier() {
        String kode = kodeSupplier.getText();
        String nama = namaSupplier.getText();
        String alamat = alamatSupplier.getText();
        String telepon = teleponSupplier.getText();

        if (kode.isEmpty() || nama.isEmpty() || telepon.isEmpty()) {
            showAlert("Error", "Mandatory field harus diisi!");
            return;
        }

        // Cek kode supplier
        if (supplierController.isKodeExist(kode)) {
            showAlert("Error", "Kode supplier sudah ada!");
            return;
        }

        Supplier supplier = new Supplier(kode, nama, alamat, telepon);
        supplierController.addSupplier(supplier);

        Stage stage = (Stage) kodeSupplier.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void batal() {
        Stage stage = (Stage) kodeSupplier.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
