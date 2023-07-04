package com.example.autocommunity.adapters;

import static com.example.autocommunity.R.id;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.autocommunity.ApiViewModel;
import com.example.autocommunity.R;
import com.example.autocommunity.model.CompletePostModel;
import com.example.autocommunity.model.HomePageItemsModel;
import com.example.autocommunity.model.Post;
import com.example.autocommunity.model.ProfileDetails;

import java.util.List;

import retrofit2.http.POST;

public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.ViewHolder> {

    R r ;
    private List<CompletePostModel> list;
    LifecycleOwner lcOwner;
    private Context context;

    public HomePageAdapter(Context context,LifecycleOwner lcOwner, List<CompletePostModel> list){
        this.list = list;
        this.lcOwner = lcOwner;
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
        CompletePostModel item = list.get(position);

        Glide
            .with(context)
            .load(item.getPostImage())
            .centerCrop()
            .into(holder.post);



        //todo:Fix it --> Get it from Database
        holder.profileIcon.setImageResource(R.drawable.profile1);
        holder.username.setText(item.getUsername());

        ApiViewModel vm = new ApiViewModel();
        vm.getProfileDetails(item.getUsername()).observe(lcOwner, new Observer<List<ProfileDetails>>() {
            @Override
            public void onChanged(List<ProfileDetails> profileDetails) {
                Glide
                        .with(context)
                        .load(profileDetails.get(0).getpPicture())
                        .centerCrop()
                        .into(holder.profileIcon);
            }
        });

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

            post = itemView.findViewById(id.ivHomePost);
            profileIcon = itemView.findViewById(id.ivHomeProfile);
            username = itemView.findViewById(id.tvHomeUsername);
            ibLike = itemView.findViewById(id.ibHomeLike);

        }
    }




}


