package com.example.anime.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anime.Model.Login;
import com.example.anime.Model.Token;
import com.example.anime.R;
import com.example.anime.Service.APIService;
import com.example.anime.Service.Dataservice;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    TextView tvRegister;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhxa();

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent R = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(R);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

    }

    private void anhxa() {
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        tvRegister = (TextView) findViewById(R.id.tv_register);
    }

    private void loginUser() {

        String userName = etUsername.getText().toString().trim();
        String passWord = etPassword.getText().toString().trim();

        if (userName.isEmpty() || userName.length() == 0 || userName.equals("") || userName == null) {
            Toast.makeText(this, "Chưa nhập Username :(", Toast.LENGTH_SHORT).show();
        } else if (passWord.isEmpty() || passWord.length() == 0 || passWord.equals("") || passWord == null) {
            Toast.makeText(this, "Chưa nhập Password :(", Toast.LENGTH_SHORT).show();
        }else {
            //Action
            Login login = new Login(userName, passWord);
            Dataservice dataservice = APIService.getService();
            Call<Token> call = dataservice.login(login);

            call.enqueue(new Callback<Token>() {
                @Override
                public void onResponse(Call<Token> call, Response<Token> response) {
                    if (response.isSuccessful()) {
                        //Token token_user = response.body();

                        Intent i = new Intent(LoginActivity.this, MainActivity.class);
                        i.putExtra("token",response.body());
                        startActivity(i);
                        finish();

                    } else {
                        Toast.makeText(LoginActivity.this, "Sai TK hoặc MK :(", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Token> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Error :(", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    //
}
