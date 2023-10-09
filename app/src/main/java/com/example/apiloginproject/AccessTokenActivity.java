package com.example.apiloginproject;



import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AccessTokenActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_token);



        listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        // Initialize Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://yjchousing.apcfss.in/yjcapi/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create an instance of the ApiService interface
        apiService = retrofit.create(ApiService.class);

        // Call the API and fetch data
        fetchDataFromApi();
    }

    private void fetchDataFromApi() {


       // GlobalDeclarations.token=ATResponce.getAccessToken();

        Log.d("Deepi", "onResponse: "+GlobalDeclarations.token);
        TextView accessTokenTextView = findViewById(R.id.TvStatus);
        accessTokenTextView.setText(GlobalDeclarations.token);




        DataRequest dataRequest = new DataRequest("Layout", "5", "2", "05210LA002472", "0");
        // Make the API call
        Call<List<DataResponse>> call = apiService.getDataList(GlobalDeclarations.token, dataRequest);
        call.enqueue(new Callback<List<DataResponse>>() {
            @Override
            public void onResponse(Call<List<DataResponse>> call, Response<List<DataResponse>> response) {

                if (response.isSuccessful()) {
                    List<DataResponse> dataResponses = response.body();
                    if (dataResponses != null) {
                        for (DataResponse dataResponse : dataResponses) {
                            Log.d("Deep", "Item: " + dataResponse.toString());
                        }
                    } else {
                        Log.d("Deep", "Response body is null");
                    }

                    if (dataResponses != null) {
                        for (DataResponse dataResponse : dataResponses) {

                            // Display the desired fields in the list
                            String displayText = "san_scheme: " + dataResponse.getSanScheme() +
                                    ", ben_id: " + dataResponse.getBenId() +
                                    ", m_uid: " + dataResponse.getmUid() +
                                    ", dist_name: " + dataResponse.getDistName() +
                                    ", mandal_name: " + dataResponse.getMandalName() +
                                    ", caste_name: " + dataResponse.getCasteName() +
                                    ", phase_status: " + dataResponse.getPhaseStatus() +
                                    ", ben_name: " + dataResponse.getBenName() +
                                    ", mandal_code: " + dataResponse.getMandalCode();
                            adapter.add(displayText);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<DataResponse>> call, Throwable t) {
                Toast.makeText(AccessTokenActivity.this, "API Response Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
