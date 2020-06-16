package com.example.g_skp.adapterPackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.g_skp.models.PenilaianAktivitas;

import java.util.ArrayList;

public class PenilaianAktivitasAdapter extends RecyclerView.Adapter<PenilaianAktivitasAdapter.PenilaianAktivitasViewHolder> {
    private Context context;
    private ArrayList<PenilaianAktivitas> dataList;
    private RealisasiAdapter.AdapterCallback mAdapterCallback;
    public PenilaianAktivitasAdapter(Context context, ArrayList<PenilaianAktivitas> dataList, RealisasiAdapter.AdapterCallback adapterCallback) {
        this.context = context;
        this.dataList = dataList;
        this.mAdapterCallback = adapterCallback;
    }

    @NonNull
    @Override
    public PenilaianAktivitasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PenilaianAktivitasViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class PenilaianAktivitasViewHolder extends RecyclerView.ViewHolder{
        public PenilaianAktivitasViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
