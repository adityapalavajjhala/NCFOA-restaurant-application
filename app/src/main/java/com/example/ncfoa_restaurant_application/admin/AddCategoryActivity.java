package com.example.ncfoa_restaurant_application.admin;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ncfoa_restaurant_application.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddCategoryActivity extends AppCompatActivity {
    DatabaseReference myRef ;
    Category category;

    EditText category_name;
    Button addCategory;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity_add_category);

        category_name = findViewById(R.id.AddCategoryName);
        addCategory = findViewById(R.id.AddCategoryButton);

        myRef = FirebaseDatabase.getInstance().getReference("Category");

        addCategory.setOnClickListener(v -> {
            boolean go = true;
            if (category_name.getText().toString().length() <= 0) {
                category_name.setError("Dish Name is Required");
                go = false;
            }
            if (go) {
                category = new Category(category_name.getText().toString());
                myRef.child(category.getCategoryName()).setValue(category);

                Toast.makeText(AddCategoryActivity.this, "Category Added Successfully", Toast.LENGTH_LONG).show();
                finish();
            }

        });
    }
}