package com.example.ncfoa_restaurant_application.admin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.example.ncfoa_restaurant_application.R;

public class AdminMenuManagementActivity extends AppCompatActivity {

    Button addMenuButton;
    Button addCategoryButton;
    Button addMagic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity_menu_management);

        addMenuButton=(Button) findViewById(R.id.AddMenuItemButton);
        addMenuButton.setOnClickListener(v-> startAddMenuItem());

        addCategoryButton=(Button) findViewById(R.id.AddCategoryButton);
        addCategoryButton.setOnClickListener(v -> startAddCategory());

        addMagic=(Button) findViewById(R.id.magic);
        addMagic.setOnClickListener(v -> startAddMagic());

    }

    private void startAddMenuItem() {
        Intent i = new Intent(this, AddMenuItemActivity.class);
        startActivity(i);
    }

    private void startAddCategory() {
        Intent i = new Intent(this, AddCategoryActivity.class);
        startActivity(i);
    }

    private void startAddMagic(){
        Intent i = new Intent(this,CategoryActivity.class);
        startActivity(i);;
    }


}
