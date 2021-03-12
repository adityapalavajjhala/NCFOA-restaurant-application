package com.example.ncfoa_restaurant_application.admin;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ncfoa_restaurant_application.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class CategoryAddData extends AppCompatActivity
{
    EditText categoryName;
    Button submit,back;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_adddata);

        categoryName= findViewById(R.id.add_category);

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
        try {
            DatabaseReference db=FirebaseDatabase.getInstance().getReference("Category").child(categoryName.getText().toString().trim());
            Category category=new Category();
            category.setCategoryName(categoryName.getText().toString().trim());
            FirebaseDatabase.getInstance().getReference("Category").child(categoryName.getText().toString().trim())
                    .setValue(category)
                    .addOnSuccessListener(aVoid -> {
                        categoryName.setText("");
                        Toast.makeText(getApplicationContext(),"Inserted Successfully",Toast.LENGTH_LONG).show();
                    })
                    .addOnFailureListener(e -> Toast.makeText(getApplicationContext(),"Could not insert",Toast.LENGTH_LONG).show());

        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
