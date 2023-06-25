package com.example.autocommunity.pages;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.autocommunity.ApiViewModel;
import com.example.autocommunity.R;
import com.example.autocommunity.activities.ExtraActivity;
import com.example.autocommunity.adapters.HomePageAdapter;
import com.example.autocommunity.model.HomePageItemsModel;
import com.example.autocommunity.model.Post;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;


//todo:fix Layout

public class HomeFragment extends Fragment {

    RecyclerView rv;

    MaterialToolbar tb_home;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        rv = view.findViewById(R.id.rvHome);
        tb_home = view.findViewById(R.id.tb_home);

        Intent iExtraActivity =  new Intent(requireActivity(), ExtraActivity.class);
        Bundle bd = new Bundle();

        ApiViewModel vm =new ApiViewModel();

        vm.getAllPosts().observe(requireActivity(), new Observer<ArrayList<Post>>() {
            @Override
            public void onChanged(ArrayList<Post> posts) {

                Toast.makeText(requireActivity(),"Posts Recieved",Toast.LENGTH_SHORT).show();
                HomePageAdapter adapter = new HomePageAdapter(requireActivity(),posts);
                rv.setAdapter(adapter);
                rv.setLayoutManager(new LinearLayoutManager(getActivity()));
            }
        });

        tb_home.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {


                switch (item.getItemId()){

                    case R.id.homeAddnewpost:
                        bd.putString("fname","ANPF");
                        iExtraActivity.putExtras(bd);
                        startActivity(iExtraActivity);
                        return true;

                }

                return false;
            }
        });




    }



}