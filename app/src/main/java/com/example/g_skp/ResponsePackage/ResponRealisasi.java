package com.example.g_skp.ResponsePackage;

import com.example.g_skp.models.RealisasiModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponRealisasi {
    @Expose
    @SerializedName("status") String status;
    @Expose
    @SerializedName("message") String message;

    public List<RealisasiModel> getData() {
        return data;
    }

    public void setData(List<RealisasiModel> data) {
        this.data = data;
    }

    @Expose
    @SerializedName("data")
    List<RealisasiModel> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
