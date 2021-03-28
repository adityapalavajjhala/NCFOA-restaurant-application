package com.example.ncfoa_restaurant_application.admin.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ncfoa_restaurant_application.R;

public class DummyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);
        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("category_name");

        setTitle(data);
        TextView categoryname= findViewById(R.id.categoryName);
        categoryname.setText(data);

    }
}


