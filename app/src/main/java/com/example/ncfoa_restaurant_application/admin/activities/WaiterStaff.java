package com.example.ncfoa_restaurant_application.admin.activities;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ncfoa_restaurant_application.R;
import com.example.ncfoa_restaurant_application.admin.adapters.KitchenStaffAdapter;
import com.example.ncfoa_restaurant_application.admin.adapters.OrderAdapter;
import com.example.ncfoa_restaurant_application.admin.adapters.WaiterStaffAdapter;
import com.example.ncfoa_restaurant_application.admin.model.Request;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class WaiterStaff extends AppCompatActivity{
    RecyclerView recyclerView;
    WaiterStaffAdapter waiterStaffAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiter_staff);
        addRecyclerView();
    }

    private void addRecyclerView() {
        recyclerView =findViewById(R.id.listOrder);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<Request> options1 = null;
        options1 = new FirebaseRecyclerOptions.Builder<Request>()
                .setQuery(FirebaseDatabase.getInstance().getReference("Request"), Request.class)
                .build();
        waiterStaffAdapter =new WaiterStaffAdapter(options1);
        recyclerView.setAdapter(waiterStaffAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        waiterStaffAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        waiterStaffAdapter.stopListening();
    }

}

