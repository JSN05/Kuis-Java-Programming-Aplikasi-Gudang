package com.gudang.controller;

import com.gudang.model.Supplier;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditSupplierController {

    @FXML private TextField kodeSupplier;
    @FXML private TextField namaSupplier;
    @FXML private TextField alamatSupplier;
    @FXML private TextField teleponSupplier;

    private SupplierController supplierController;
    private Supplier supplier;

    public void setSupplierController(SupplierController supplierController) {
        this.supplierController = supplierController;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;

        kodeSupplier.setText(supplier.getKode());
        namaSupplier.setText(supplier.getNama());
        alamatSupplier.setText(supplier.getAlamat());
        teleponSupplier.setText(supplier.getTelepon());
    }

    @FXML
    private void editSupplier() {
        String nama = namaSupplier.getText();
        String alamat = alamatSupplier.getText();
        String telepon = teleponSupplier.getText();

        if (nama.isEmpty() || telepon.isEmpty()) {
            showAlert("Error", "Nama dan Telepon harus diisi!");
            return;
        }

        supplier.setNama(nama);
        supplier.setAlamat(alamat);
        supplier.setTelepon(telepon);

        supplierController.refreshTable();

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
