package com.example.g_skp.adapterPackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.g_skp.models.PenetapanTargetModel;

import java.util.ArrayList;

public class PenetapanTargetAdapter extends RecyclerView.Adapter<PenetapanTargetAdapter.PenetapanTargetViewHolder> {
    private Context context;
    private ArrayList<PenetapanTargetModel> dataList;
    private RealisasiAdapter.AdapterCallback mAdapterCallback;

    public PenetapanTargetAdapter(Context context, ArrayList<PenetapanTargetModel> dataList, RealisasiAdapter.AdapterCallback mAdapterCallback) {
        this.context = context;
        this.dataList = dataList;
        this.mAdapterCallback = mAdapterCallback;
    }

    @NonNull
    @Override
    public PenetapanTargetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PenetapanTargetViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PenetapanTargetViewHolder extends RecyclerView.ViewHolder{
        public PenetapanTargetViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
