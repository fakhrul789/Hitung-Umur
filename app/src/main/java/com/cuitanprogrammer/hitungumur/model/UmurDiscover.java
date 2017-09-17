package com.cuitanprogrammer.hitungumur.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by islam on 16/09/17.
 */

public class UmurDiscover {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private Umur data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Umur getData() {
        return data;
    }

    public void setData(Umur data) {
        this.data = data;
    }
}
