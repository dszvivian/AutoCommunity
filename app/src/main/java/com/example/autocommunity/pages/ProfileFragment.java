package com.example.autocommunity.pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.autocommunity.activities.ExtraActivity;
import com.example.autocommunity.R;
import com.example.autocommunity.adapters.ProfileAssetsAdapter;
import com.example.autocommunity.adapters.VPProfileAdapter;
import com.example.autocommunity.model.UserAssetsItemModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    RecyclerView rv;
    Button btnEditProfile;
    ViewPager2 vpProfile;
    TabLayout tb_profile;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnEditProfile = view.findViewById(R.id.btnProfileEditProfile);
        vpProfile = view.findViewById(R.id.vp_profile);
        tb_profile = view.findViewById(R.id.tab_profile);

        ArrayList<String> tabsName = new ArrayList<String>();
        tabsName.add("Assets");
        tabsName.add("Posts");
        tabsName.add("Events");


        VPProfileAdapter vpProfileAdapter = new VPProfileAdapter(requireActivity().getSupportFragmentManager(), getLifecycle());
        vpProfile.setAdapter(vpProfileAdapter);

        new TabLayoutMediator(tb_profile, vpProfile,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(tabsName.get(position));
                    }
                }
        ).attach();


        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(requireActivity(), ExtraActivity.class));
            }
        });

    }
}
