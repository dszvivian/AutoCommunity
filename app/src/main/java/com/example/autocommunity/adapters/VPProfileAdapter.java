package com.example.autocommunity.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.autocommunity.pages.profiletabs.VPProfileAssets;
import com.example.autocommunity.pages.profiletabs.VPProfileEvents;
import com.example.autocommunity.pages.profiletabs.VPProfilePosts;

public class VPProfileAdapter extends FragmentStateAdapter {

    private final int TABS = 3;

    public VPProfileAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }


    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: new VPProfileAssets();
            case 1: new VPProfilePosts();
            case 2: new VPProfileEvents();
        }

        return new VPProfileAssets();
    }

    @Override
    public int getItemCount() {
        return TABS;
    }
}
