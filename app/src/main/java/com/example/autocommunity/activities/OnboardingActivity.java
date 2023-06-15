package com.example.autocommunity.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.autocommunity.R;
import com.example.autocommunity.adapters.VOBAdapter;
import com.example.autocommunity.pages.OnboardingPages.vpobPage1;
import com.example.autocommunity.pages.OnboardingPages.vpobPage2;
import com.example.autocommunity.pages.OnboardingPages.vpobPage3;

import java.util.ArrayList;

public class OnboardingActivity extends AppCompatActivity {

    ViewPager2 vpob;
    Button btnGetStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);


        vpob = findViewById(R.id.vp_onboarding);
        btnGetStarted = findViewById(R.id.btn_vpobGetStarted);

        ArrayList<Fragment> vpObScreens = new ArrayList<Fragment>();
        vpObScreens.add(new vpobPage1());
        vpObScreens.add(new vpobPage2());
        vpObScreens.add(new vpobPage3());

        VOBAdapter vobAdapter = new VOBAdapter(vpObScreens,this.getSupportFragmentManager(),getLifecycle());
        vpob.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        vpob.setAdapter(vobAdapter);



        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),AuthActivity.class));
                finish();

                // TODO: 15-06-2023 Write logic: If user has previously logged in(stored using shared preferences), then Direct user directly to HomeScreen

            }
        });




    }
}