package com.example.g_skp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS-PC on 24/08/2017.
 */

public class DataDashboard implements Parcelable {
    private String nama, nip, jabatan, instansi, image_profil, capaian_target,capaian_aktivitas_bulan_now, target_is_confirm;
    public int getTarget() {
        return target;
    }
    public void setTarget(int target) {
        this.target = target;
    }
    int target;

    public int getRealisasi() {
        return realisasi;
    }

    public void setRealisasi(int realisasi) {
        this.realisasi = realisasi;
    }

    int realisasi;
    private List<DataDashboard> list_bawahan;

    public DataDashboard getDashboard() {
        return dashboard;
    }

    public void setDashboard(DataDashboard dashboard) {
        this.dashboard = dashboard;
    }

    private DataDashboard dashboard;

    public DataDashboard(Parcel source) {
        this.nama = source.readString();
        this.nip = source.readString();
        this.jabatan = source.readString();
        this.instansi = source.readString();
        this.image_profil = source.readString();
        this.target = source.readInt();
        this.realisasi = source.readInt();
        this.capaian_target = source.readString();
        this.capaian_aktivitas_bulan_now = source.readString();
        this.target_is_confirm = source.readString();
        this.list_bawahan = (ArrayList<DataDashboard>) source.readSerializable();
    }

    public String getTarget_is_confirm() {
        return target_is_confirm;
    }

    public void setTarget_is_confirm(String target_is_confirm) {
        this.target_is_confirm = target_is_confirm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getInstansi() {
        return instansi;
    }

    public void setInstansi(String instansi) {
        this.instansi = instansi;
    }

    public String getImage_profil() {
        return image_profil;
    }

    public void setImage_profil(String image_profil) {
        this.image_profil = image_profil;
    }


    public String getCapaian_target() {
        return capaian_target;
    }

    public void setCapaian_target(String capaian_target) {
        this.capaian_target = capaian_target;
    }

    public String getCapaian_aktivitas_bulan_now() {
        return capaian_aktivitas_bulan_now;
    }

    public void setCapaian_aktivitas_bulan_now(String capaian_aktivitas_bulan_now) {
        this.capaian_aktivitas_bulan_now = capaian_aktivitas_bulan_now;
    }

    public List<DataDashboard> getList_bawahan() {
        return list_bawahan;
    }

    public void setList_bawahan(List<DataDashboard> list_bawahan) {
        this.list_bawahan = list_bawahan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.nip);
        dest.writeString(this.jabatan);
        dest.writeString(this.instansi);
        dest.writeString(this.image_profil);
        dest.writeInt(this.target);
        dest.writeInt(this.realisasi);
        dest.writeString(this.capaian_target);
        dest.writeString(this.capaian_aktivitas_bulan_now);
        dest.writeSerializable((Serializable) list_bawahan);
    }

    public static final Creator CREATOR = new Creator<DataDashboard>() {

        @Override
        public DataDashboard createFromParcel(Parcel source) {
            return new DataDashboard(source);
        }

        @Override
        public DataDashboard[] newArray(int size) {
            return new DataDashboard[0];
        }
    };
}
