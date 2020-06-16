package com.example.g_skp.UtilPackage;

import android.app.Service;

import com.example.g_skp.ServicePackage.Services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.g_skp.UtilPackage.Api.PREF.URL;

public class Api {
    public static Retrofit retrofit;
    public static class PREF {
        public static String USER = "user";
        public static String DATA_USER = "data_user";
        public static String DATA_DASHBOARD = "data_dashboard";
        public static String DATA_AKTIVITAS = "data_aktivitas";
        public static String DATA_REALISASI = "data_realisasi";
        public static String URL = "http://192.168.2.15/API-MAGANG/api/";
    }
    public static Retrofit getRetroClient(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static Services getApiService()
    {
        return getRetroClient().create(Services.class);
    }
}

