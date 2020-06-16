package com.example.g_skp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.g_skp.fragment.AktivitasFragment;
import com.example.g_skp.fragment.BerandaFragment;
import com.example.g_skp.fragment.PenilaianFragment;
import com.example.g_skp.fragment.ProfileFragment;
import com.example.g_skp.fragment.SKPFragment;
import com.example.g_skp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashBoardActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemReselectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        BottomNavigationView bottomNavigationView = findViewById(R.id.btn_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        loadFragment(new BerandaFragment());

    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.framelayout, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.home:
                fragment = new BerandaFragment();
                break;
            case R.id.order:
                fragment = new AktivitasFragment();
                break;
            case R.id.add:
                fragment = new SKPFragment();
                break;
            case R.id.penilaian:
                fragment = new PenilaianFragment();
                break;
            case R.id.history:
                fragment = new ProfileFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
