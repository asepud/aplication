package com.stmikbanisaleh.navbottom.api;


import com.stmikbanisaleh.navbottom.model.buku_m;
import com.stmikbanisaleh.navbottom.model.responseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface api {

    @GET("api/buku")
    Call<responseModel> getlist();

    @GET("api/buku{id}")
    Call<buku_m> get(@Path("id") int id);

    @FormUrlEncoded
    @POST("api/buku")
    Call<responseModel> post(@Body buku_m buku);

    @PUT("api/buku/{id}")
    Call<responseModel> put(@Path("id") int id, @Body buku_m buku);

    @DELETE("api/buku/{id}")
    Call<responseModel> delete(@Path("id") int id);


}
