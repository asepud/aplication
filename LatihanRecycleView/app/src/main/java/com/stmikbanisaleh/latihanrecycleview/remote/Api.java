package com.stmikbanisaleh.latihanrecycleview.remote;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("v1/lectures")
    Call<PagingResponse> getlist();
}
