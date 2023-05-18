package com.example.autocommunity.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autocommunity.R;
import com.example.autocommunity.model.SearchPageItemModel;

import java.util.ArrayList;

public class SearchItemsAdapter extends RecyclerView.Adapter<SearchItemsAdapter.ViewHolder> {

    private ArrayList<SearchPageItemModel> list;

    public SearchItemsAdapter(ArrayList<SearchPageItemModel> list){
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_searchpage,parent,false);
        return new SearchItemsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchItemsAdapter.ViewHolder holder, int position) {
        SearchPageItemModel item = list.get(position);
        holder.profileIcon.setImageResource(item.getProfileId());
        holder.username.setText(item.getUsername());
        holder.location.setText(item.getLocation());
        holder.desc.setText(item.getDescription());

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView profileIcon;
        TextView username,location,desc;

        public ViewHolder(View itemView) {
            super(itemView);

            profileIcon = itemView.findViewById(R.id.ivSearchProfileimage);
            username = itemView.findViewById(R.id.tvSearchUsername);
            location = itemView.findViewById(R.id.tvSearchlocation);
            desc = itemView.findViewById(R.id.tvSearchDescription);

        }
    }




}


