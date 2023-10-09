package com.example.apiloginproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MainActivity extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText;
    private Button loginButton;
    private SharedPreferences sharedPreferences;

    // Initialize Retrofit


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        usernameEditText = findViewById(R.id.username_et);
        passwordEditText = findViewById(R.id.password_et);
        loginButton = findViewById(R.id.login_button);

        usernameEditText.setText("0679718");
        passwordEditText.setText("Apshcl@2022");


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://yjchousing.apcfss.in/yjcapi/YJCAPI/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create an instance of the ApiService
        ApiService apiService = retrofit.create(ApiService.class);
        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                    // Create the request
                UserRequset userRequest = new UserRequset("0679718","Apshcl@2022");
                userRequest.setUsername("0679718");
                userRequest.setPassword("Apshcl@2022");

                // API call
                Call<LoginResponse> call = apiService.login(userRequest);

                    call.enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            int statusCode = response.code();

                            if (isValidCredentials(username, password)){
                            if (statusCode == 200 || statusCode == 201) {
                                // Login successful, save data to SharedPreferences
                                LoginResponse loginResponse = response.body();
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("accessToken", loginResponse.getAccessToken());
                                editor.putString("username", loginResponse.getUsername());

                                GlobalDeclarations.token=loginResponse.getAccessToken();
                              //  Log.d("Deepi", "onResponse: "+GlobalDeclarations.token);



                                editor.apply();
                                startActivity(new Intent(MainActivity.this, DisplayDataActivity.class));
                            }
                                // Navigate to the next activity or perform other actions
                            } else if (statusCode == 400 || statusCode == 401) {
                                // Login failed, show error message
                                Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                            } else {
                                // Handle other status codes here, if needed
                                // For example, you can show a generic error message
                                Toast.makeText(MainActivity.this, "Enter Valid Credentials ", Toast.LENGTH_SHORT).show();
                            }
                            Log.d("Deepi", "Status Code is : " + statusCode);
                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {
                            // Handle network errors here
                            Toast.makeText(MainActivity.this, "Network error", Toast.LENGTH_SHORT).show();
                        }
                    });


            }
        });
    }
    private boolean isValidCredentials(String username, String password) {
        return username.equals("0679718") && password.equals("Apshcl@2022");
   }
}





//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        apiService = ApiClient.getApiClient().create(ApiService.class);
//        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
//
//        usernameEditText = findViewById(R.id.username_et);
//        passwordEditText = findViewById(R.id.password_et);
//        loginButton = findViewById(R.id.login_button);
//        usernameEditText.setText("0679718");
//        passwordEditText.setText("Apshcl@2022");
//        loginButton.setOnClickListener(v -> {
//            String username = usernameEditText.getText().toString().trim();
//            String password = passwordEditText.getText().toString().trim();
//
//
//            LoginRequest userRequest = new LoginRequest("0679718","Apshcl@2022");
//            userRequest.setUsername("0679718");
//            userRequest.setPassword("Apshcl@2022");
//
//            // Make the API call
//            Call<LoginResponse> call = apiService.loginUser(userRequest);
//            call.enqueue(new Callback<LoginResponse>() {
//                @Override
//                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                    int statusCode = response.code();
//                    if (isValidCredentials(username, password)){
//
//                        Log.d("Deepi", "Status Code is : " + statusCode);
//
//                    if (statusCode == 200 || statusCode == 201) {
//                        // Login successful, save data to SharedPreferences
//                        LoginResponse loginResponse = response.body();
//                        SharedPreferences.Editor editor = sharedPreferences.edit();
//                        editor.putString("accessToken", loginResponse.getAccessToken());
//                        editor.putString("username", loginResponse.getUsername());
//                        // Add more fields as needed
//                        editor.apply();
//                        startActivity(new Intent(MainActivity.this, DisplayDataActivity.class));
//                        // Navigate to the next activity or perform other actions
//                    }
//
//                    }
//
//                    else if (statusCode == 400 || statusCode == 401) {
//                        // Login failed, show error message
//                        Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
//                    }
//                    else {
//                        Toast.makeText(MainActivity.this, "Wrong Credits", Toast.LENGTH_SHORT).show();
//                    }
//                    Log.d("Deepi", "Status Code is : " + statusCode);
//
//                }
//
//                @Override
//                public void onFailure(Call<LoginResponse> call, Throwable t) {
//                    // Handle network errors here
//                    Toast.makeText(MainActivity.this, "Network error", Toast.LENGTH_SHORT).show();
//                }
//            });
//
//        });
//    }
//    private boolean isValidCredentials(String username, String password) {
//        return username.equals("0679718") && password.equals("Apshcl@2022");
//    }

