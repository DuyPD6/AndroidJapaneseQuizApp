package com.example.androidjapanesequizapp.Interface;

import android.view.View;

//implement onClick at Recycler Item
public interface ItemClickListener {
    void onClick(View view, int position, boolean isLongClick);
}
