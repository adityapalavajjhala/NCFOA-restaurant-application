package com.example.ncfoa_restaurant_application.admin.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ncfoa_restaurant_application.R;
import com.example.ncfoa_restaurant_application.admin.adapters.KitchenStaffAdapter;
import com.example.ncfoa_restaurant_application.admin.adapters.OrderAdapter;
import com.example.ncfoa_restaurant_application.admin.model.Request;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class KitchenStaff extends AppCompatActivity{
    RecyclerView recyclerView;
    KitchenStaffAdapter kitchenStaffAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_status);
        addRecyclerView();
    }

    private void addRecyclerView() {
        recyclerView =findViewById(R.id.listOrder);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<Request> options1 = null;
        options1 = new FirebaseRecyclerOptions.Builder<Request>()
                .setQuery(FirebaseDatabase.getInstance().getReference("Request"), Request.class)
                .build();
        kitchenStaffAdapter =new KitchenStaffAdapter(options1);
        recyclerView.setAdapter(kitchenStaffAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        kitchenStaffAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        kitchenStaffAdapter.stopListening();
    }

}

