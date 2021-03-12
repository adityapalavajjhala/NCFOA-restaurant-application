package com.example.ncfoa_restaurant_application.admin;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ncfoa_restaurant_application.R;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class DishAddData extends AppCompatActivity
{
    EditText dishname,price,description,purl,type;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu);

        initializeVariables();

    }

    private void initializeVariables() {
        dishname= findViewById(R.id.add_dishname);
        price= findViewById(R.id.add_price);
        description=findViewById(R.id.add_description);
        type=findViewById(R.id.add_type);
        purl= findViewById(R.id.add_purl);
    }

    public void backClick(View view) {
        finish();
    }

    public void insertDish(View view) {
        Map<String,Object> map=new HashMap<>();
        map.put("dishname",dishname.getText().toString());
        map.put("price",price.getText().toString());
        map.put("description",description.getText().toString());
        map.put("purl",purl.getText().toString());
        map.put("type",type.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("Testing")
                .setValue(map)
                .addOnSuccessListener(aVoid -> {
                    dishname.setText("");
                    price.setText("");
                    description.setText("");
                    purl.setText("");
                    type.setText("");;
                    Toast.makeText(getApplicationContext(),"Inserted Successfully",Toast.LENGTH_LONG).show();
                })
                .addOnFailureListener(e -> Toast.makeText(getApplicationContext(),"Could not insert",Toast.LENGTH_LONG).show());
    }
}
