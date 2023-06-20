package com.example.autocommunity.pages;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.autocommunity.R;
import com.example.autocommunity.adapters.HomePageAdapter;
import com.example.autocommunity.model.HomePageItemsModel;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    RecyclerView rv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        rv = view.findViewById(R.id.rvHome);

        ArrayList<HomePageItemsModel> postList = new ArrayList<>() ;
        postList.add(new HomePageItemsModel(R.drawable.bike1,R.drawable.profile1,"roshan_photography___"));
        postList.add(new HomePageItemsModel(R.drawable.bike1,R.drawable.profile1,"roshan_photography___"));
        postList.add(new HomePageItemsModel(R.drawable.bike1,R.drawable.profile1,"roshan_photography___"));
        postList.add(new HomePageItemsModel(R.drawable.bike1,R.drawable.profile1,"roshan_photography___"));
        postList.add(new HomePageItemsModel(R.drawable.bike1,R.drawable.profile1,"roshan_photography___"));
        postList.add(new HomePageItemsModel(R.drawable.bike1,R.drawable.profile1,"roshan_photography___"));
        postList.add(new HomePageItemsModel(R.drawable.bike1,R.drawable.profile1,"roshan_photography___"));
        postList.add(new HomePageItemsModel(R.drawable.bike1,R.drawable.profile1,"roshan_photography___"));

        HomePageAdapter adapter = new HomePageAdapter(postList);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

    }
}