package com.example.authentificationapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.authentificationapp.R;
import com.example.authentificationapp.adapters.ItemAdapter;
import com.example.authentificationapp.model.Item;
import com.example.authentificationapp.model.ItemsList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashboardPage extends AppCompatActivity {

    private static final String TAG = "Loading Items";
    ArrayList<Item> items;
    RecyclerView rv;
    ItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_page);
        this.rv = findViewById(R.id.recyclerview);
        adapter = new ItemAdapter();
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter.setItems(items);
        rv.setAdapter(adapter);
    }


    @Override
    protected void onResume() {
        super.onResume();
        fetchData();
        adapter.setItems(items);
    }


    private void fetchData(){
        InputStream XmlFileInputStream = getResources().openRawResource(R.raw.data);
        String jsonString = readTextFile(XmlFileInputStream);
        Gson gson = new Gson();
        ItemsList itemsList =  gson.fromJson(jsonString, ItemsList.class);
        items = itemsList.getItemsList();

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
}