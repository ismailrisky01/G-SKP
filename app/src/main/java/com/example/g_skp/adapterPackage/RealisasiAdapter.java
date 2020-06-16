package com.example.g_skp.adapterPackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.g_skp.models.RealisasiModel;
import com.example.g_skp.R;

import java.util.ArrayList;

public class RealisasiAdapter extends RecyclerView.Adapter<RealisasiAdapter.RealisasiViewHolder> {
    private Context context;
    private ArrayList<RealisasiModel> dataList;
    private AdapterCallback mAdapterCallback;

    public RealisasiAdapter(Context context, ArrayList<RealisasiModel> dataList, AdapterCallback adapterCallback) {
        this.context = context;
        this.dataList = dataList;
        this.mAdapterCallback = adapterCallback;
    }

    @NonNull
    @Override
    public RealisasiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_realisasi, parent, false);
        return new RealisasiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RealisasiViewHolder holder, int position) {
        RealisasiModel item = dataList.get(position);
        holder.id_realisasi.setText(item.getId_realisasi());
        holder.uraian.setText(item.getUraian());
        holder.r_output.setText(item.getOutput());
        holder.r_mutu.setText(item.getMutu());
        holder.r_biaya.setText(item.getBiaya());
        holder.r_perhitungan.setText(item.getPerhitungan());
        holder.r_capaian.setText(item.getCapaian());
        holder.r_waktu.setText(item.getWaktu());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class RealisasiViewHolder extends RecyclerView.ViewHolder {
        TextView id_realisasi, uraian, r_output,r_mutu,r_waktu,r_biaya,r_perhitungan,r_capaian;
        public RealisasiViewHolder(@NonNull View itemView) {
            super(itemView);
            id_realisasi = (TextView) itemView.findViewById(R.id.id_realisasi);
            uraian = (TextView) itemView.findViewById(R.id.uraian);
            r_output = (TextView) itemView.findViewById(R.id.r_output);
            r_mutu = (TextView) itemView.findViewById(R.id.r_mutu);
            r_waktu = (TextView) itemView.findViewById(R.id.r_waktu);
            r_biaya = (TextView) itemView.findViewById(R.id.r_biaya);
            r_perhitungan = (TextView) itemView.findViewById(R.id.r_perhitungan);
            r_capaian = (TextView) itemView.findViewById(R.id.r_capaian);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mAdapterCallback.onRowMakananAdapterClicked(getAdapterPosition());
                }
            });
        }
    }
    public interface AdapterCallback {
        /*
        Disini kalian bisa membuat beberapa fungsi dengan parameter sesuai kebutuhan. Kebutuhan
        disini adalah untuk mendapatkan pada posisi mana user mengklik listnya.
         */
        void onRowMakananAdapterClicked(int position);
    }

}
