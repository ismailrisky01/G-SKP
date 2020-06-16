package com.example.g_skp.menu_SKP;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.g_skp.activity_Action.Target_Tambah;
import com.example.g_skp.activity_Action.Target_View;
import com.example.g_skp.adapterPackage.TargetAdapter;
import com.example.g_skp.models.TargetModel;
import com.example.g_skp.R;
import com.example.g_skp.activity.DashBoardActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Target extends AppCompatActivity implements TargetAdapter.AdapterCallback {
    private RecyclerView recyclerView;
    private TargetAdapter adapter;
    Toolbar mToolBar;
    private ArrayList<TargetModel> dataArrayList = new ArrayList<>();
    FloatingActionButton fab_target;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        mToolBar = (Toolbar) findViewById(R.id.toolbar_target);
        setSupportActionBar(mToolBar);
        mToolBar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Do something
               Intent i = new Intent(getApplicationContext(), DashBoardActivity.class);
               startActivity(i);
            }
        });

        addData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_target);
        adapter = new TargetAdapter(this, dataArrayList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        Spinner dropdown = findViewById(R.id.spinner);
        String[] items = new String[]{"1", "2", "3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        fab_target = (FloatingActionButton) findViewById(R.id.floatingActionButton_Target);
        fab_target.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent target = new Intent(getApplicationContext(), Target_Tambah.class);
                startActivity(target);
            }
        });

    }

    void addData(){
        dataArrayList = new ArrayList<>();
        dataArrayList.add(new TargetModel("Dimas Maulana", "1414370309", "Mengelola Data Arsip","350", "Data", "23456789","12", "bulan", "1"));
        dataArrayList.add(new TargetModel("Fadly Yonk", "1214234560", "Mengelola Data Arsip","350", "Data","1414370309", "12","bulan", "1"));
        dataArrayList.add(new TargetModel("Ariyandi Nugraha", "1214230345", "Mengelola Data Arsip","350", "data","1414370309", "12","bulan", "1"));
        dataArrayList.add(new TargetModel("Ariyandi Nugraha", "1214230345", "Mengelola Data Arsip","350", "data","1414370309", "12","bulan", "1"));
        dataArrayList.add(new TargetModel("Ariyandi Nugraha", "1214230345", "Mengelola Data Arsip","350", "data","1414370309", "12","bulan", "1"));
        dataArrayList.add(new TargetModel("Ariyandi Nugraha", "1214230345", "Mengelola Data Arsip","350", "data","1414370309", "12","bulan", "1"));
    }

    @Override
    public void onRowAdapterClicked(int position) {

        Bundle bundle = new Bundle();
        bundle.putString("data","View");
        bundle.putString("nip", dataArrayList.get(position).getNip());
        bundle.putString("kode_jabatan", dataArrayList.get(position).getKode_jabatan());
        bundle.putString("uraian", dataArrayList.get(position).getUraian());
        bundle.putString("output", dataArrayList.get(position).getOutput());
        bundle.putString("satuan_output", dataArrayList.get(position).getSatuan_output());
        bundle.putString("mutu", dataArrayList.get(position).getMutu());
        bundle.putString("waktu", dataArrayList.get(position).getWaktu());
        bundle.putString("satuan_waktu", dataArrayList.get(position).getSatuan_waktu());
        bundle.putString("biaya", dataArrayList.get(position).getBiaya());

        Intent target = new Intent(this, Target_View.class);
        target.putExtras(bundle);
        startActivity(target);
    }
}

