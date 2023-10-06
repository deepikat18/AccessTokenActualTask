package com.example.apiloginproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.username_et);
        passwordEditText = findViewById(R.id.password_et);
        Button loginButton = findViewById(R.id.login_button);
        usernameEditText.setText("0679718");
        passwordEditText.setText("Apshcl@2022");
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Validate username and password
                if (isValidCredentials(username, password)) {
                    // Make API request
                    startActivity(new Intent(MainActivity.this, DisplayDataActivity.class));
                } else if (username.isEmpty()) {
                    Toast.makeText(MainActivity.this, " Enter Your Username ", Toast.LENGTH_SHORT).show();
                }
                else if (password.isEmpty()) {
                    Toast.makeText(MainActivity.this, " Enter Your Password ", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Please Enter valid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidCredentials(String username, String password) {
        return username.equals("0679718") && password.equals("Apshcl@2022");
    }

    private void makeApiRequest(String username, String password) {
        OkHttpClient client = new OkHttpClient();
        String url = "https://yjchousing.apcfss.in/yjcapi/YJCAPI/MobileLogin";

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("username", username);
            jsonBody.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody requestBody = RequestBody.create(jsonBody.toString(), MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(MainActivity.this, "Api call Failed", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData = response.body().string();
                try {
                    JSONObject jsonObject = new JSONObject(responseData);

                    // Parse the response JSON and handle accordingly
                    String status = jsonObject.getString("status");
                    if (status.equals("S01")) {
                        String accessToken = jsonObject.getString("accessToken");
                        // You can save the access token or perform other actions here
                    } else {
                        String errorMsg = jsonObject.getString("msg");
                        // Handle error message
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
