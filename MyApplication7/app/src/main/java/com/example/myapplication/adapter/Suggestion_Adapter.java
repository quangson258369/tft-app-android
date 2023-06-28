package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.Champion;
import com.example.myapplication.Models.Item;
import com.example.myapplication.Models.Suggestion;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Suggestion_Adapter extends ArrayAdapter<Suggestion> {

    private List<Suggestion> suggestionsListFull;

    public Suggestion_Adapter(@NonNull Context context, @NonNull List<Suggestion> suggestionList) {
        super(context, 0, suggestionList);
        suggestionsListFull = new ArrayList<>(suggestionList);
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return suggestFilter;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_suggestion, parent, false);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.txtName);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imgSuggestion);

        Suggestion suggestion = getItem(position);
        if(suggestion!=null){
            textView.setText(suggestion.getTitle());
            imageView.setImageBitmap(suggestion.getImgSuggester());
        }
        return convertView;
    }

    private Filter suggestFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            List<Suggestion> suggestions = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                suggestions.addAll(suggestionsListFull);
            } else {
                String filter = constraint.toString().toLowerCase().trim();
                for (Suggestion suggestion : suggestionsListFull) {
                    if (suggestion.getTitle().toLowerCase().contains(filter)) {
                        suggestions.add(suggestion);
                    }
                }
            }
            results.values = suggestions;
            results.count = suggestions.size();

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            clear();
            addAll((List) results.values);
            notifyDataSetChanged();
        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((Suggestion) resultValue).getTitle();
        }
    };
}

