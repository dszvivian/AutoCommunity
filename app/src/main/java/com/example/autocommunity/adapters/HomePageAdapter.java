package com.example.autocommunity.adapters;

import static com.example.autocommunity.R.id;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autocommunity.R;
import com.example.autocommunity.model.HomePageItemsModel;

import java.util.List;

public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.ViewHolder> {

    R r ;
    private List<HomePageItemsModel> list;

    public HomePageAdapter(List<HomePageItemsModel> list){
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(com.example.autocommunity.R.layout.item_homepage,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomePageItemsModel item = list.get(position);
        holder.post.setImageResource(item.getPostImage());
        holder.profileIcon.setImageResource(item.getProfileImage());
        holder.username.setText(item.getUsername());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView post,profileIcon;
        TextView username;

        public ViewHolder(View itemView) {
            super(itemView);

            post = itemView.findViewById(id.ivHomePost);
            profileIcon = itemView.findViewById(id.ivHomeProfile);
            username = itemView.findViewById(id.tvHomeUsername);

        }
    }




}


