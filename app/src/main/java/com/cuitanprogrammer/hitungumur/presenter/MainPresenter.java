package com.cuitanprogrammer.hitungumur.presenter;

import com.cuitanprogrammer.hitungumur.HitunUmurApplication;
import com.cuitanprogrammer.hitungumur.model.UmurDiscover;
import com.cuitanprogrammer.hitungumur.rest.ApiClient;
import com.cuitanprogrammer.hitungumur.view.interfaces.MainView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by islam on 16/09/17.
 */

public class MainPresenter {
    MainView view;
    UmurDiscover model;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void getData(String nama, String tanggal) {
        view.tampilDialog(nama,tanggal);
    }

}
