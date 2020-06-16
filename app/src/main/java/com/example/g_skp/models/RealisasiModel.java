package com.example.g_skp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RealisasiModel {
    public RealisasiModel(String id_realisasi, String uraian, String output, String mutu, String waktu, String biaya, String perhitungan, String capaian) {
        this.id_realisasi = id_realisasi;
        this.uraian = uraian;
        this.output = output;
        this.mutu = mutu;
        this.waktu = waktu;
        this.biaya = biaya;
        this.perhitungan = perhitungan;
        this.capaian = capaian;
    }

    @Expose
    @SerializedName("id_realisasi") private String id_realisasi;
    @Expose
    @SerializedName("uraian") private String uraian;
    @Expose
    @SerializedName("r_output") private String output;
    @Expose
    @SerializedName("r_mutu") private String mutu;
    @Expose
    @SerializedName("r_waktu") private String waktu;
    @Expose
    @SerializedName("r_biaya") private String biaya;
    @Expose
    @SerializedName("r_perhitungan") private String perhitungan;
    @Expose
    @SerializedName("r_capaian") private String capaian;

    public String getId_realisasi() {
        return id_realisasi;
    }

    public void setId_realisasi(String id_realisasi) {
        this.id_realisasi = id_realisasi;
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

    public String getBiaya() {
        return biaya;
    }

    public void setBiaya(String biaya) {
        this.biaya = biaya;
    }

    public String getPerhitungan() {
        return perhitungan;
    }

    public void setPerhitungan(String perhitungan) {
        this.perhitungan = perhitungan;
    }

    public String getCapaian() {
        return capaian;
    }

    public void setCapaian(String capaian) {
        this.capaian = capaian;
    }





}
