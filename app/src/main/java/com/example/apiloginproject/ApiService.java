package com.example.apiloginproject;

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
    Call<List<ApiResponse>> getDataList(@Header("Authorization") String bearerToken, @Body DataRequest dataRequest);
    @Headers("Content-Type: application/json")
    @POST("https://yjchousing.apcfss.in/yjcapi/getHouseInspectionDetailsList")
    Call<List<ApiResponse>> getHouseInspectionDetails(
            @Header("Authorization") String accessToken,
            @Body DataRequest request
    );


}



