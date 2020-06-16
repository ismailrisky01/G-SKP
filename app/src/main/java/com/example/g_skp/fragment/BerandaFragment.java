package com.example.g_skp.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.g_skp.models.DataDashboard;
import com.example.g_skp.models.LoginModel;
import com.example.g_skp.R;
import com.example.g_skp.ResponsePackage.ResponDashboard;
import com.example.g_skp.ServicePackage.Services;
import com.example.g_skp.UtilPackage.Api;
import com.example.g_skp.UtilPackage.SharedPref;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BerandaFragment extends Fragment {
    public ProgressBar pctarget, pcaktivitas, ptarget, paktivitas;
    public TextView tPersen;
    SwipeRefreshLayout swipeToRefresh;
    private static boolean refresh = false;
    Call<ResponDashboard> call;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);
        Toolbar actionBarToolBar = (Toolbar) view.findViewById(R.id.toolbar_beranda);
        setHasOptionsMenu(true);
        actionBarToolBar.setTitle("");
        actionBarToolBar.setSubtitle("");
        ((AppCompatActivity) getActivity()).setSupportActionBar(actionBarToolBar);
        ptarget = view.findViewById(R.id.target_horizontal);
        paktivitas = view.findViewById(R.id.aktivitas_Horizontal);
        return view;
    }

    public void getData() {
        LoginModel lgnModel = SharedPref.getUserData(getContext());
        assert lgnModel != null;
        String nip = lgnModel.getNip();
        String token = lgnModel.getToken();
        SharedPreferences sp = SharedPref.getPref(getContext());
        Services service = Api.getApiService();
        String data_dashboard = sp.getString(Api.PREF.DATA_DASHBOARD, null);
        if (data_dashboard == null || BerandaFragment.isRefresh()) {
            call = service.getDataDashboard(nip, token);
            call.enqueue(new Callback<ResponDashboard>() {
                @Override
                public void onResponse(@NonNull Call<ResponDashboard> call, @NonNull Response<ResponDashboard> response) {
                    if (response.body() != null) {
                        List<DataDashboard> data = response.body().getData();
                        Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        for (DataDashboard skp : data) {
                            saveDataDash(skp);
                            settingDataDash();
                        }
//                        saveDataDash(data);
                    } else {
                        swipeToRefresh.setRefreshing(false);
                        Toast.makeText(getContext(), "Request Time out, Try again later", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<ResponDashboard> call, @NonNull Throwable t) {
                    swipeToRefresh.setRefreshing(false);
                    Toast.makeText(getContext(), "Failure", Toast.LENGTH_SHORT).show();
                    if (call.isCanceled()) {
                        Log.e("error", t.getMessage());
                    }
                }
            });
        } else {
            settingDataDash();
        }
    }

    private void saveDataDash(DataDashboard data) {
        SharedPreferences preferences = SharedPref.getPref(getContext());
        preferences.edit().putString(Api.PREF.DATA_DASHBOARD, new Gson().toJson(data)).apply();
    }

    private void settingDataDash() {

        DataDashboard dbd = SharedPref.getDashboardData(getContext());
        assert dbd != null;
        int target = dbd.getTarget();
        int realisasi = dbd.getRealisasi();
        paktivitas.setProgress(realisasi);
        ptarget.setProgress(target);
    }

    public static boolean isRefresh() {
        return refresh;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        return true;
    }


}
