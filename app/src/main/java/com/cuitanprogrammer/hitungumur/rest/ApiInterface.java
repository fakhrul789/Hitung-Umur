package com.cuitanprogrammer.hitungumur.rest;

import com.cuitanprogrammer.hitungumur.model.UmurDiscover;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by islam on 16/09/17.
 */

public interface ApiInterface {

    @GET("exec")
    Call<UmurDiscover> getData(@Query("service") String key, @Query("nama") String nama, @Query("tanggal") String tanggal);
}
