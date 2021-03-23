package com.example.ncfoa_restaurant_application.admin.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.example.ncfoa_restaurant_application.R;
import com.google.firebase.auth.FirebaseAuth;

public class AdminMenuManagementActivity extends AppCompatActivity {

    // Edited the files such that all the category items are pushed under Category node
    // and all the menu items are pushed under Testing node.

    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity_menu_management);

        logout = (Button) findViewById(R.id.signOut);
        logout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(AdminMenuManagementActivity.this,Login.class));
        });
    }

    public void startAddMenu(View view) {
        startActivity(new Intent(this,MenuScrollActivity.class));
    }

    public void startAddCategory(View view) {
        startActivity(new Intent(this, CategoryScrollActivity.class));
    }


    public void startOrder(View view) {
        startActivity(new Intent(this, OrderStatus.class));
    }


    public void startPreparation(View view) {
        startActivity(new Intent(this,KitchenStaff.class));
    }

    public void startDelivery(View view) {
        startActivity(new Intent(this,WaiterStaff.class));
    }


}
