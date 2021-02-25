package com.example.ncfoa_restaurant_application.admin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ncfoa_restaurant_application.R;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



public class AdminPanelActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    String date1 = null;
    Date d1;
    Date d2;
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

    static ArrayList<Item> itm = new ArrayList<Item>();
    static ArrayList<String> keys = new ArrayList<String>();
    static Boolean flag = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity_menu);

    }

    public void onClickReg5(View v) {
        Intent i = new Intent(this, AddMenuItemActivity.class);
        startActivity(i);
    }


}
