package com.example.ncfoa_restaurant_application.admin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.example.ncfoa_restaurant_application.R;
import java.util.ArrayList;

public class AdminPanelActivity extends AppCompatActivity {

    Button addMenuButton;
    Button addCategoryButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity_adminpanel);

        addMenuButton=(Button) findViewById(R.id.AddMenuItemButton);
        addMenuButton.setOnClickListener(v-> startAddMenuItem());

        addCategoryButton=(Button) findViewById(R.id.AddCategoryButton);
        addCategoryButton.setOnClickListener(v -> startAddCategory());
    }

    private void startAddMenuItem() {
        Intent i = new Intent(this, AddMenuItemActivity.class);
        startActivity(i);
    }

    private void startAddCategory() {
        Intent i = new Intent(this, AddCategoryActivity.class);
        startActivity(i);
    }

}
