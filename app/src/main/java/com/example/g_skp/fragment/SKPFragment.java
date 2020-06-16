package com.example.g_skp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.g_skp.menu_SKP.Realisasi;
import com.example.g_skp.menu_SKP.Target;
import com.example.g_skp.R;

public class SKPFragment extends Fragment  {
    Button btnTarget, btnRealisasi;

    public SKPFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_skp, container, false);
        btnTarget = (Button) view.findViewById(R.id.buttonTarget);
        btnRealisasi = (Button) view.findViewById(R.id.buttonRealisasi);
        btnTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent target = new Intent(getContext(), Target.class);
                startActivity(target);
            }
        });
        btnRealisasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent realisasi = new Intent(getContext(), Realisasi.class);
                startActivity(realisasi);
            }
        });
        return  view;
    }

}
