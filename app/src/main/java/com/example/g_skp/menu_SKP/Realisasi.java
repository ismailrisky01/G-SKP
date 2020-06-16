package com.example.g_skp.menu_SKP;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.g_skp.activity_Action.Realisasi_Fragment.SetAdapter;
import com.example.g_skp.adapterPackage.RealisasiAdapter;
import com.example.g_skp.models.LoginModel;
import com.example.g_skp.models.RealisasiModel;
import com.example.g_skp.R;
import com.example.g_skp.ResponsePackage.ResponRealisasi;
import com.example.g_skp.ServicePackage.Services;
import com.example.g_skp.UtilPackage.Api;
import com.example.g_skp.UtilPackage.SharedPref;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Realisasi extends AppCompatActivity implements RealisasiAdapter.AdapterCallback {
    private RecyclerView recyclerView;
    private RealisasiAdapter adapter;
    Call<ResponRealisasi> call;
    private ArrayList<RealisasiModel> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realisasi);
        addData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_realisasi);
        adapter = new RealisasiAdapter(this, dataList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    void addData() {
        dataList = new ArrayList<>();
        dataList.add(new RealisasiModel("Dimas Maulana", "1414370309", "123456789", "Dimas Maulana", "1414370309", "123456789", "1414370309", "1"));
        dataList.add(new RealisasiModel("Fadly Yonk", "1214234560", "987654321", "1414370309", "123456789", "1414370309", "123456789", "0"));
        dataList.add(new RealisasiModel("Ariyandi Nugraha", "1214230345", "987648765", "1414370309", "123456789", "1414370309", "123456789", "1"));
        dataList.add(new RealisasiModel("Ariyandi Nugraha", "1214230345", "987648765", "1414370309", "123456789", "1414370309", "123456789", "1"));
    }
    public void getData() {
        LoginModel lgnModel = SharedPref.getUserData(this);
        assert lgnModel != null;
        String nip = lgnModel.getNip();
        String token = lgnModel.getToken();

        Services service = Api.getApiService();
            call = service.getRealisasi(nip, token);
            call.enqueue(new Callback<ResponRealisasi>() {
                @Override
                public void onResponse(@NonNull Call<ResponRealisasi> call, @NonNull Response<ResponRealisasi> response) {
                    if (response.body() != null) {
                        Toast.makeText(Realisasi.this, "aasa", Toast.LENGTH_SHORT).show();
                        Toast.makeText(Realisasi.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        List<RealisasiModel> data = response.body().getData();

                        for (RealisasiModel skp : data) {
                            saveDataDash(skp);
                            settingDataDash();
                            dataList.add(skp);
                        }
//                        saveDataDash(data);
                    } else {
                        Toast.makeText(getApplicationContext(), "Request Time out, Try again later", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<ResponRealisasi> call, @NonNull Throwable t) {
                    Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_SHORT).show();
                    if (call.isCanceled()) {
                        Log.e("error", t.getMessage());
                    }
                }
            });
        }
    private void saveDataDash(RealisasiModel data) {
        SharedPreferences preferences = SharedPref.getPref(this);
        preferences.edit().putString(Api.PREF.DATA_REALISASI, new Gson().toJson(data)).apply();
    }
    private void settingDataDash() {}
    @Override
    public void onRowMakananAdapterClicked(int position) {
//        String aa = dataList.get(position).getId_realisasi();
//        Toast.makeText(this, "You get"+aa, Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        bundle.putString("id_realisasi", dataList.get(position).getId_realisasi());
        bundle.putString("uraian", dataList.get(position).getUraian());
        bundle.putString("output", dataList.get(position).getOutput());
        bundle.putString("mutu", dataList.get(position).getMutu());
        bundle.putString("waktu", dataList.get(position).getWaktu());
        bundle.putString("biaya", dataList.get(position).getId_realisasi());
        bundle.putString("perhitugan", dataList.get(position).getId_realisasi());
        bundle.putString("capaian", dataList.get(position).getId_realisasi());

        Intent target = new Intent(this, SetAdapter.class);
        startActivity(target);
    }
}
