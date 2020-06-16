package com.example.g_skp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PenetapanTargetModel {
    @Expose
    @SerializedName("data") private String data;
    @Expose
    @SerializedName("keterangan") private String keterangan;
    @Expose
    @SerializedName("waktu") private String waktu;
}
