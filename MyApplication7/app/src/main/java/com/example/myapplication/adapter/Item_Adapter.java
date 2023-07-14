package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.ChampionCompUse;
import com.example.myapplication.Models.Item;
import com.example.myapplication.Models.ItemCompUse;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Item_Adapter extends RecyclerView.Adapter<Item_Adapter.Item_Adapter_ViewHolder> implements Filterable {
    private List<ItemCompUse>itemList;
    private List<ItemCompUse>itemListold;
    public void setData(List<ItemCompUse> list) {
        this.itemList = list;
        this.itemListold = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public Item_Adapter_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_items, parent, false);

        return new Item_Adapter_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Item_Adapter_ViewHolder holder, int position) {
        ItemCompUse item = itemList.get(position);
        holder.imageBaseItem.setImageBitmap(item.getImageItem());
        holder.textViewName.setText(item.getNameItem());
        holder.textViewDescription.setText(item.getDescriptionItem());
    }

    @Override
    public int getItemCount() {
        if(itemList!=null){
            return itemList.size();
        }
        return 0;
    }

    public class Item_Adapter_ViewHolder extends RecyclerView.ViewHolder {


        private ImageView imageBaseItem;
        private TextView textViewName;
        private TextView textViewDescription;
        public Item_Adapter_ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageBaseItem = itemView.findViewById(R.id.imgBaseItem);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
        }
    }
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String strSearch = constraint.toString();
                if(strSearch.isEmpty()){
                    itemList=itemListold;
                }else{
                    List<ItemCompUse> listItem= new ArrayList<>();
                    for(ItemCompUse itemCompUse:itemListold){
                        if (itemCompUse.getNameItem().toLowerCase().contains(strSearch.toLowerCase())){
                            listItem.add(itemCompUse);
                        }
                        itemList = listItem;
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values= itemList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                itemList=(List<ItemCompUse>) results.values;
                notifyDataSetChanged();
            }
        };
    }

}
