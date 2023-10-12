package com.example.apiloginproject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {

    @POST("MobileLogin")
    Call<ResponseModel> authenticate(@Body LoginRequest loginRequest);

    @POST("MobileLogin")
    Call<LoginResponse> login(@Body UserRequset requestBody);


    @POST("getHouseInspectionDetailsList")
    Call<List<ATNewModel>> getDataList(@Header("Authorization") String bearerToken, @Body RequestBody requestBody);


        @POST("getHouseInspectionDetailsList")
        Call<List<ATResponse>> getHouseInspectionDetailsList(@Header("Authorization") String token, @Body RequestBody requestBody);





}



