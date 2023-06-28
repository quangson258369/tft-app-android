package com.example.myapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.ListDataCompShow;
import com.example.myapplication.R;

import java.util.List;

public class TeamComp_Adapter extends RecyclerView.Adapter<TeamComp_Adapter.TeamCompViewHolder> {

    private List<ListDataCompShow> tempDataCompShowList;
    private Context mContext;

    public void setData(Context context, List<ListDataCompShow> tempDataCompShowList) {
        this.mContext = context;
        this.tempDataCompShowList = tempDataCompShowList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public TeamCompViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.teamcomp_rcv, parent, false);
        if (view != null) {
            Log.d("son", "successfully");
            return new TeamCompViewHolder(view);
        } else {
            Log.d("son", "Error");

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TeamCompViewHolder holder, int position) {
        ListDataCompShow teamComp = tempDataCompShowList.get(position);
        if (teamComp == null) {
            return;
        }
        String teamName = teamComp.getTeamCompName();
        holder.txtTeamCompName.setText(teamName);

        Champion_Adapter Cadapter = new Champion_Adapter();
        Cadapter.setData(teamComp.getChampionCompUseList());
        holder.rcvItemChampion.setAdapter(Cadapter);

        Synergy_Active_Adapter Sadapter = new Synergy_Active_Adapter();
        Sadapter.setData(teamComp.getSynergyActivesList());
        holder.rcvItemSynergyActives.setAdapter(Sadapter);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
        holder.rcvItemChampion.setLayoutManager(linearLayoutManager2);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
        holder.rcvItemSynergyActives.setLayoutManager(linearLayoutManager3);


    }

    @Override
    public int getItemCount() {
        if (tempDataCompShowList != null) {
            return tempDataCompShowList.size();
        }
        return 0;
    }

    public static class TeamCompViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtTeamCompName;
        private final RecyclerView rcvItemChampion;
        private final RecyclerView rcvItemSynergyActives;

        public TeamCompViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTeamCompName = itemView.findViewById(R.id.txtTeamName);
            rcvItemChampion = itemView.findViewById(R.id.rvChampion);
            rcvItemSynergyActives = itemView.findViewById(R.id.rvSynergy);


            txtTeamCompName.setOnClickListener(this::OnRedirectToDetail);
        }

        private void OnRedirectToDetail(View view) {

        }
    }
}
