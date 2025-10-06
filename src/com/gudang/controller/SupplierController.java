package com.gudang.controller;

import com.gudang.model.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SupplierController {

    @FXML private TableView<Supplier> tblSupplier;
    @FXML private TableColumn<Supplier, String> colKode;
    @FXML private TableColumn<Supplier, String> colNama;
    @FXML private TableColumn<Supplier, String> colAlamat;
    @FXML private TableColumn<Supplier, String> colTelepon;

    private ObservableList<Supplier> data = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colKode.setCellValueFactory(cell -> cell.getValue().kodeProperty());
        colNama.setCellValueFactory(cell -> cell.getValue().namaProperty());
        colAlamat.setCellValueFactory(cell -> cell.getValue().alamatProperty());
        colTelepon.setCellValueFactory(cell -> cell.getValue().teleponProperty());

        tblSupplier.setItems(data);
    }

    @FXML
    private void tambahSupplier() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TambahSupplier.fxml"));
            Scene scene = new Scene(loader.load());

            // TambahSupplierController controller = loader.getController();
            // controller.setSupplierController(this);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Tambah Supplier");
            stage.initModality(Modality.APPLICATION_MODAL); 
            stage.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addSupplier(Supplier supplier) {
        data.add(supplier);
    }

    @FXML private void editSupplier() {
        showAlert("Info", "Fitur edit belum dibuat");
    }

    @FXML private void hapusSupplier() {
        Supplier selected = tblSupplier.getSelectionModel().getSelectedItem();
        if (selected != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, 
                "Hapus supplier " + selected.getNama() + " ?", 
                ButtonType.YES, ButtonType.NO);

            alert.setTitle("Konfirmasi Hapus");
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                data.remove(selected);
            }
        } else {
            showAlert("Error", "Pilih supplier dulu!");
        }
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public boolean isKodeExist(String kode) {
        for (Supplier s : data) {
            if (s.getKode().equalsIgnoreCase(kode)) {
                return true;
            }
        }
        return false;
    }
}
