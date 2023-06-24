package com.example.autocommunity.adapters;

import static com.example.autocommunity.R.id;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.autocommunity.R;
import com.example.autocommunity.model.HomePageItemsModel;
import com.example.autocommunity.model.Post;

import java.util.List;

import retrofit2.http.POST;

public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.ViewHolder> {

    R r ;
    private List<Post> list;
    private Context context;

    public HomePageAdapter(Context context, List<Post> list){
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(com.example.autocommunity.R.layout.item_homepage,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post item = list.get(position);

        Glide
            .with(context)
            .load(item.getPostImage())
            .centerCrop()
            .into(holder.post);



        //todo:Fix it --> Get it from Database
        holder.profileIcon.setImageResource(R.drawable.profile1);
        holder.username.setText("dszvivian");
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


