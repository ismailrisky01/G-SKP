package com.example.g_skp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.g_skp.models.LoginModel;
import com.example.g_skp.R;
import com.example.g_skp.ServicePackage.Services;
import com.example.g_skp.UtilPackage.Api;
import com.example.g_skp.UtilPackage.SharedPref;
import java.util.HashMap;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    ProgressDialog loading;
    ProgressDialog progressDialog;
    Button btnLogin;
    EditText edtUsername, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUsername = (EditText) findViewById(R.id.username);
        edtPassword = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.login_button);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ceckLogin();
                Intent i = new Intent(getApplicationContext(),DashBoardActivity.class);
                startActivity(i);

            }
        });
    }

    public void ceckLogin() {
        final String username = edtUsername.getText().toString();
        final String password = edtPassword.getText().toString();
        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setMessage("Loading..."); // Setting Message
        progressDialog.setTitle("ProgressDialog"); // Setting Title
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
        progressDialog.show(); // Display Progress Dialog
        progressDialog.setCancelable(false);
        Login(username, password);

    }

    public void Login(final String username, final String password) {

        final Map<String, String> requestBody = new HashMap<>();
        requestBody.put("username", username);
        requestBody.put("password", password);
        Services service = Api.getApiService();
        Call<LoginModel> call = service.Login(requestBody);
        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if (response.body() != null) {
                    try {
                        if (response.body().getStatus().equals("200")) {
                        LoginModel us = null;
                        us = response.body();
                        SharedPref.saveUserData(getBaseContext(), us);
                        Intent i = new Intent(getApplicationContext(), DashBoardActivity.class);
                            startActivity(i);
                        } else {
                            FailedLogin(response.body().getMessage());
                        }
                    } catch (Exception ex) {
                        FailedLogin(ex.toString());
                        Toast.makeText(LoginActivity.this, "Error at server response, please try again later.", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(LoginActivity.this, "Failed to Login", Toast.LENGTH_SHORT).show();

            }
        });
        }


    public void ActionLogin() {

    }

    private void FailedLogin(String msg) {
        progressDialog.dismiss();
        if (msg.isEmpty()) {
            Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
        }
        btnLogin.setEnabled(true);
    }
}
