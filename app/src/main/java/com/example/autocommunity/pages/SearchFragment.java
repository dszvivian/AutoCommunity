package com.example.autocommunity.pages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autocommunity.ApiViewModel;
import com.example.autocommunity.R;
import com.example.autocommunity.adapters.SearchItemsAdapter;
import com.example.autocommunity.model.SearchPageItemModel;
import com.example.autocommunity.model.User;
import com.example.autocommunity.model.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    RecyclerView rv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv = view.findViewById(R.id.rvSearch);


        ApiViewModel vm=new ApiViewModel();

        vm.getAllUsers().observe(requireActivity(), new Observer<List<UserDetails>>() {
            @Override
            public void onChanged(List<UserDetails> userDetails) {
                SearchItemsAdapter adapter = new SearchItemsAdapter(requireActivity(),userDetails);
                rv.setAdapter(adapter);
                rv.setLayoutManager(new LinearLayoutManager(getActivity()));
            }
        });




//        ArrayList<SearchPageItemModel> list = new ArrayList<SearchPageItemModel>();
//        list.add(new SearchPageItemModel(R.drawable.profile1,"roshan_photography___","Roshan Girish | Photography|Photographer Based in India","Manglore,India"));
//        list.add(new SearchPageItemModel(R.drawable.profile1,"roshan_photography___","Roshan Girish | Photography|Photographer Based in India","Manglore,India"));
//        list.add(new SearchPageItemModel(R.drawable.profile1,"roshan_photography___","Roshan Girish | Photography|Photographer Based in India","Manglore,India"));
//        list.add(new SearchPageItemModel(R.drawable.profile1,"roshan_photography___","Roshan Girish | Photography|Photographer Based in India","Manglore,India"));
//        list.add(new SearchPageItemModel(R.drawable.profile1,"roshan_photography___","Roshan Girish | Photography|Photographer Based in India","Manglore,India"));
//        list.add(new SearchPageItemModel(R.drawable.profile1,"roshan_photography___","Roshan Girish | Photography|Photographer Based in India","Manglore,India"));
//        list.add(new SearchPageItemModel(R.drawable.profile1,"roshan_photography___","Roshan Girish | Photography|Photographer Based in India","Manglore,India"));
//        list.add(new SearchPageItemModel(R.drawable.profile1,"roshan_photography___","Roshan Girish | Photography|Photographer Based in India","Manglore,India"));






    }
}
