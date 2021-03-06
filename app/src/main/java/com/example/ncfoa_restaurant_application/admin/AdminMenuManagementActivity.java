package com.example.ncfoa_restaurant_application.admin;

import android.content.Intent;
import android.os.Bundle;
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

        addcategory=(Button) findViewById(R.id.addcategory);
        addcategory.setOnClickListener(v -> startAddCategory());

        addmenu= findViewById(R.id.addmenu);
        addmenu.setOnClickListener(v -> startAddMenu());
    }

    private void startAddMenu() {
        Intent i= new Intent(this,MenuScrollActivity.class);
        startActivity(i);
    }

    private void startAddCategory(){
        Intent i = new Intent(this, CategoryScrollActivity.class);
        startActivity(i);;
    }



}
