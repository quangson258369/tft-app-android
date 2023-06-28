package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.ChampionCompUse;
import com.example.myapplication.R;

import java.util.List;

public class Champion_Adapter extends RecyclerView.Adapter<Champion_Adapter.Champion_Adapter_ViewHolder> {
private List<ChampionCompUse>championDescriptions;

    public void setData(List<ChampionCompUse> list) {
        this.championDescriptions = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public Champion_Adapter_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_champion, parent, false);

        return new Champion_Adapter_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Champion_Adapter_ViewHolder holder, int position) {
        ChampionCompUse championCompUse = championDescriptions.get(position);
        holder.mImageView.setImageBitmap(championCompUse.getChampionBitmap());
    }

    @Override
    public int getItemCount() {
        if(championDescriptions!=null){
            return championDescriptions.size();
        }
        return 0;
    }

    public class Champion_Adapter_ViewHolder extends RecyclerView.ViewHolder {


        private ImageView mImageView;

        public Champion_Adapter_ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imgBaseItem);
        }
    }
}
