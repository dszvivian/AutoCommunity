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
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.autocommunity.ApiViewModel;
import com.example.autocommunity.Preferences;
import com.example.autocommunity.R;
import com.example.autocommunity.model.CompletePostModel;
import com.example.autocommunity.model.Post;
import com.example.autocommunity.model.ProfileDetails;

import java.util.List;

import retrofit2.http.POST;


public class VPProfilePostAdapter extends RecyclerView.Adapter<VPProfilePostAdapter.ViewHolder> {

    R r ;
    private List<Post> list;
    private Context context;
    LifecycleOwner lcOwner;

    public VPProfilePostAdapter(Context context,LifecycleOwner lcOwner, List<Post> list){
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
        Post item = list.get(position);

        Glide
                .with(context)
                .load(item.getPostImage())
                .centerCrop()
                .into(holder.post);

        Preferences pf = new Preferences();

        String username = pf.isLoggedIn(context);



        //todo:Fix it --> Get it from Database
        holder.profileIcon.setImageResource(R.drawable.profile1);
        holder.username.setText(username);


        ApiViewModel vm = new ApiViewModel();
        vm.getProfileDetails(username).observe(lcOwner, new Observer<List<ProfileDetails>>() {
            @Override
            public void onChanged(List<ProfileDetails> profileDetails) {
                Glide
                        .with(context)
                        .load(profileDetails.get(0).getpPicture())
                        .centerCrop()
                        .into(holder.profileIcon);
            }
        });

        holder.ibLike.setVisibility(View.GONE);


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


