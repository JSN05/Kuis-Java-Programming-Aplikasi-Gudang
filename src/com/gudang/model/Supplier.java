package com.gudang.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Supplier {
    private final StringProperty kode;
    private final StringProperty nama;
    private final StringProperty alamat;
    private final StringProperty telepon;

    public Supplier(String kode, String nama, String alamat, String telepon) {
        this.kode = new SimpleStringProperty(kode);
        this.nama = new SimpleStringProperty(nama);
        this.alamat = new SimpleStringProperty(alamat);
        this.telepon = new SimpleStringProperty(telepon);
    }

    public StringProperty kodeProperty() { return kode; }
    public StringProperty namaProperty() { return nama; }
    public StringProperty alamatProperty() { return alamat; }
    public StringProperty teleponProperty() { return telepon; }

    public String getKode() { return kode.get(); }
    public String getNama() { return nama.get(); }
    public String getAlamat() { return alamat.get(); }
    public String getTelepon() { return telepon.get(); }

    public void setNama(String nama) { this.nama.set(nama); }
    public void setAlamat(String alamat) { this.alamat.set(alamat); }
    public void setTelepon(String telepon) { this.telepon.set(telepon); }
}
