package com.example.autocommunity.adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.autocommunity.R;
import com.example.autocommunity.activities.ExtraActivity;
import com.example.autocommunity.model.EventInfoModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class EventsInfoAdapter extends RecyclerView.Adapter<EventsInfoAdapter.ViewHolder> {

    ArrayList<EventInfoModel> list;
    Context context;

    public EventsInfoAdapter(Context context,ArrayList<EventInfoModel> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.eventsitem,parent,false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EventInfoModel item = list.get(position);

        holder.agenda.setText(item.getAgenda() + " | " + item.getPlaceName());

        Glide
                .with(context)
                .load(item.getCoverImage())
                .centerCrop()
                .into(holder.coverImage);

        holder.eventInfoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iExtraActivity =  new Intent(context, ExtraActivity.class);
                Bundle bd = new Bundle();
                bd.putString("fname","ECPF");
                bd.putString("coverImage",item.getCoverImage());
                bd.putString("title",item.getAgenda());
                bd.putString("place",item.getPlaceName());
                iExtraActivity.putExtras(bd);
                context.startActivity(iExtraActivity);
            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView agenda ;
        ImageView coverImage;
        FragmentContainerView map;
        ConstraintLayout eventInfoLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            agenda = itemView.findViewById(R.id.tv_eventsAgenda);
            coverImage = itemView.findViewById(R.id.iv_eventsCoverImage);
            eventInfoLayout = itemView.findViewById(R.id.eventInfoSection);


        }
    }
}
