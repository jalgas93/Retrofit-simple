package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.model.CountryInfo;
import com.example.myapplication.model.Result;
import com.example.myapplication.service.CountryService;
import com.example.myapplication.service.RetrofitInctance;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Result> resultArrayList;

    private CountryAdapter adapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCountries();
    }


    private Object getCountries() {

        CountryService countryService = RetrofitInctance.getService();
        Call<CountryInfo> call = countryService.getResult();

        call.enqueue(new Callback<CountryInfo>() {
            @Override
            public void onResponse(Call<CountryInfo> call, Response<CountryInfo> response) {
                CountryInfo countryInfo = response.body();

                if (countryInfo != null && countryInfo.getRestResponse() != null) {

                    resultArrayList = (ArrayList<Result>) countryInfo.getRestResponse().getResult();


                    fillRecyclerView();
                }

            }

            @Override
            public void onFailure(Call<CountryInfo> call, Throwable t) {

            }
        });
        return resultArrayList;

    }

    private void fillRecyclerView() {

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new CountryAdapter(resultArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
