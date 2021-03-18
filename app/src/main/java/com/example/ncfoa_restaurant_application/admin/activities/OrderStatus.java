package com.example.ncfoa_restaurant_application.admin.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ncfoa_restaurant_application.R;
import com.example.ncfoa_restaurant_application.admin.adapters.OrderAdapter;
import com.example.ncfoa_restaurant_application.admin.model.Request;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class OrderStatus extends  AppCompatActivity{
    RecyclerView recyclerView;
    OrderAdapter orderAdapter;
    private List<Request> orderList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_status);

        orderList=new ArrayList<>();

        recyclerView = findViewById(R.id.listOrder);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Request");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Request request = ds.getValue(Request.class);
                    orderList.add(request);
                }

                orderAdapter = new OrderAdapter(orderList);
                recyclerView.setAdapter(orderAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });


    }

}
