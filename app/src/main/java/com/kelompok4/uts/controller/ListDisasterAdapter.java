package com.kelompok4.uts.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kelompok4.uts.model.Disaster;
import com.kelompok4.uts.R;

import java.util.ArrayList;

public class ListDisasterAdapter extends RecyclerView.Adapter<ListDisasterAdapter.ListViewHolder> {
    private ArrayList<Disaster> listDisaster;

    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }
    public ListDisasterAdapter(ArrayList<Disaster> list){
        this.listDisaster = list;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.item_row_disaster, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Disaster disaster = listDisaster.get(position);
        holder.imgPhoto.setImageResource(disaster.getPhoto());
        holder.tvName.setText(disaster.getName());
        holder.tvDescription.setText(disaster.getDescription());
    }
    public interface OnItemClickCallback {
        void onItemClicked(Disaster data);
    }

    @Override
    public int getItemCount() {
        return listDisaster.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDescription;

        ListViewHolder(View itemView){
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }
    }
}
