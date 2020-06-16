package com.example.g_skp.menupenilaian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.g_skp.R;

public class PenetapanTarget extends AppCompatActivity {
    Toolbar mToolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penetapan_target);
        mToolBar = (Toolbar) findViewById(R.id.toolbar_penetapan_target);
        setSupportActionBar(mToolBar);
        mToolBar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Do something
                Toast.makeText(getApplicationContext(), "Dismiss", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
