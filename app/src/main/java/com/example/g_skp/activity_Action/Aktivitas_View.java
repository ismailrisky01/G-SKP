package com.example.g_skp.activity_Action;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.g_skp.R;

public class Aktivitas_View extends AppCompatActivity {
String log_id,akt_tanggal,bk_nama,akt_output,akt_start,akt_end,akt_waktu,akt_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktivitas__view);
    }
    public void getDataIntent(){
        Bundle bundle = getIntent().getExtras();
        log_id = bundle.getString("log_id");
        akt_tanggal = bundle.getString("akt_tanggal");
        bk_nama = bundle.getString("bk_nama_kegiatan");
        akt_output = bundle.getString("akt_output");
        akt_start = bundle.getString("akt_end");
        akt_waktu = bundle.getString("akt_waktu");
        akt_status = bundle.getString("akt_status");


    }
}
