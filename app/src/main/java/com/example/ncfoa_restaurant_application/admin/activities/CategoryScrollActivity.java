package com.example.ncfoa_restaurant_application.admin.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ncfoa_restaurant_application.R;

import com.example.ncfoa_restaurant_application.admin.adapters.CategoryAdapter;
import com.example.ncfoa_restaurant_application.admin.model.Category;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class CategoryScrollActivity extends  AppCompatActivity{
    RecyclerView rv;
    CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
        addRecyclerView();
    }

    private void addRecyclerView() {
        rv =findViewById(R.id.recview1);
        rv.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<Category> options1 = null;
        options1 = new FirebaseRecyclerOptions.Builder<Category>()
                .setQuery(FirebaseDatabase.getInstance().getReference("Category"), Category.class)
                .build();
        adapter =new CategoryAdapter(options1);
        rv.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    public void floatingActionButtonClick(View view) {
        startActivity(new Intent(getApplicationContext(), CategoryAddDataActivity.class));
    }
}
