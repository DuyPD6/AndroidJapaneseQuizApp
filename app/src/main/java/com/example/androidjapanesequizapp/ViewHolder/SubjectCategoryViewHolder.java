package com.example.androidjapanesequizapp.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidjapanesequizapp.Interface.ItemClickListener;
import com.example.androidjapanesequizapp.R;

//process each item at Recycler Adapter
public class SubjectCategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView category_name;
    public ImageView category_image;

    private ItemClickListener itemClickListener;

    public SubjectCategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        category_image = itemView.findViewById(R.id.subject_category_image);
        category_name = itemView.findViewById(R.id.subject_category_name);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view, getPosition(), false); //cần xem lại
    }
}
