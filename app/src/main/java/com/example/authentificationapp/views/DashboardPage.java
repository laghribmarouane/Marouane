package com.example.authentificationapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.opengl.Visibility;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.authentificationapp.R;
import com.example.authentificationapp.adapters.ItemAdapter;
import com.example.authentificationapp.model.AuthentificationModel;
import com.example.authentificationapp.model.Category;
import com.example.authentificationapp.model.Item;
import com.example.authentificationapp.model.ItemsList;
import com.example.authentificationapp.model.Root;
import com.example.authentificationapp.network.APIClient;
import com.example.authentificationapp.network.APIInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardPage extends AppCompatActivity {

    private static final String TAG = "Loading Items";
    public APIInterface apiInterface;

    ArrayList<Category> items = new ArrayList<>();
    RecyclerView rv;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        setContentView(R.layout.activity_dashboard_page);
        this.rv = findViewById(R.id.recyclerview);
        adapter = new ItemAdapter();
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter.setItems(items);
        rv.setAdapter(adapter);
        getApiItems();


    }

    public void getApiItems() {
        Call<Root> call = apiInterface.getItems();
        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (response.isSuccessful()) {
                    items = response.body().categories;
                    adapter.setItems(items);
                }

            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
    }


}