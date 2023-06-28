package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.SynergyActive;
import com.example.myapplication.R;

import java.util.List;

public class Synergy_Active_Adapter extends RecyclerView.Adapter<Synergy_Active_Adapter.Synergy_Active_ViewHolder> {
    private List<SynergyActive> synergyActives;

    public void setData(List<SynergyActive> list) {
        this.synergyActives = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Synergy_Active_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_synerggy_active, parent, false);
        return new Synergy_Active_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Synergy_Active_ViewHolder holder, int position) {
        SynergyActive synergyActive= synergyActives.get(position);
        if(synergyActive==null){
            return;
        }
        if(synergyActive.getStyle()==5){
            holder.mFrameLayout.setBackgroundResource(R.drawable.shape_synergies_chronic);
        } else if (synergyActive.getStyle()==4) {
            holder.mFrameLayout.setBackgroundResource(R.drawable.shape_synergies_gold);
        } else if (synergyActive.getStyle()==3) {
            holder.mFrameLayout.setBackgroundResource(R.drawable.shape_synergies_silver);
        }
        else {
            holder.mFrameLayout.setBackgroundResource(R.drawable.shape_synergies_bronze);
        }

        holder.mImageView.setImageBitmap(synergyActive.getActiveBitmap());

    }

    @Override
    public int getItemCount() {
        if(synergyActives!=null){
            return synergyActives.size();
        }
        return 0;
    }

    public static class Synergy_Active_ViewHolder extends RecyclerView.ViewHolder {

        private final FrameLayout mFrameLayout;
        private final ImageView mImageView;

        public Synergy_Active_ViewHolder(@NonNull View itemView) {
            super(itemView);
            mFrameLayout = itemView.findViewById(R.id.flSynergyBackground);
            mImageView = itemView.findViewById(R.id.imgSynergy);
        }
    }
}
