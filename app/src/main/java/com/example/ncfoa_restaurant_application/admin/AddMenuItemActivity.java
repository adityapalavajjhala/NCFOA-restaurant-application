package com.example.ncfoa_restaurant_application.admin;

import com.example.ncfoa_restaurant_application.R;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class AddMenuItemActivity extends AppCompatActivity {

    DatabaseReference mDatabase;

    EditText name;
    EditText type;
    EditText price;
    Button addMenu;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity_add_menu_item);

        name = findViewById(R.id.AddDishName);
        type = findViewById(R.id.AddDishType);
        price = findViewById(R.id.AddDishPrice);
        addMenu = findViewById(R.id.AddMenuItemButton);


        mDatabase = FirebaseDatabase.getInstance().getReference();

        addMenu.setOnClickListener(v -> {
            boolean go = true;
            if (name.getText().toString().length() <= 0) {
                name.setError("Dish Name is Required");
                go = false;
            }else if (type.getText().toString().length() <= 0) {
                type.setError("Dish Type is Required");
                go = false;
            } else if (price.getText().toString().length() <= 0) {
                price.setError("Price is Required");
                go = false;
            }
            if (price.getText().toString().length() > 0 && Integer.parseInt(price.getText().toString()) < 1) {
                price.setError("Price cannot be 0");
                go = false;
            }
            if (go) {
                Menu menu = new Menu(name.getText().toString(),type.getText().toString(), price.getText().toString());
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Category");
                DatabaseReference ref1 = ref.child(type.getText().toString());



                ref1.child(menu.getDishName()).setValue(menu);
                Toast.makeText(AddMenuItemActivity.this, "Menu Item Added Successfully", Toast.LENGTH_LONG).show();
                finish();
            }

        });
    }
}
