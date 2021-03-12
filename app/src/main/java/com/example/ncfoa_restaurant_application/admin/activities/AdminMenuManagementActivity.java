package com.example.ncfoa_restaurant_application.admin.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.example.ncfoa_restaurant_application.R;

public class AdminMenuManagementActivity extends AppCompatActivity {

    Button addcategory;
    Button addmenu;

    // Edited the files such that all the category items are pushed under Category node
    // and all the menu items are pushed under Testing node.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity_menu_management);
    }

    public void startAddMenu(View view) {
        startActivity(new Intent(this,MenuScrollActivity.class));
    }

    public void startAddCategory(View view) {
        startActivity(new Intent(this, CategoryScrollActivity.class));
    }
}
