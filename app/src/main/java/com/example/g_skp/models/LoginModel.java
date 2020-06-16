package com.example.g_skp.models;

public class LoginModel {
    private String status;
    private String message;
    private String nip;

    public String getKode_jabatan() {
        return kode_jabatan;
    }

    public void setKode_jabatan(String kode_jabatan) {
        this.kode_jabatan = kode_jabatan;
    }

    public String getNama_jabatan() {
        return nama_jabatan;
    }

    public void setNama_jabatan(String nama_jabatan) {
        this.nama_jabatan = nama_jabatan;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    private String kode_jabatan;
    private String nama_jabatan;
    private String jabatan;
    private String token;

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

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
