package com.example.crudfirebase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MhsAdapter extends RecyclerView.Adapter<MhsAdapter.MhsVH> {

    private ArrayList<MahasiswaModel> mhsList;
    private final OnItemClickListener listener;


    public MhsAdapter(ArrayList<MahasiswaModel> mhsList ,OnItemClickListener listener) {
        this.mhsList = mhsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MhsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.item_list, parent, false);

        return new MhsVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MhsVH holder, int position) {
        holder.tvNama.setText(mhsList.get(position).getNama());
        holder.tvNim.setText(mhsList.get(position).getNim());
        holder.tvHp.setText(mhsList.get(position).getNoHp());

        holder.bind(mhsList, position, listener);
    }

    public interface OnItemClickListener{
        void OnItemClick(ArrayList<MahasiswaModel> mhsList, int position);
    }

    public void removeItem(int position){
        this.mhsList.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        return mhsList.size();
    }

    public class MhsVH extends RecyclerView.ViewHolder {

        private TextView tvNama, tvNim, tvHp;
        private CardView cvItem;

        public MhsVH(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tvNama);
            tvNim = itemView.findViewById(R.id.tvNim);
            tvHp = itemView.findViewById(R.id.tvHp);

            cvItem = itemView.findViewById(R.id.cvItem);
        }

        public void bind(final ArrayList<MahasiswaModel> mhsList, int position, OnItemClickListener listener){
            cvItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnItemClick(mhsList, position);
                    notifyDataSetChanged();
                }
            });
        }

    }
}
