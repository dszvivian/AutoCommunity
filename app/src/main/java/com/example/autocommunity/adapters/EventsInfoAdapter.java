package com.example.autocommunity.adapters;

import android.content.Context;
import android.media.Image;
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

import com.example.autocommunity.R;
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
        holder.coverImage.setImageResource(item.getCoverImage());

        holder.eventInfoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo: Direct it to Events Confirm Page
            }
        });








        OnMapReadyCallback callback = new OnMapReadyCallback() {

            @Override
            public void onMapReady(GoogleMap googleMap) {
                LatLng sydney = new LatLng(item.getLat(), item.getLon());
                googleMap.addMarker(new MarkerOptions().position(sydney).title(item.getPlaceName()));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            }
        };

        SupportMapFragment mapFragment = (SupportMapFragment) ((AppCompatActivity)context).getSupportFragmentManager().findFragmentById(R.id.map);






        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }

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
            map = itemView.findViewById(R.id.map);
            eventInfoLayout = itemView.findViewById(R.id.eventInfoSection);


        }
    }
}
