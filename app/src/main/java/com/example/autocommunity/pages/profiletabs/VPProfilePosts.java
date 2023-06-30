package com.example.autocommunity.pages.profiletabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autocommunity.ApiViewModel;
import com.example.autocommunity.Preferences;
import com.example.autocommunity.R;
import com.example.autocommunity.adapters.HomePageAdapter;
import com.example.autocommunity.model.Post;

import java.util.ArrayList;

public class VPProfilePosts extends Fragment {

    Preferences pf;

    RecyclerView rvPosts;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profile_postsfragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ApiViewModel vm = new ApiViewModel();
        rvPosts = view.findViewById(R.id.rvProfilePosts);

        pf = new Preferences();

        String username = pf.isLoggedIn(requireActivity());

        vm.getAllPostsByUsername(username).observe(requireActivity(), new Observer<ArrayList<Post>>() {
            @Override
            public void onChanged(ArrayList<Post> posts) {
                Toast.makeText(requireActivity(),"Posts Recieved",Toast.LENGTH_SHORT).show();
                HomePageAdapter adapter = new HomePageAdapter(requireActivity(),posts);
                rvPosts.setAdapter(adapter);
                rvPosts.setLayoutManager(new LinearLayoutManager(getActivity()));
            }
        });



    }
}
