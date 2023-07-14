package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.ChampionCompUse;
import com.example.myapplication.R;

import java.util.List;

public class Champion_Adapter extends RecyclerView.Adapter<Champion_Adapter.Champion_Adapter_ViewHolder> {
    private List<ChampionCompUse> championDescriptions;
    private OnItemClickListener listener;

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
        String name = championCompUse.getNameChampion();
        String capitalized = name.substring(0, 1).toUpperCase() + name.substring(1);
        holder.tvChampName.setText(capitalized);
    }

    @Override
    public int getItemCount() {
        return championDescriptions != null ? championDescriptions.size() : 0;
    }

    public class Champion_Adapter_ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView mImageView;
        private TextView tvChampName;

        public Champion_Adapter_ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imgBaseItem);
            tvChampName = itemView.findViewById(R.id.tvChampName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION && listener != null) {
                listener.onItemClick(position);
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
