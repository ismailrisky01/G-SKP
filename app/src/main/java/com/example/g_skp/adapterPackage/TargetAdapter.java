package com.example.g_skp.adapterPackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.g_skp.models.TargetModel;
import com.example.g_skp.R;

import java.util.ArrayList;

public class TargetAdapter extends RecyclerView.Adapter<TargetAdapter.TargetViewHolder>{
    private Context context;
    private ArrayList<TargetModel> dataList;
    private AdapterCallback mAdapterCallback;

    public TargetAdapter(Context context, ArrayList<TargetModel> dataList, AdapterCallback mAdapterCallback) {
        this.context = context;
        this.dataList = dataList;
        this.mAdapterCallback = mAdapterCallback;
    }


    @NonNull
    @Override
    public TargetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_target, parent, false);
        return new TargetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TargetAdapter.TargetViewHolder holder, int position) {
        TargetModel item = dataList.get(position);
        holder.tv_nip.setText(item.getNip());
        holder.tv_kode_jabatan.setText(item.getKode_jabatan());
        holder.tv_uraian.setText(item.getUraian());
        holder.tv_output.setText(item.getOutput()+" "+item.getSatuan_output());
        holder.tv_mutu.setText(item.getMutu());
        String waktu =String.valueOf(item.getWaktu()+" "+item.getSatuan_waktu());
        holder.tv_waktu.setText(waktu);
        holder.tv_biaya.setText(item.getBiaya());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class TargetViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nip, tv_kode_jabatan, tv_uraian, tv_output, tv_satuan_output, tv_mutu, tv_waktu, tv_satuan_waktu, tv_biaya;

        public TargetViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nip = (TextView) itemView.findViewById(R.id.nip);
            tv_kode_jabatan = (TextView) itemView.findViewById(R.id.kode_jabatan);
            tv_uraian = (TextView) itemView.findViewById(R.id.uraian);
            tv_output = (TextView) itemView.findViewById(R.id.output);
            tv_mutu = (TextView) itemView.findViewById(R.id.mutu);
            tv_waktu = (TextView) itemView.findViewById(R.id.waktu);
            tv_biaya = (TextView) itemView.findViewById(R.id.biaya);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mAdapterCallback.onRowAdapterClicked(getAdapterPosition());
                }
            });
        }
    }
    public interface AdapterCallback {
        /*
        Disini kalian bisa membuat beberapa fungsi dengan parameter sesuai kebutuhan. Kebutuhan
        disini adalah untuk mendapatkan pada posisi mana user mengklik listnya.
         */
        void onRowAdapterClicked(int position);
    }
}
