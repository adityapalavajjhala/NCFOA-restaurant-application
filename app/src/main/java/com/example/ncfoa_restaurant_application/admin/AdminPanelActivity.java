package com.example.ncfoa_restaurant_application.admin;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.example.ncfoa_restaurant_application.R;
import java.util.ArrayList;
import java.util.Date;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AdminPanelActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    Button mbutton;

    String date1 = null;
    Date d1;
    Date d2;
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

    static ArrayList<String> keys = new ArrayList<String>();
    static Boolean flag = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity_menu);

        mbutton=(Button) findViewById(R.id.AddMenuItemButton);
        mbutton.setOnClickListener(v-> onClickReg());

    }

    private void onClickReg() {
        Intent i = new Intent(this, AddMenuItemActivity.class);
        startActivity(i);
    }

}
