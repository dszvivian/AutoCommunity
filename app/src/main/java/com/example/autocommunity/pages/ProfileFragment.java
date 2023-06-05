package com.example.autocommunity.pages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autocommunity.R;
import com.example.autocommunity.adapters.ProfileAssetsAdapter;
import com.example.autocommunity.pages.model.HomePageItemsModel;
import com.example.autocommunity.pages.model.UserAssetsItemModel;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    RecyclerView rv;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv = view.findViewById(R.id.rv_userAssetslist);

        ArrayList<UserAssetsItemModel> assetsList = new ArrayList<>() ;
        assetsList.add(new UserAssetsItemModel(R.drawable.kawasaki_ninja_h2_10,"Kawasaki Ninja"));
        assetsList.add(new UserAssetsItemModel(R.drawable.kawasaki_ninja_h2_10,"Kawasaki Ninja"));
        assetsList.add(new UserAssetsItemModel(R.drawable.kawasaki_ninja_h2_10,"Kawasaki Ninja"));
        assetsList.add(new UserAssetsItemModel(R.drawable.kawasaki_ninja_h2_10,"Kawasaki Ninja"));
        assetsList.add(new UserAssetsItemModel(R.drawable.kawasaki_ninja_h2_10,"Kawasaki Ninja"));
        assetsList.add(new UserAssetsItemModel(R.drawable.kawasaki_ninja_h2_10,"Kawasaki Ninja"));
        assetsList.add(new UserAssetsItemModel(R.drawable.kawasaki_ninja_h2_10,"Kawasaki Ninja"));
        assetsList.add(new UserAssetsItemModel(R.drawable.kawasaki_ninja_h2_10,"Kawasaki Ninja"));
        assetsList.add(new UserAssetsItemModel(R.drawable.kawasaki_ninja_h2_10,"Kawasaki Ninja"));
        assetsList.add(new UserAssetsItemModel(R.drawable.kawasaki_ninja_h2_10,"Kawasaki Ninja"));
        assetsList.add(new UserAssetsItemModel(R.drawable.kawasaki_ninja_h2_10,"Kawasaki Ninja"));


        ProfileAssetsAdapter adapter = new ProfileAssetsAdapter(assetsList);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

    }
}
