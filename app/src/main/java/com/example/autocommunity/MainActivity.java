package com.example.autocommunity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.autocommunity.model.Results;
import com.example.autocommunity.pages.DiscussionFragment;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv = findViewById(R.id.bnvMain);
        homeFragment = new HomeFragment();
        searchFragment = new SearchFragment();
        discussionFragment = new DiscussionFragment();
        profileFragment = new ProfileFragment();

        connect();

        setBnv();

    }

    private void setBnv() {
        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.miHome:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragmentContainerView, homeFragment)
                                .commit();
                        return true;
                    case R.id.miSearch:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragmentContainerView, searchFragment)
                                .commit();
                        return true;
                    case R.id.miDiscuss:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragmentContainerView, discussionFragment)
                                .commit();
                        return true;
                    case R.id.miProfile:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragmentContainerView, profileFragment)
                                .commit();
                        return true;
                }

                return false;
            }
        });
    }

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