package com.example.autocommunity.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.autocommunity.ApiViewModel;
import com.example.autocommunity.R;
import com.example.autocommunity.model.Results;
import com.example.autocommunity.pages.DiscussionFragment;
import com.example.autocommunity.pages.EventsFragment;
import com.example.autocommunity.pages.HomeFragment;
import com.example.autocommunity.pages.ProfileFragment;
import com.example.autocommunity.pages.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    Retrofit retrofit = null;
    BottomNavigationView bnv;

    HomeFragment homeFragment;
    SearchFragment searchFragment;
    DiscussionFragment discussionFragment;
    ProfileFragment profileFragment;
    EventsFragment eventsFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv = findViewById(R.id.bnvMain);
        homeFragment = new HomeFragment();
        searchFragment = new SearchFragment();
        discussionFragment = new DiscussionFragment();
        profileFragment = new ProfileFragment();
        eventsFragment = new EventsFragment();

        connect();

        NavController nc = Navigation.findNavController(this,R.id.fragmentContainerView);
        NavigationUI.setupWithNavController(bnv,nc);



    }

//    private void setBnv(Activity activity) {
//        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch(item.getItemId()){
//                    case R.id.homeFragment:
//                        Navigation.findNavController(activity, R.id.fragmentContainerView)
//                                .navigate(R.id.action_homeFragment_self);
//                        return true;
//                    case R.id.searchFragment:
//                        Navigation.findNavController(activity, R.id.fragmentContainerView)
//                                .navigate(R.id.action_homeFragment_to_searchFragment);
//                        return true;
//                    case R.id.discussionFragment:
//                        Navigation.findNavController(activity, R.id.fragmentContainerView)
//                                .navigate(R.id.action_homeFragment_to_discussionFragment);
//                        return true;
//                    case R.id.eventsFragment:
//                        Navigation.findNavController(activity, R.id.fragmentContainerView)
//                                .navigate(R.id.action_homeFragment_to_eventsFragment);
//                        return true;
//                    case R.id.profileFragment:
//                        Navigation.findNavController(activity, R.id.fragmentContainerView)
//                                .navigate(R.id.action_homeFragment_to_profileFragment2);
//                        return true;
//                }
//
//                return false;
//            }
//        });
//    }

    private void connect() {

        ApiViewModel vm = new ApiViewModel();
        vm.getData().observe(this, new Observer<Results>() {
            @Override
            public void onChanged(Results results) {
                // todo: set the textView here
                /*tvData.setText(results.getName());*/
            }
        });

    }




}