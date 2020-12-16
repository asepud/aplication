package com.stmikbanisaleh.latihanrecycleview.remote;

import com.stmikbanisaleh.latihanrecycleview.Dosen;

import java.util.List;

public class PagingResponse {
    private List<Dosen> data;
    private int totalCount;
    private int totalPage;

    public PagingResponse() {
    }

    public PagingResponse(List<Dosen> data, int totalCount, int totalPage) {
        this.data = data;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
    }

    public List<Dosen> getData() {
        return data;
    }

    public void setData(List<Dosen> data) {
        this.data = data;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
