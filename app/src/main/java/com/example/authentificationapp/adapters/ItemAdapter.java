package com.example.authentificationapp.adapters;

import android.content.ClipData;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.authentificationapp.R;
import com.example.authentificationapp.model.Category;
import com.example.authentificationapp.model.Item;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private ArrayList<Category> items = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_view, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(items.get(position).icon_url).into(holder.imageView);
        holder.title.setText(items.get(position).name);
        holder.description.setText(items.get(position).slug);

    }

    @NonNull
    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<Category> items) {
        this.items = items;
        notifyDataSetChanged();
    }



}
