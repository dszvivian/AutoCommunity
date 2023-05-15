package com.example.autocommunity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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

        Call<Results> getData = RetrofitClient.getInstance().getMyApi().getData();
        getData.enqueue(new Callback<Results>() {
                            @Override
                            public void onResponse(Call<Results> call, Response<Results> response) {
                                Results data = response.body();
                                System.out.println(data);
                                tvData.setText(data.getName());
                            }
                            @Override
                            public void onFailure(Call<Results> call, Throwable t) {
                                Log.d("Error","Error");
                                tvData.setText("ERROR"+t);
                            }
                        }
        );
    }
}