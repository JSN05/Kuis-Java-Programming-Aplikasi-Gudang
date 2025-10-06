package com.gudang.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.*;
import com.gudang.model.Barang;

public class BarangController {

    @FXML private TableColumn<Barang, Integer> colJumlah;
    @FXML private TableColumn<Barang, String> colNama;
    @FXML private TableView<Barang> tblBarang;
    @FXML private TextField txtJumlah;
    @FXML private TextField txtNama;

    private ObservableList<Barang> data = FXCollections.observableArrayList();

    @FXML public void initialize() {
        colNama.setCellValueFactory(cell -> cell.getValue().namaProperty());
        colJumlah.setCellValueFactory(cell -> cell.getValue().jumlahProperty().asObject());
        tblBarang.setItems(data);
    }

    @FXML public void editBarang(ActionEvent event) {
        Barang selected = tblBarang.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setNama(txtNama.getText());
            selected.setJumlah(Integer.parseInt(txtJumlah.getText()));
            tblBarang.refresh();
        }
    }

    @FXML public void hapusBarang(ActionEvent event) {
        Barang selected = tblBarang.getSelectionModel().getSelectedItem();
        if (selected != null) {
            data.remove(selected);
        }
    }

    @FXML public void tambahBarang(ActionEvent event) {
        if (!txtNama.getText().isEmpty() && !txtJumlah.getText().isEmpty()) {
            data.add(new Barang(txtNama.getText(), Integer.parseInt(txtJumlah.getText())));
            txtNama.clear();
            txtJumlah.clear();
        }
    }

}
