package com.example.g_skp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.g_skp.menupenilaian.FragmentPenilaianRealisasi.SetAdapterPenilaianRealisasi;
import com.example.g_skp.menupenilaian.PenetapanTarget;
import com.example.g_skp.menupenilaian.PenilaianAktivitas;
import com.example.g_skp.menupenilaian.PenilaianPerilaku;
import com.example.g_skp.R;


public class PenilaianFragment extends Fragment implements View.OnClickListener {

ImageView img1,img2,img3,img4;
TextView txt1,txt2,txt3,txt4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_penilaian, container, false);
        img1 = (ImageView) view.findViewById(R.id.imgPenetapanTarget);
        img2 = (ImageView) view.findViewById(R.id.imgPenetapanRealisasi);
        img3 = (ImageView) view.findViewById(R.id.imgPenetapanAktivitas);
        img4 = (ImageView) view.findViewById(R.id.imgPenilaianPerilaku);
        txt1 = (TextView) view.findViewById(R.id.txtPenetapanTarget);
        txt2 = (TextView) view.findViewById(R.id.txtPenetapanRealisasi);
        txt3 = (TextView) view.findViewById(R.id.txtPenetapanAktivitas);
        txt4 = (TextView) view.findViewById(R.id.txtPenilaianPerilaku);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        txt1.setOnClickListener(this);
        txt2.setOnClickListener(this);
        txt3.setOnClickListener(this);
        txt4.setOnClickListener(this);
        return view;

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgPenetapanTarget:
                Intent t = new Intent(getContext(), PenetapanTarget.class);
                startActivity(t);
                break;
            case R.id.imgPenetapanRealisasi:
                Intent r = new Intent(getContext(), SetAdapterPenilaianRealisasi.class);
                startActivity(r);
                break;
            case R.id.imgPenetapanAktivitas:
                Intent a = new Intent(getContext(), PenilaianAktivitas.class);
                startActivity(a);
                break;
            case R.id.imgPenilaianPerilaku:
                Intent p = new Intent(getContext(), PenilaianPerilaku.class);
                startActivity(p);
                break;
            case R.id.txtPenetapanTarget:
                Intent tt = new Intent(getContext(), PenetapanTarget.class);
                startActivity(tt);
                break;
        }
    }
}
