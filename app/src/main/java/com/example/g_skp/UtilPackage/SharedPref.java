package com.example.g_skp.UtilPackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.g_skp.models.AktivitasModel;
import com.example.g_skp.models.DataDashboard;
import com.example.g_skp.models.LoginModel;
import com.example.g_skp.models.RealisasiModel;
import com.google.gson.Gson;

public class SharedPref {

    public static SharedPreferences getPref(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }
    public static LoginModel getUserData(Context ctx){
        SharedPreferences sp = getPref(ctx);
        String strJson = sp.getString(Api.PREF.DATA_USER, null);
        if (strJson == null){
            return null;
        }else{
            return new Gson().fromJson(strJson, LoginModel.class);
        }
    }
    public static void saveUserData(Context ctx, LoginModel Datauser){
        SharedPreferences preferences = getPref(ctx);
        preferences.edit().putString(Api.PREF.DATA_USER, new Gson().toJson(Datauser)).apply();
    }
//-------------------------------
    public static DataDashboard getDashboardData(Context ctx){
        SharedPreferences sp = getPref(ctx);
        String strJson = sp.getString(Api.PREF.DATA_DASHBOARD, null);
        if (strJson == null){
            return null;
        }else{
            return new Gson().fromJson(strJson, DataDashboard.class);
        }
    }
    public static void saveDashboardData(Context ctx, DataDashboard Datadashboard){
        SharedPreferences preferences = getPref(ctx);
        preferences.edit().putString(Api.PREF.DATA_DASHBOARD, new Gson().toJson(Datadashboard)).apply();
    }
    //------------------------
    public static AktivitasModel getAktivitasData(Context ctx){
        SharedPreferences sp = getPref(ctx);
        String strJson = sp.getString(Api.PREF.DATA_AKTIVITAS, null);
        if (strJson == null){
            return null;
        }else{
            return new Gson().fromJson(strJson, AktivitasModel.class);
        }
    }
    public static void savAktivitasData(Context ctx, AktivitasModel DataAktivitas){
        SharedPreferences preferences = getPref(ctx);
        preferences.edit().putString(Api.PREF.DATA_AKTIVITAS, new Gson().toJson(DataAktivitas)).apply();
    }
    //------------------------
    public static RealisasiModel getRealisasiData(Context ctx){
        SharedPreferences sp = getPref(ctx);
        String strJson = sp.getString(Api.PREF.DATA_REALISASI, null);
        if (strJson == null){
            return null;
        }else{
            return new Gson().fromJson(strJson, RealisasiModel.class);
        }
    }
    public static void setRealisasiData(Context ctx, RealisasiModel Data){
        SharedPreferences preferences = getPref(ctx);
        preferences.edit().putString(Api.PREF.DATA_AKTIVITAS, new Gson().toJson(Data)).apply();
    }
}
