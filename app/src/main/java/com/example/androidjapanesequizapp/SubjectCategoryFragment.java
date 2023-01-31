package com.example.androidjapanesequizapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.androidjapanesequizapp.Interface.ItemClickListener;
import com.example.androidjapanesequizapp.Model.SubjectCategory;
import com.example.androidjapanesequizapp.ViewHolder.SubjectCategoryViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;


public class SubjectCategoryFragment extends Fragment {
    View myFragment;
    RecyclerView listCategory;
    RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<SubjectCategory, SubjectCategoryViewHolder> adapter;

    FirebaseDatabase database;
    DatabaseReference categories;

    public static SubjectCategoryFragment newInstance() {
        SubjectCategoryFragment subjectCategoryFragment = new SubjectCategoryFragment();
        return subjectCategoryFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = FirebaseDatabase.getInstance();
        categories = database.getReference("SubjectCategory");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_subject_category, container, false);

        listCategory = myFragment.findViewById(R.id.listCategory);
        listCategory.setHasFixedSize(true); //optimization
        layoutManager = new LinearLayoutManager(container.getContext());
        listCategory.setLayoutManager(layoutManager);

        loadCategories();

        return myFragment;
    }

    private void loadCategories() {
        adapter = new FirebaseRecyclerAdapter<SubjectCategory, SubjectCategoryViewHolder>(SubjectCategory.class, R.layout.subject_category_layout, SubjectCategoryViewHolder.class, categories) {
            @Override
            protected void populateViewHolder(SubjectCategoryViewHolder subjectCategoryViewHolder, SubjectCategory model, int i) {
                subjectCategoryViewHolder.category_name.setText(model.getName());
                Picasso.with(getActivity()).load(model.getImage()).into(subjectCategoryViewHolder.category_image);
                subjectCategoryViewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Toast.makeText(getActivity(), String.format("%s|%s", adapter.getRef(position).getKey(), model.getName()), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        adapter.notifyDataSetChanged();
        listCategory.setAdapter(adapter);
    }
}