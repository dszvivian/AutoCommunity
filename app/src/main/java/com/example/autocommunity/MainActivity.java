package com.example.autocommunity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;


import android.os.Bundle;

import android.widget.TextView;

import com.example.autocommunity.api.ApiService;
import com.example.autocommunity.api.RetrofitClient;
import com.example.autocommunity.model.Results;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Retrofit retrofit = null;

    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvData = findViewById(R.id.tvData);

        connect();

    }

    private void connect() {

        ApiViewModel vm = new ApiViewModel();
        vm.getData().observe(this, new Observer<Results>() {
            @Override
            public void onChanged(Results results) {
                tvData.setText(results.getName());
            }
        });

    }




}