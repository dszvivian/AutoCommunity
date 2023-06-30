package com.example.autocommunity.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.autocommunity.R;
import com.example.autocommunity.model.CompletePostModel;
import com.example.autocommunity.model.Post;

import java.util.List;

import retrofit2.http.POST;


public class VPProfilePostAdapter extends RecyclerView.Adapter<VPProfilePostAdapter.ViewHolder> {

    R r ;
    private List<Post> list;
    private Context context;

    public VPProfilePostAdapter(Context context, List<Post> list){
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

        holder.ibLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.ibLike.isChecked()){
                    holder.ibLike.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.ic_heart_svgrepo_com) );
                }
                else{
                    holder.ibLike.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.heart_svgrepo_com2) );
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView post,profileIcon;
        TextView username;

        ToggleButton ibLike;

        public ViewHolder(View itemView) {
            super(itemView);

            post = itemView.findViewById(R.id.ivHomePost);
            profileIcon = itemView.findViewById(R.id.ivHomeProfile);
            username = itemView.findViewById(R.id.tvHomeUsername);
            ibLike = itemView.findViewById(R.id.ibHomeLike);

        }
    }




}


