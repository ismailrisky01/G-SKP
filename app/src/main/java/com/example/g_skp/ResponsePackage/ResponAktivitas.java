package com.example.g_skp.ResponsePackage;

import com.example.g_skp.models.AktivitasModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponAktivitas {
    @Expose
    @SerializedName("status") String status;
    @Expose
    @SerializedName("message") String message;
    @Expose
    @SerializedName("data")
    List<AktivitasModel> data;

    public List<AktivitasModel> getData() {
        return data;
    }

    public void setData(List<AktivitasModel> data) {
        this.data = data;
    }


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
