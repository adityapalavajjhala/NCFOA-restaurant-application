package com.example.ncfoa_restaurant_application.admin;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ncfoa_restaurant_application.R;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class menuadddata extends AppCompatActivity
{
    EditText dishname,price,description,purl,type;
    Button submit,back;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu);

        dishname= findViewById(R.id.add_dishname);
        price= findViewById(R.id.add_price);
        description=findViewById(R.id.add_description);
        type=findViewById(R.id.add_type);
        purl= findViewById(R.id.add_purl);

        back= findViewById(R.id.add_back);
        back.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),MenuScrollActivity.class));
            finish();
        });

        submit= findViewById(R.id.add_submit);
        submit.setOnClickListener(view -> processinsert());
    }

    private void processinsert()
    {
        Map<String,Object> map=new HashMap<>();
        map.put("dishname",dishname.getText().toString());
        map.put("price",price.getText().toString());
        map.put("description",description.getText().toString());
        map.put("purl",purl.getText().toString());
        map.put("type",type.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("Testing").child(type.getText().toString())
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
