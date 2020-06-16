package com.example.g_skp.ServicePackage;

import com.example.g_skp.models.LoginModel;
import com.example.g_skp.ResponsePackage.ResponAktivitas;
import com.example.g_skp.ResponsePackage.ResponDashboard;
import com.example.g_skp.ResponsePackage.ResponRealisasi;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Services {
    //Login
    @Headers({"Content-Type: application/json",
            "auth-key:  geomedia"})
    @POST("auth/login/")
    Call<LoginModel> Login(@Body Map<String, String> body);
    //DashBoard
    @Headers({
            "Content-Type: application/json",
            "auth-key:  geomedia"
    })
    @GET("Dashboard/target/")
    Call<ResponDashboard> getDataDashboard(@Query("nip") String nip, @Header("Authorization") String token);
    //Aktivitas

    @Headers({
            "Content-Type: application/json",
            "auth-key:  geomedia"
    })
    @GET("Log_Aktivitas/")
    Call<ResponAktivitas> getAktivitas(@Query("nip") String nip, @Header("Authorization") String token);

    @Headers({
            "Content-Type: application/json",
            "auth-key: geomedia"
    })
    @GET("Realisasi_SKP/")
    Call<ResponRealisasi> getRealisasi(@Query("nip") String nip, @Header("Authorization") String token);

}
