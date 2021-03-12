package com.example.ncfoa_restaurant_application.admin.activities;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.SearchView;

import com.example.ncfoa_restaurant_application.R;

import com.example.ncfoa_restaurant_application.admin.adapters.DishAdapter;
import com.example.ncfoa_restaurant_application.admin.model.Dish;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class MenuScrollActivity extends AppCompatActivity
{
    RecyclerView recview;
    DishAdapter adapter;
    FloatingActionButton fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_scroll);
        setTitle("Search");

        recview=(RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Dish> options = new FirebaseRecyclerOptions.Builder<Dish>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Category"), Dish.class)
                .build();

        adapter=new DishAdapter(options);
        recview.setAdapter(adapter);

        fb= findViewById(R.id.fadd);
        fb.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), DishAddDataActivity.class)));

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


    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu)
    {
        getMenuInflater().inflate(R.menu.searchmenu,menu);

        MenuItem item=menu.findItem(R.id.search);

        SearchView searchView=(SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String s) {

                processsearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processsearch(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void processsearch(String s)
    {
        FirebaseRecyclerOptions<Dish> options =
                new FirebaseRecyclerOptions.Builder<Dish>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Category").startAt(s).endAt(s+"\uf8ff"), Dish.class)
                        .build();

        adapter=new DishAdapter(options);
        adapter.startListening();
        recview.setAdapter(adapter);

    }
}