package com.example.ncfoa_restaurant_application.admin.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ncfoa_restaurant_application.R;
import com.example.ncfoa_restaurant_application.admin.model.Category;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CategoryAddDataActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_adddata);
    }

    public void startAddCategory(View view) {
        Category category=new Category();
        category.setCategoryName(((EditText)findViewById(R.id.add_category)).getText().toString().trim());
        FirebaseDatabase.getInstance().getReference("Category").child(category.getCategoryName())
                .setValue(category)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(getApplicationContext(),"Inserted Successfully",Toast.LENGTH_LONG).show();
                    finish();
                })
                .addOnFailureListener(e -> Toast.makeText(getApplicationContext(),"Could not insert",Toast.LENGTH_LONG).show());
    }

    public void backClick(View view) {
        finish();
    }
}
