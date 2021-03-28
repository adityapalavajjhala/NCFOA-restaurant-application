package com.example.ncfoa_restaurant_application.admin.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ncfoa_restaurant_application.R;
import com.example.ncfoa_restaurant_application.admin.model.Restaurant;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminMenuManagementActivity extends AppCompatActivity {

    private final FirebaseUser user =FirebaseAuth.getInstance().getCurrentUser();
    private final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Restaurants");
    private final String userID =user.getUid();
    TextView active_orders,completed_orders_count,tables_count,categories_count,dishes_count;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity_menu_management);

        active_orders=findViewById(R.id.active_orders);
        completed_orders_count=findViewById(R.id.completed_orders_count);
        tables_count=findViewById(R.id.tables_count);
        categories_count=findViewById(R.id.categories_count);
        dishes_count=findViewById(R.id.dishes_count);



        Button logout = (Button) findViewById(R.id.signOut);
        logout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(AdminMenuManagementActivity.this,Login.class));
        });

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Restaurant restaurantProfile = snapshot.getValue(Restaurant.class);
                if(restaurantProfile!=null)
                {
                    String restaurantName = restaurantProfile.fullName;
                    setTitle(restaurantName);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }



    public void startCategory(View view) { startActivity(new Intent(this, CategoryScrollActivity.class)); }

    public void startDishes(View view) { startActivity(new Intent(this, DishScrollActivity.class)); }

    public void startOrder(View view) {
        startActivity(new Intent(this, OrderStatus.class));
    }

    public void startPreparation(View view) {
        startActivity(new Intent(this,KitchenStaff.class));
    }

    public void startDelivery(View view) {
        startActivity(new Intent(this,WaiterStaff.class));
    }

    public void startTableQR(View view) { startActivity(new Intent(this,TableQR.class));}

    public void startSupport(View view) { startActivity(new Intent(this,Support.class));}

    public void startPaymentVerification(View view) { startActivity(new Intent(this,PaymentVerification.class));}
}
