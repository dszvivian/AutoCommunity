package com.example.autocommunity.pages.profiletabs;

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
import com.example.autocommunity.model.UserAssetsItemModel;

import java.util.ArrayList;

public class VPProfileAssets extends Fragment {

    RecyclerView rv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profile_assetsfragment,container,false);
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
