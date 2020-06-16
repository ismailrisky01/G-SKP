package com.example.g_skp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TargetModel {
    @Expose
    @SerializedName("nip") private String nip;
    @Expose
    @SerializedName("kode_jabatan") private String kode_jabatan;

    public TargetModel(String nip, String kode_jabatan, String uraian, String output, String satuan_output, String mutu, String waktu, String satuan_waktu, String biaya) {
        this.nip = nip;
        this.kode_jabatan = kode_jabatan;
        this.uraian = uraian;
        this.output = output;
        this.satuan_output = satuan_output;
        this.mutu = mutu;
        this.waktu = waktu;
        this.satuan_waktu = satuan_waktu;
        this.biaya = biaya;
    }

    @Expose
    @SerializedName("uraian") private String uraian;
    @Expose
    @SerializedName("output") private String output;
    @Expose
    @SerializedName("satuan_output") private String satuan_output;
    @Expose
    @SerializedName("mutu") private String mutu;
    @Expose
    @SerializedName("waktu") private String waktu;
    @Expose
    @SerializedName("satuan_waktu") private String satuan_waktu;
    @Expose
    @SerializedName("biaya") private String biaya;


    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getKode_jabatan() {
        return kode_jabatan;
    }

    public void setKode_jabatan(String kode_jabatan) {
        this.kode_jabatan = kode_jabatan;
    }

    public String getUraian() {
        return uraian;
    }

    public void setUraian(String uraian) {
        this.uraian = uraian;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getSatuan_output() {
        return satuan_output;
    }

    public void setSatuan_output(String satuan_output) {
        this.satuan_output = satuan_output;
    }

    public String getMutu() {
        return mutu;
    }

    public void setMutu(String mutu) {
        this.mutu = mutu;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getSatuan_waktu() {
        return satuan_waktu;
    }

    public void setSatuan_waktu(String satuan_waktu) {
        this.satuan_waktu = satuan_waktu;
    }

    public String getBiaya() {
        return biaya;
    }

    public void setBiaya(String biaya) {
        this.biaya = biaya;
    }
}
