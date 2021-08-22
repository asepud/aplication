package com.stmikbanisaleh.navbottom;

import java.util.ArrayList;
import java.util.List;

public class Dosen {
    private int id;
    private String nama;
    private String komptensi;
    private boolean status;

    public Dosen() {

    }

    public Dosen(int id, String nama, String komptensi, boolean status) {
        this.id = id;
        this.nama = nama;
        this.komptensi = komptensi;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKomptensi() {
        return komptensi;
    }

    public void setKomptensi(String komptensi) {
        this.komptensi = komptensi;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static List<Dosen> iniData(){
        List<Dosen> list = new ArrayList<>();
            list.add(new Dosen(1, "Muhammad Nur", "Software Engineering, Programming", true));
            list.add(new Dosen(2, "Suhadi", "Sistem Cerdas, Data Mining", true));
            list.add(new Dosen(3, "Hudi Kusuma Bharata", "Artificial Intelligent, Big Data", true));
            list.add(new Dosen(4, "Rudi Budi Agung", "SAP Specialist, System Architectur", true));
            list.add(new Dosen(5, "Heru Trisulaswanto", "IT Infrastructur, Networking", true));
            list.add(new Dosen(6, "Subandri", "IT Infrastructur, Networking", true));
            list.add(new Dosen(7, "Ramdani", "Internet Of Things, Robotic", true));
            list.add(new Dosen(8, "Soelistyowati", "Statistic, Data Analysis", true));
            list.add(new Dosen(9, "Ndaru Suseno", "Human Computer Interaction", true));
            list.add(new Dosen(10, "Sjaeful Irwan", "Statistic, Data Analysis", true));
            list.add(new Dosen(11, "Hendra Setiawan", "Web Design, Information System", true));
            list.add(new Dosen(12, "Taufik Maulana", "Statistic, Data Analysis", true));
            return list;
    }
}
