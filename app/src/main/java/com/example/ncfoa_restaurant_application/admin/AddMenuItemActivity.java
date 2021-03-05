package com.example.ncfoa_restaurant_application.admin;

import com.example.ncfoa_restaurant_application.R;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddMenuItemActivity extends AppCompatActivity {

    DatabaseReference mDatabase;
    DatabaseReference checkitem;

    EditText name;
    EditText categoryName;
    EditText price;
    Button addMenu;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity_add_menu_item);

        name = findViewById(R.id.AddDishName);
        categoryName = findViewById(R.id.AddDishType);
        price = findViewById(R.id.AddDishPrice);
        addMenu = findViewById(R.id.AddMenuItemButton);


        mDatabase = FirebaseDatabase.getInstance().getReference();

        addMenu.setOnClickListener(v -> {
            boolean go = true;
            if (name.getText().toString().length() <= 0) {
                name.setError("Dish Name is Required");
                go = false;
            }else if (categoryName.getText().toString().length() <= 0) {
                categoryName.setError("Dish Category is Required");
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
                Menu menu = new Menu(name.getText().toString(),categoryName.getText().toString(), price.getText().toString());
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Category");
                DatabaseReference ref1 = ref.child(categoryName.getText().toString());

                checkitem =  ref.child(categoryName.getText().toString());
                checkitem.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.child(name.getText().toString()).exists()) {
                            Toast.makeText(AddMenuItemActivity.this, "Menu Item already present", Toast.LENGTH_LONG).show();
                        }
                        else{
                            ref1.child(menu.getDishName()).setValue(menu);
                            Toast.makeText(AddMenuItemActivity.this, "Menu Item Added Successfully", Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
                finish();
            }

        });
    }
}
