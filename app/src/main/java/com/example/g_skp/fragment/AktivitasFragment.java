package com.example.g_skp.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.g_skp.activity_Action.Aktivitas_Tambah;
import com.example.g_skp.activity_Action.Aktivitas_View;
import com.example.g_skp.adapterPackage.AktivitasAdapter;
import com.example.g_skp.models.AktivitasModel;
import com.example.g_skp.models.LoginModel;
import com.example.g_skp.R;
import com.example.g_skp.ResponsePackage.ResponAktivitas;
import com.example.g_skp.ServicePackage.Services;
import com.example.g_skp.UtilPackage.Api;
import com.example.g_skp.UtilPackage.SharedPref;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AktivitasFragment extends Fragment implements AktivitasAdapter.AktivtasadapterCallback, SearchView.OnQueryTextListener {
    FloatingActionButton fab;
    ProgressDialog progressDialog;
    Call<ResponAktivitas> call;
    private RecyclerView recyclerView;
    private AktivitasAdapter adapter;
    ArrayList<AktivitasModel> listAkt = new ArrayList<>();
    SwipeRefreshLayout swipeRefresh;
    SearchView search_view;

    public AktivitasFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
        addData();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_aktivitas, container, false);
        Toolbar actionBarToolBar = (Toolbar) view.findViewById(R.id.toolbar_aktivitas);
        setHasOptionsMenu(true);
        actionBarToolBar.setTitle("");
        actionBarToolBar.setSubtitle("");
        ((AppCompatActivity) getActivity()).setSupportActionBar(actionBarToolBar);
        TextView toolbarText = (TextView) view.findViewById(R.id.toolbar_title_aktivitas);
        if (toolbarText != null && actionBarToolBar != null) {
            toolbarText.setText("AKTIVITAS");
        }


        progressDialog = new ProgressDialog(getContext());
        swipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_aktivitas);
        search_view = (SearchView) view.findViewById(R.id.search_view);
        search_view.setOnQueryTextListener(this);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                addData();
            }
        });


        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_aktivitas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new AktivitasAdapter(getContext(), listAkt, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        fab = (FloatingActionButton) view.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Aktivitas_Tambah.class));
            }
        });


        return view;
    }

    public void loading() {
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading data...");
        progressDialog.show();
    }

    public void Getdata() {
        LoginModel lgn = SharedPref.getUserData(getContext());
        assert lgn != null;
        String nip = lgn.getNip();
        String token = lgn.getToken();
        SharedPreferences sp = SharedPref.getPref(getContext());
        Services service = Api.getApiService();
        String data_aktivitas = sp.getString(Api.PREF.DATA_AKTIVITAS, null);


        call = service.getAktivitas(nip, token);
        call.enqueue(new Callback<ResponAktivitas>() {
            @Override
            public void onResponse(@NonNull Call<ResponAktivitas> call, @NonNull Response<ResponAktivitas> response) {
                if (response.body() != null) {
                    swipeRefresh.setRefreshing(false);
                    List<AktivitasModel> data = response.body().getData();
                    for (AktivitasModel skp : data) {
                        listAkt.add(skp);
                        saveDataDash(skp);
                    }
                } else {

                    Toast.makeText(getContext(), "Request Time out, Try again later", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponAktivitas> call, @NonNull Throwable t) {
                Toast.makeText(getContext(), "failure", Toast.LENGTH_SHORT).show();
                if (call.isCanceled()) {
                    Log.e("error", t.getMessage());
                }
            }
        });


    }


    @Override
    public void onRowMakananAdapterClicked(int position) {
//        String aa = listAkt.get(position).getLog_id();
//        Toast.makeText(getContext(), "You get" + aa, Toast.LENGTH_SHORT).show();
        Bundle budle = new Bundle();
        budle.putString("log_id",listAkt.get(position).getLog_id());
        budle.putString("akt_tanggal",listAkt.get(position).getAkt_tanggal());
        budle.putString("bk_nama_kegiatan",listAkt.get(position).getBk_nama_kegiatann());
        budle.putString("akt_output",listAkt.get(position).getAkt_output());
        budle.putString("akt_start",listAkt.get(position).getAkt_start());
        budle.putString("akt_end",listAkt.get(position).getAkt_end());
        budle.putString("akt_waktu",listAkt.get(position).getAkt_waktu());
        budle.putString("akt_status",listAkt.get(position).getAkt_status());
        Intent target = new Intent(getContext(), Aktivitas_View.class);
        target.putExtras(budle);
        startActivity(target);
    }

    void addData() {
        listAkt = new ArrayList<>();
        listAkt.add(new AktivitasModel("Dimas Maulana", "1414370309", "123456789", "Dimas Maulana", "1414370309", "123456789", "1414370309", "1"));
        listAkt.add(new AktivitasModel("Fadly Yonk", "1214234560", "987654321", "1414370309", "123456789", "1414370309", "123456789", "0"));
        listAkt.add(new AktivitasModel("Ariyandi Nugraha", "1214230345", "987648765", "1414370309", "123456789", "1414370309", "123456789", "1"));
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adapter.getFilter().filter(s);
        return false;
    }

    public void settingData() {
        AktivitasModel dbd = SharedPref.getAktivitasData(getContext());
        assert dbd != null;
        listAkt.add(dbd);
    }

    private void saveDataDash(AktivitasModel data) {
        SharedPreferences preferences = SharedPref.getPref(getContext());
        preferences.edit().putString(Api.PREF.DATA_AKTIVITAS, new Gson().toJson(data)).apply();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_top, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.before) {
        } else if (item.getItemId() == R.id.after) {
        } else if (item.getItemId() == R.id.between) {
        }

        return true;
    }

}
