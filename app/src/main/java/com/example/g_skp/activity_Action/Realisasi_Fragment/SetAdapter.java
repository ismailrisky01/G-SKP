package com.example.g_skp.activity_Action.Realisasi_Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.g_skp.R;
import com.google.android.material.tabs.TabLayout;

public class SetAdapter extends AppCompatActivity {
    private TabLayout tabLayout;
    private TabAdapter adapter;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_adapter);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new Pokok(), "Pokok");
        adapter.addFragment(new Tambahan(), "Tambahan");
        adapter.addFragment(new Kreativitas(), "Kreativitas");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
