package com.example.autocommunity.pages;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.arch.core.executor.TaskExecutor;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.autocommunity.ApiViewModel;
import com.example.autocommunity.Preferences;
import com.example.autocommunity.activities.ExtraActivity;
import com.example.autocommunity.R;
import com.example.autocommunity.activities.OnboardingActivity;
import com.example.autocommunity.adapters.ProfileAssetsAdapter;
import com.example.autocommunity.adapters.VPProfileAdapter;
import com.example.autocommunity.model.ProfileDetails;
import com.example.autocommunity.model.UserAssetsItemModel;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {

    RecyclerView rv;
    Button btnEditProfile;
    ViewPager2 vpProfile;
    TabLayout tb_profile;

    CircleImageView pPic;
    TextView pName,pDesc;
    MaterialToolbar tb;
    Preferences pf;
    AppCompatButton btnLogout;

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
        pPic = view.findViewById(R.id.iv_PFpPicture);
        pName = view.findViewById(R.id.tv_PFpName);
        pDesc = view.findViewById(R.id.tv_PFpDesc);
        tb = view.findViewById(R.id.tb_PF);
        btnLogout = view.findViewById(R.id.btnPFlogout);

        pf = new Preferences();

        String username = pf.isLoggedIn(requireActivity());

        // setting the Profile Details
        ApiViewModel vm = new ApiViewModel();

        Intent iExtraActivity =  new Intent(requireActivity(), ExtraActivity.class);
        Bundle bd = new Bundle();

        tb.setTitle(username);

        vm.getProfileDetails(username).observe(requireActivity(), new Observer<List<ProfileDetails>>() {
            @Override
            public void onChanged(List<ProfileDetails> pd) {
                Glide
                    .with(requireActivity())
                    .load(pd.get(0).getpPicture())
                    .centerCrop()
                    .into(pPic);

                pName.setText(pd.get(0).getpName());
                pDesc.setText(pd.get(0).getpDescription());
        }
        });




        ArrayList<String> tabsName = new ArrayList<String>();
        tabsName.add("Collections");
        tabsName.add("Posts");
//        tabsName.add("Events");


        VPProfileAdapter vpProfileAdapter = new VPProfileAdapter(getChildFragmentManager(), getViewLifecycleOwner().getLifecycle());
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
                bd.putString("fname","UDF");
                iExtraActivity.putExtras(bd);
                startActivity(iExtraActivity);
            }
        });

        //setting Toolbar

        tb.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {


                switch (item.getItemId()){

                    case R.id.moreProfileCreateAsset:
                        bd.putString("fname","ANVF");
                        iExtraActivity.putExtras(bd);
                        startActivity(iExtraActivity);
                        return true;

                }

                return false;
            }
        });


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pf.clearData(requireActivity());
                startActivity(new Intent(requireActivity(), OnboardingActivity.class));
            }
        });


    }
}
