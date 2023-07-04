package com.example.autocommunity.pages;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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

    OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng sydney = new LatLng(70.6, 60.55);
            googleMap.addMarker(new MarkerOptions().position(sydney).title("Wayanad"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
    };





    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        vp_eventsInfo = view.findViewById(R.id.vp_eventsInfo);

        SupportMapFragment supportMapFragment=(SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.map);


        ArrayList<LatLng> locationList = new ArrayList<>();
        locationList.add(new LatLng(76.1320D,76.1320D));
        locationList.add(new LatLng(10.0889D,77.0595D));
        locationList.add(new LatLng(13.1413D,75.2537D));

        // Async map
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                // When map is loaded
                for(int i=0;i<locationList.size();i++){
                    googleMap.addMarker(new MarkerOptions().position(locationList.get(i)).title("Place"+i));
                    googleMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(locationList.get(i)));
                }
            }
        });


        ArrayList<EventInfoModel> list = new ArrayList<>();
        list.add(new EventInfoModel(76.1320D,76.1320D,"Wayanad","Cars and Cofeee","https://media.tacdn.com/media/attractions-splice-spp-674x446/06/74/7d/5f.jpg"));
        list.add(new EventInfoModel(10.0889D,77.0595D,"Munnar","Dirt Rides","https://sailorontheroad.files.wordpress.com/2020/01/photo_2020-01-02_16-25-53-1.jpg?w=1280"));
        list.add(new EventInfoModel(13.1413D,75.2537D,"Kudremukh","Experience the Heights","https://blog.caferides.com/wp-content/uploads/2019/07/darjeeling-sikkim-biking.jpg"));

        EventsInfoAdapter adapter = new EventsInfoAdapter(getActivity(),list);

        vp_eventsInfo.setAdapter(adapter);

        vp_eventsInfo = view.findViewById(R.id.vp_eventsInfo);

        //todo:fix events page


    }
}