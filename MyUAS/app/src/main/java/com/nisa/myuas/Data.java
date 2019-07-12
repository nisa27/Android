package com.nisa.myuas;

public class Data {
    private String id, jenis_kelamin;

    public Data() {
    }

    public Data(String id, String pendidikan) {
        this.id = id;
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJk() {
        return jenis_kelamin;
    }

    public void setk(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

}
