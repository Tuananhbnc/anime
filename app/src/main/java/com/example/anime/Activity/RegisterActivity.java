package com.example.anime.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.anime.Model.Register;
import com.example.anime.Model.Token;
import com.example.anime.R;
import com.example.anime.Service.APIService;
import com.example.anime.Service.Dataservice;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText etUsername, etPassword, etEmail, etFirstname, etLastname;
    Button btRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        anhxa();

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkRegister();
            }
        });
    }

    private void anhxa() {
        etUsername = (EditText) findViewById(R.id.et_reg_username);
        etEmail = (EditText) findViewById(R.id.et_reg_email);
        etPassword = (EditText) findViewById(R.id.et_reg_password);
        btRegister = (Button) findViewById(R.id.btn_register);
    }

    private void checkRegister(){

        String userName = etUsername.getText().toString().trim();
        String passWord = etPassword.getText().toString().trim();
        String email = etEmail.getText().toString().trim();

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]";

        if (userName.isEmpty() || userName.length() < 5 || userName.equals("") || userName == null) {
            Toast.makeText(this, "Username không đúng :(", Toast.LENGTH_SHORT).show();
        }else if (passWord.isEmpty() || passWord.length() < 5 || passWord.equals("") || passWord == null) {
            Toast.makeText(this, "Password không đúng :(", Toast.LENGTH_SHORT).show();
        }else if (email.isEmpty() || email.length() < 10 || email.equals("") || email == null || email.matches(emailPattern)) {
            Toast.makeText(this, "Email không đúng :(", Toast.LENGTH_SHORT).show();
        }else {
            //Action
            Register register = new Register(email, userName, passWord);
            Dataservice dataservice = APIService.getService();
            Call<ResponseBody> call = dataservice.register(register);

            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(RegisterActivity.this, "OK, chờ Trọng sử lý :))", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(RegisterActivity.this, "TK đã tồn tại :(", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(RegisterActivity.this, "Error :(", Toast.LENGTH_SHORT).show();
                }
            });

        }

    }

    //
}
