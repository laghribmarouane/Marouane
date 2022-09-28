package com.example.authentificationapp.adapters;

import android.content.ClipData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.authentificationapp.R;
import com.example.authentificationapp.model.Item;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private ArrayList<Item> items = new ArrayList<>();

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
        holder.title.setText(items.get(position).getTitle());
        holder.description.setText(items.get(position).getDescription());
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "item "+items.get(position).getTitle()+"clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @NonNull


    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }

}
