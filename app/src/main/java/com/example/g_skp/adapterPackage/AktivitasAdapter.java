package com.example.g_skp.adapterPackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.g_skp.models.AktivitasModel;
import com.example.g_skp.R;

import java.util.ArrayList;

public class AktivitasAdapter extends RecyclerView.Adapter<AktivitasAdapter.AktivitasViewHolder> {
    private Context context;
    private ArrayList<AktivitasModel> dataList;
    private ArrayList<AktivitasModel> mdataList;
    private AktivtasadapterCallback mAdapterCallback;

    public AktivitasAdapter(Context context,ArrayList<AktivitasModel> dataList, AktivtasadapterCallback mAdapterCallback) {
        this.context = context;
        this.dataList = dataList;
        this.mdataList = dataList;
        this.mAdapterCallback = mAdapterCallback;

    }


    @NonNull
    @Override
    public AktivitasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_aktivitas, parent, false);
        return new AktivitasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AktivitasViewHolder holder, int position) {
        AktivitasModel item = dataList.get(position);
        holder.tv_log_id.setText(item.getLog_id());
        holder.tv_akt_tanggal.setText(item.getAkt_tanggal());
        holder.tv_bk_nama_kegiatan.setText(item.getBk_nama_kegiatann());
        holder.tv_akt_output.setText(item.getAkt_output());
        holder.tv_akt_start.setText(item.getAkt_start());
        holder.tv_akt_end.setText(item.getAkt_end());
        holder.tv_akt_waktu.setText(item.getAkt_waktu());
        if(item.getAkt_status().equals("1")){
            holder.imgX.setVisibility(View.GONE);
        }else {holder.imgV.setVisibility(View.GONE);}
        holder.tv_akt_status.setText(item.getAkt_status());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
    public class AktivitasViewHolder extends RecyclerView.ViewHolder {

        TextView tv_log_id, tv_akt_tanggal, tv_bk_nama_kegiatan,tv_akt_output,tv_akt_start,tv_akt_end,tv_akt_waktu,tv_akt_status;
        ImageView imgX,imgV;

        public AktivitasViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_log_id = (TextView) itemView.findViewById(R.id.log_id);
            tv_akt_tanggal = (TextView) itemView.findViewById(R.id.akt_tanggal);
            tv_bk_nama_kegiatan = (TextView) itemView.findViewById(R.id.bk_nama_kegiatan);
            tv_akt_output = (TextView) itemView.findViewById(R.id.akt_output);
            tv_akt_start = (TextView) itemView.findViewById(R.id.akt_start);
            tv_akt_end = (TextView) itemView.findViewById(R.id.akt_end);
            tv_akt_waktu = (TextView) itemView.findViewById(R.id.akt_waktu);
            tv_akt_status = (TextView) itemView.findViewById(R.id.akt_status);
            imgX = (ImageView) itemView.findViewById(R.id.status_xx);
            imgV = (ImageView) itemView.findViewById(R.id.status_vv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mAdapterCallback.onRowMakananAdapterClicked(getAdapterPosition());
                }
            });
        }

    }
    public interface AktivtasadapterCallback {

        void onRowMakananAdapterClicked(int position);
    }
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()) {
                    dataList = mdataList;
                } else {
                    ArrayList<AktivitasModel> filterList = new ArrayList<>();
                    for (AktivitasModel data : mdataList) {
                        if (data.getLog_id().toLowerCase().contains(charString) || data.getBk_nama_kegiatann().toLowerCase().contains(charString) || data.getAkt_waktu().toLowerCase().contains(charString)|| data.getAkt_tanggal().toLowerCase().contains(charString)|| data.getAkt_status().toLowerCase().contains(charString)|| data.getAkt_start().toLowerCase().contains(charString)|| data.getAkt_output().toLowerCase().contains(charString)|| data.getAkt_end().toLowerCase().contains(charString)) {
                            filterList.add(data);
                        }
                    }
                    dataList = filterList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = dataList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                //noinspection unchecked
//                mFilteredList = (ArrayList<AndroidVersion>) results.values;
                notifyDataSetChanged();
//                Log.e(MainActivity.TAG, "results=" + results);
            }
        };
    }
}
