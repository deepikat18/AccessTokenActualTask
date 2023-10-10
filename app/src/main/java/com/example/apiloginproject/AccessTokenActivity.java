package com.example.apiloginproject;



import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AccessTokenActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_token);

        listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        ListView listView = findViewById(R.id.listView);

        // Create Retrofit instance
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://yjchousing.apcfss.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        // Create the API request object
        DataRequest request = new DataRequest("Layout", "5", "2", "05210LA002472", "0");


        // Make the API call
        Call<List<ApiResponse>> call = apiService.getHouseInspectionDetails(GlobalDeclarations.token,request);
      call.enqueue(new Callback<List<ApiResponse>>() {
          @Override
          public void onResponse(Call<List<ApiResponse>> call, Response<List<ApiResponse>> response) {
              if (response.isSuccessful()) {
                    List<ApiResponse> items = response.body();

                    List<ApiResponse> dataList = response.body();

                    AdapterAT adapter = new AdapterAT(AccessTokenActivity.this, dataList);
                    listView.setAdapter(adapter);
                    adapter.clear();

                    // Access "ben_name" from each item and add it to the adapter
                    for (ApiResponse item : items) {
                        adapter.add("Ben Name: " + item.getBenName());
                        Log.d("deepi", "onResponse: "+item.getBenName());
                        adapter.add("District Name : " + item.getDistName());
                    }

                }

          }

          @Override
          public void onFailure(Call<List<ApiResponse>> call, Throwable t) {

          }
      });
//       // call.enqueue(new Callback<List<ApiResponse>>() {
//            @Override
//            public void onResponse(Call<ApiResponse>> call, Response<List<ApiResponse>> response) {
//                if (response.isSuccessful()) {
//                    List<ApiItem> items = response.body();
//
//                    List<ApiItem> dataList = response.body();
//
//                    AdapterAT adapter = new AdapterAT(AccessTokenActivity.this, dataList);
//                    listView.setAdapter(adapter);
//                    adapter.clear();
//
//                    // Access "ben_name" from each item and add it to the adapter
//                    for (ApiItem item : items) {
//                        adapter.add("Ben Name: " + item.getBenName());
//                        Log.d("deepi", "onResponse: "+item.getBenName());
//                        adapter.add("District Name : " + item.getDistName());
//                    }
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<ApiItem>> call, Throwable t) {
//                Toast.makeText(AccessTokenActivity.this, "API Response Failed", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
