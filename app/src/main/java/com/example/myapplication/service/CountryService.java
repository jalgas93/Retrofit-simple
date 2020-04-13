package com.example.myapplication.service;

import com.example.myapplication.model.CountryInfo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountryService {
    @GET("country/get/all")
    Call<CountryInfo> getResult();
}
