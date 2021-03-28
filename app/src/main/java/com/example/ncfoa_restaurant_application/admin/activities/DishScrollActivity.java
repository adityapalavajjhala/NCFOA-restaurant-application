package com.example.ncfoa_restaurant_application.admin.activities;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.ncfoa_restaurant_application.R;

import com.example.ncfoa_restaurant_application.admin.model.Dish;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DishScrollActivity extends AppCompatActivity
{
    RecyclerView recview;
    //DishAdapter adapter;
    FloatingActionButton fb;


    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_scroll);

        Bundle bundle = getIntent().getExtras();
        data = bundle.getString("category_name");
        setTitle(data);

        recview=(RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Restaurants");
        userID = user.getUid();

        FirebaseRecyclerOptions<Dish> options = new FirebaseRecyclerOptions.Builder<Dish>()
                .setQuery(reference.child(userID).child("menu").child(data), Dish.class)
                .build();

        //adapter=new DishAdapter(options);
        //recview.setAdapter(adapter);

        fb= findViewById(R.id.fadd);
        fb.setOnClickListener(view -> startActivity(
                new Intent(getApplicationContext(), DishAddDataActivity.class))
        );

    }

    @Override
    protected void onStart() {
        super.onStart();
        //adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
       // adapter.stopListening();
    }

}