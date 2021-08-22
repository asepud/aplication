package com.stmikbanisaleh.navbottom.model;

import java.util.List;

public class responseModel {
    private String message;
    private boolean status;
    private List<buku_m> data;

    public responseModel() {

    }

    public responseModel(String message, boolean status, List<buku_m> data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<buku_m> getData() {
        return data;
    }

    public void setData(List<buku_m> data) {
        this.data = data;
    }
}
