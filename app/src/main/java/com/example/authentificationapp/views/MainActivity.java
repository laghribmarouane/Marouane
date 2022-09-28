package com.example.authentificationapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.authentificationapp.R;
import com.example.authentificationapp.callback.AuthCallBack;
import com.example.authentificationapp.model.AuthentificationModel;
import com.example.authentificationapp.model.ItemsList;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements AuthCallBack {
    EditText Username, Password;
    Button Connexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                    sendloginrequest(MainActivity.this);
                }

            }
        });
    }

    public void sendloginrequest(AuthCallBack callBack) {
        InputStream XmlFileInputStream = getResources().openRawResource(R.raw.auth);
        String jsonString = readTextFile(XmlFileInputStream);
        Gson gson = new Gson();
        AuthentificationModel response = gson.fromJson(jsonString, AuthentificationModel.class);
        if(response!=null){
            callBack.onResult(response);
        }else {
            Toast.makeText(this,"Eroor",Toast.LENGTH_SHORT).show();
        }

    }

    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }

    @Override
    public void onResult(AuthentificationModel response) {
        if (response.isAuthSuccess()) {
            Intent intent = new Intent(this, DashboardPage.class);
            startActivity(intent);
        }
    }
}