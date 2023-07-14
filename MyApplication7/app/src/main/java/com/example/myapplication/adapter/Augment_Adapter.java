package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.Augment;
import com.example.myapplication.R;

import java.util.List;

public class Augment_Adapter extends RecyclerView.Adapter<Augment_Adapter.AugmentViewHolder>{

    private Context mContext;

    private List<Augment> mListAugment;

    public Augment_Adapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Augment> list){
        this.mListAugment = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AugmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_show_augment_list, parent, false);

        return new AugmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AugmentViewHolder holder, int position) {
        Augment aug = mListAugment.get(position);
        if(aug == null){
            return;
        }
        holder.imgAugment.setImageBitmap(aug.getIconBitmap());
        holder.Aug_Name.setText(aug.getName());
        holder.Aug_Description.setText(aug.getDescription());
    }

    @Override
    public int getItemCount() {
        if(mListAugment != null){
            return mListAugment.size();
        }
        return 0;
    }

    public class AugmentViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgAugment;

        private TextView Aug_Name;

        private TextView Aug_Description;

        public AugmentViewHolder(@NonNull View itemView) {
            super(itemView);

            imgAugment = itemView.findViewById(R.id.img_augment);

            Aug_Name = itemView.findViewById(R.id.aug_name);

            Aug_Description = itemView.findViewById(R.id.aug_description);
        }
    }
}
