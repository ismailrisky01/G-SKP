package com.example.g_skp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS-PC on 03/10/2017.
 */

public class AktivitasModel {

    @Expose
    @SerializedName("log_id")
    private String log_id;
    @Expose
    @SerializedName("akt_tanggal")
    private String akt_tanggal;
    @Expose
    @SerializedName("bk_nama_kegiatan")
    private String bk_nama_kegiatann;
    @Expose
    @SerializedName("akt_output")
    private String akt_output;
    @Expose
    @SerializedName("akt_start")
    private String akt_start;
    @Expose
    @SerializedName("akt_end")
    private String akt_end;
    @Expose
    @SerializedName("akt_waktu")
    private String akt_waktu;
    @Expose
    @SerializedName("akt_status")
    private String akt_status;
    private AktivitasModel aktivitasModel;

    public AktivitasModel getAktivitasModel() {
        return aktivitasModel;
    }

    public void setAktivitasModel(AktivitasModel aktivitasModel) {
        this.aktivitasModel = aktivitasModel;
    }


    public AktivitasModel(String log_id, String akt_tanggal, String bk_nama_kegiatann, String akt_output, String akt_start, String akt_end, String akt_waktu, String akt_status) {
        this.log_id = log_id;
        this.akt_tanggal = akt_tanggal;
        this.bk_nama_kegiatann = bk_nama_kegiatann;
        this.akt_output = akt_output;
        this.akt_start = akt_start;
        this.akt_end = akt_end;
        this.akt_waktu = akt_waktu;
        this.akt_status = akt_status;
    }

    public String getLog_id() {
        return log_id;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }

    public String getAkt_tanggal() {
        return akt_tanggal;
    }

    public void setAkt_tanggal(String akt_tanggal) {
        this.akt_tanggal = akt_tanggal;
    }

    public String getBk_nama_kegiatann() {
        return bk_nama_kegiatann;
    }

    public void setBk_nama_kegiatann(String bk_nama_kegiatann) {
        this.bk_nama_kegiatann = bk_nama_kegiatann;
    }

    public String getAkt_output() {
        return akt_output;
    }

    public void setAkt_output(String akt_output) {
        this.akt_output = akt_output;
    }

    public String getAkt_start() {
        return akt_start;
    }

    public void setAkt_start(String akt_start) {
        this.akt_start = akt_start;
    }

    public String getAkt_end() {
        return akt_end;
    }

    public void setAkt_end(String akt_end) {
        this.akt_end = akt_end;
    }

    public String getAkt_waktu() {
        return akt_waktu;
    }

    public void setAkt_waktu(String akt_waktu) {
        this.akt_waktu = akt_waktu;
    }

    public String getAkt_status() {
        return akt_status;
    }

    public void setAkt_status(String akt_status) {
        this.akt_status = akt_status;
    }
}
