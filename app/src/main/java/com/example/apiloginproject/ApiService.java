package com.example.apiloginproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {
    @POST("MobileLogin")
    Call<ResponseModel> authenticate(@Body LoginRequest loginRequest);

    @POST("MobileLogin")
    Call<LoginResponse> login(@Body UserRequset requestBody);


    @POST("getHouseInspectionDetailsList")
    Call<List<DataResponse>> getDataList(@Header("Authorization") String bearerToken, @Body DataRequest dataRequest);
}



