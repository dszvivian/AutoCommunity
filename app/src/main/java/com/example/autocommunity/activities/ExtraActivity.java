package com.example.autocommunity.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.autocommunity.R;
import com.example.autocommunity.pages.EventConfirmFragment;
import com.example.autocommunity.pages.ProfileFragment;
import com.example.autocommunity.pages.forms.ANPFromFragment;
import com.example.autocommunity.pages.forms.ANVFormFragment;
import com.example.autocommunity.pages.forms.UserDetailsFormFragment;

public class ExtraActivity extends AppCompatActivity {

    FragmentContainerView fc_extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);

        Bundle bd=getIntent().getExtras();

        UserDetailsFormFragment udf = new UserDetailsFormFragment();
        ANVFormFragment anvf = new ANVFormFragment();
        ANPFromFragment anpf =new ANPFromFragment();
        EventConfirmFragment ecf = new EventConfirmFragment();

        String fname = bd.getString("fname");

        if(fname.equals("UDF")){

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fc_extra, udf)
                    .commit();

            Toast.makeText(this,fname,Toast.LENGTH_SHORT).show();
        }else if(fname.equals("ANVF")){

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fc_extra, anvf)
                    .commit();

            Toast.makeText(this,fname,Toast.LENGTH_SHORT).show();
        } else if (fname.equals("ANPF")) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fc_extra, anpf)
                    .commit();

            Toast.makeText(this,fname,Toast.LENGTH_SHORT).show();
        } else if(fname.equals("ECPF")){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fc_extra, ecf)
                    .commit();
        }


    }
}