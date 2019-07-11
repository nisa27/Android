package com.e.a8offlinedatabase;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CatatanModul extends RealmObject {
    @PrimaryKey
    private int id;
    private String judul;
    private  String jumlahhutang;
    private String tangggal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJumlahhutang() {
        return jumlahhutang;
    }

    public void setJumlahhutang(String jumlahhutang) {
        this.jumlahhutang = jumlahhutang;
    }

    public String getTangggal() {
        return tangggal;
    }

    public void setTangggal(String tangggal) {
        this.tangggal = tangggal;
    }
}
