package com.example.g_skp.activity_Action;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.g_skp.R;

public class Target_View extends AppCompatActivity {
    private TextView txtUraian, txtOutput, txtMutu, txtWaktu, txtBiaya, txtDurasi, txtStatus, txtToolbar;
    String Uraian, Output, Mutu, Waktu, Biaya, Durasi, Status;
    private String data;
    RelativeLayout RView;
    private LinearLayout LnTambah;
    Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target__action);
        txtUraian = (TextView) findViewById(R.id.txtUraianTarget);
        txtOutput = (TextView) findViewById(R.id.txtOutputTarget);
        txtMutu = (TextView) findViewById(R.id.txtMutuTarget);
        txtWaktu = (TextView) findViewById(R.id.txtWaktuTarget);
        txtBiaya = (TextView) findViewById(R.id.txtBiayaTarget);
        txtStatus = (TextView) findViewById(R.id.txtStatusTarget);
        RView = (RelativeLayout) findViewById(R.id.form_view_target);
        LnTambah = (LinearLayout) findViewById(R.id.form_tambah_target);
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        txtToolbar = (TextView) findViewById(R.id.toolbar_title_target_action);
        getData();
        setData();
        // Required to use Toolbar as ActionBar
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtToolbar.setText("TARGET SKP");
        mToolBar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Do something
                Toast.makeText(getApplicationContext(), "Dismiss", Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void setData(){
        txtUraian.setText(Uraian);
        txtOutput.setText(Output);
        txtMutu.setText(Mutu);
        txtWaktu.setText(Waktu);
        txtBiaya.setText(Biaya);
        txtStatus.setText(Status);
    }

    public void getData() {
        Bundle bundle = getIntent().getExtras();
        Uraian = bundle.getString("uraian");
        Output = bundle.getString("output");
        Mutu = bundle.getString("mutu");
        Waktu = bundle.getString("waktu");
        Biaya = bundle.getString("biaya");
        Status = bundle.getString("status");
    }
}
