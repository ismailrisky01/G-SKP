package com.example.g_skp.ResponsePackage;

import com.example.g_skp.models.DataDashboard;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponDashboard {
    @Expose
    @SerializedName("status")
    String status;
    @Expose
    @SerializedName("message")
    String message;
    @Expose
    @SerializedName("data")
    List<DataDashboard> data;
    private DataDashboard dashboard;

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

    public List<DataDashboard> getData() {
        return data;
    }

    public void setData(List<DataDashboard> data) {
        this.data = data;
    }

    public DataDashboard getDashboard() {
        return dashboard;
    }

    public void setDashboard(DataDashboard dashboard) {
        this.dashboard = dashboard;
    }
}
