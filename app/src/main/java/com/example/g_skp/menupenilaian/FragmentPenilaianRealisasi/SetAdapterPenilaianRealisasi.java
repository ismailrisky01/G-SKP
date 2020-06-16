package com.example.g_skp.menupenilaian.FragmentPenilaianRealisasi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.g_skp.menupenilaian.FragmentPenilaianRealisasi.Tabs.KreativitasFragment;
import com.example.g_skp.menupenilaian.FragmentPenilaianRealisasi.Tabs.RealisasiFragment;
import com.example.g_skp.menupenilaian.FragmentPenilaianRealisasi.Tabs.TambahanFragment;
import com.example.g_skp.R;
import com.google.android.material.tabs.TabLayout;

public class SetAdapterPenilaianRealisasi extends AppCompatActivity {
    private TabAdapterPenilaianRealisasi adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_adapter_penilaian_realisasi);
        viewPager = (ViewPager) findViewById(R.id.viewPager_penilaian);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout_penilaian);
        adapter = new TabAdapterPenilaianRealisasi(getSupportFragmentManager());
        adapter.addFragment(new RealisasiFragment(), "Tab 1");
        adapter.addFragment(new TambahanFragment(), "Tab 2");
        adapter.addFragment(new KreativitasFragment(), "Tab 3");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
