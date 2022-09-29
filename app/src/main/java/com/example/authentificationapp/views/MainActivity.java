package com.example.authentificationapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.authentificationapp.R;
import com.example.authentificationapp.callback.AuthCallBack;
import com.example.authentificationapp.model.AuthentificationModel;
import com.example.authentificationapp.model.ItemsList;
import com.example.authentificationapp.network.APIClient;
import com.example.authentificationapp.network.APIInterface;
import com.example.authentificationapp.network.Constants;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{
    EditText Username, Password;
    Button Connexion;
    public APIInterface apiInterface;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        setContentView(R.layout.activity_main);
        Username = findViewById(R.id.User);
        Password = findViewById(R.id.Password);
        Connexion = findViewById(R.id.Conx);
        Connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Username.getText().toString().isEmpty() || Password.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Veuillez Remplir les champs", Toast.LENGTH_SHORT).show();
                }else {
                    sendLoginRequest();
                }

            }
        });
    }





    public void sendLoginRequest(){
        Call<AuthentificationModel> call = apiInterface.sendAuthRequest();
        call.enqueue(new Callback<AuthentificationModel>() {
            @Override
            public void onResponse(Call<AuthentificationModel> call, Response<AuthentificationModel> response) {
                if (response.isSuccessful()) {
                    Constants.TOKEN = response.body().getToken();
                    Intent intent = new Intent(MainActivity.this,DashboardPage.class);
                    startActivity(intent);
                }
            }
            @Override
            public void onFailure(Call<AuthentificationModel> call, Throwable t) {
                Log.d("TAG", "onFailure: ");
            }
        });
    }
}