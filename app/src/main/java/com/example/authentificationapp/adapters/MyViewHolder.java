package com.example.authentificationapp.adapters;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.authentificationapp.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView title;
    public TextView description;
    public LinearLayout container;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        this.container = (LinearLayout) itemView.findViewById(R.id.container);
        this.imageView = (ImageView) itemView.findViewById(R.id.image);
        this.title = (TextView) itemView.findViewById(R.id.title);
        this.description = (TextView) itemView.findViewById(R.id.description);
    }
}
