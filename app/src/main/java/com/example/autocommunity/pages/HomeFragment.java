package com.example.autocommunity.pages;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.autocommunity.ApiViewModel;
import com.example.autocommunity.R;
import com.example.autocommunity.adapters.HomePageAdapter;
import com.example.autocommunity.model.HomePageItemsModel;
import com.example.autocommunity.model.Post;

import java.util.ArrayList;


//todo:fix Layout

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

        ApiViewModel vm =new ApiViewModel();

        vm.getAllPosts().observe(requireActivity(), new Observer<ArrayList<Post>>() {
            @Override
            public void onChanged(ArrayList<Post> posts) {
                HomePageAdapter adapter = new HomePageAdapter(requireActivity(),posts);
                rv.setAdapter(adapter);
                rv.setLayoutManager(new LinearLayoutManager(getActivity()));
            }
        });


        ArrayList<HomePageItemsModel> postList = new ArrayList<>() ;
        postList.add(new HomePageItemsModel(R.drawable.bike1,R.drawable.profile1,"roshan_photography___"));
        postList.add(new HomePageItemsModel(R.drawable.bike1,R.drawable.profile1,"roshan_photography___"));
        postList.add(new HomePageItemsModel(R.drawable.bike1,R.drawable.profile1,"roshan_photography___"));
        postList.add(new HomePageItemsModel(R.drawable.bike1,R.drawable.profile1,"roshan_photography___"));
        postList.add(new HomePageItemsModel(R.drawable.bike1,R.drawable.profile1,"roshan_photography___"));
        postList.add(new HomePageItemsModel(R.drawable.bike1,R.drawable.profile1,"roshan_photography___"));
        postList.add(new HomePageItemsModel(R.drawable.bike1,R.drawable.profile1,"roshan_photography___"));
        postList.add(new HomePageItemsModel(R.drawable.bike1,R.drawable.profile1,"roshan_photography___"));



    }
}