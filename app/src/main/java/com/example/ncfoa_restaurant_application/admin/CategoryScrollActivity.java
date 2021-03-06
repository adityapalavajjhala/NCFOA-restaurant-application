package com.example.ncfoa_restaurant_application.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.ncfoa_restaurant_application.R;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class CategoryScrollActivity extends  AppCompatActivity{
    RecyclerView recview1;
    categoryadapter adapter1;
    FloatingActionButton fb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        recview1=(RecyclerView)findViewById(R.id.recview1);
        recview1.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<category> options1 = new FirebaseRecyclerOptions.Builder<category>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Category"), category.class)
                .build();

        adapter1=new categoryadapter(options1);
        recview1.setAdapter(adapter1);

        fb1= findViewById(R.id.fadd1);
        fb1.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),categoryadddata.class)));

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter1.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter1.stopListening();
    }

}
