package com.stmikbanisaleh.navbottom.model;

public class buku_m {
    private int id;
    private String judul;
    private String penulis;
    private String jenis;
    private String tahun;
    private String image;

    public buku_m() {

    }

    public buku_m(int id, String judul, String penulis, String jenis, String tahun, String image) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.jenis = jenis;
        this.tahun = tahun;
        this.image = image;
    }

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

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
