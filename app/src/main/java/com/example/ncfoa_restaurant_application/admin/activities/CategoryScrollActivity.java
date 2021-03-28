package com.example.ncfoa_restaurant_application.admin.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ncfoa_restaurant_application.R;

import com.example.ncfoa_restaurant_application.admin.adapters.CategoryAdapter;
import com.example.ncfoa_restaurant_application.admin.model.Category;
import com.example.ncfoa_restaurant_application.admin.model.Restaurant;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CategoryScrollActivity extends  AppCompatActivity{
    RecyclerView rv;
    CategoryAdapter adapter;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
        addRecyclerView();
    }

    private void addRecyclerView() {
        rv =findViewById(R.id.recview1);
        rv.setLayoutManager(new LinearLayoutManager(this));
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Restaurants");
        userID = user.getUid();

        FirebaseRecyclerOptions<Category> options1 = null;
        options1 = new FirebaseRecyclerOptions.Builder<Category>()
                .setQuery(reference.child(userID).child("menu"), Category.class)
                .build();

        adapter =new CategoryAdapter(options1,this);
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
