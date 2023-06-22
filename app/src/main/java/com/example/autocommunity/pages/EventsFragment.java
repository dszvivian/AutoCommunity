package com.example.autocommunity.pages;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.autocommunity.R;
import com.example.autocommunity.adapters.EventsInfoAdapter;
import com.example.autocommunity.model.EventInfoModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class EventsFragment extends Fragment {

    ViewPager2 vp_eventsInfo;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_events, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        vp_eventsInfo = view.findViewById(R.id.vp_eventsInfo);

        ArrayList<EventInfoModel> list = new ArrayList<>();
        list.add(new EventInfoModel(76.1320D,76.1320D,"Wayanad","Cars and Cofeee",R.drawable.bike1));
        list.add(new EventInfoModel(10.0889D,77.0595D,"Munnar","Dirt Rides",R.drawable.bike1));
        list.add(new EventInfoModel(13.1413D,75.2537D,"Kudremukh","Experience the Heights",R.drawable.bike1));

        EventsInfoAdapter adapter = new EventsInfoAdapter(getActivity(),list);

        vp_eventsInfo.setAdapter(adapter);

        vp_eventsInfo = view.findViewById(R.id.vp_eventsInfo);


    }
}