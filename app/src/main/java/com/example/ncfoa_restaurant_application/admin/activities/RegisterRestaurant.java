package com.example.ncfoa_restaurant_application.admin.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ncfoa_restaurant_application.R;
import com.example.ncfoa_restaurant_application.admin.model.Category;
import com.example.ncfoa_restaurant_application.admin.model.Request;
import com.example.ncfoa_restaurant_application.admin.model.Restaurant;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterRestaurant extends AppCompatActivity implements View.OnClickListener{
    private FirebaseAuth mAuth;
    private TextView banner, registerRestaurant;
    private EditText editTextFullname,editTextEmail,editTextPassword;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_restaurant);

        mAuth =FirebaseAuth.getInstance();

        banner=(TextView)findViewById(R.id.banner);
        banner.setOnClickListener(this);

        registerRestaurant= (Button)findViewById(R.id.registerRestaurant);
        registerRestaurant.setOnClickListener(this);

        editTextFullname= (EditText)findViewById(R.id.restaurantName);
        editTextEmail=(EditText)findViewById(R.id.email);
        editTextPassword=(EditText)findViewById(R.id.password);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.registerRestaurant:
                registerRestaurant();
                break;

        }
    }

    private void registerRestaurant() {
        String email=editTextEmail.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();
        String restaurantName=editTextFullname.getText().toString().trim();

        if(restaurantName.isEmpty()){
            editTextFullname.setError("Full name is required!");
            editTextFullname.requestApplyInsets();
            return;
        }
        if(email.isEmpty()){
            editTextEmail.setError("Email is required!");
            editTextEmail.requestApplyInsets();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please provide valid email-ID!");
            editTextEmail.requestFocus();
            return;
        }

        if(password.isEmpty()){
            editTextPassword.setError("Password is required!");
            editTextPassword.requestApplyInsets();
            return;
        }

        if(password.length()<6){
            editTextPassword.setError("Min password lenght should be 6 characters !");
            editTextPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        Restaurant restaurant = new Restaurant(restaurantName, email,null,null,null);
                        FirebaseDatabase.getInstance().getReference("Restaurants")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(restaurant).addOnCompleteListener(task1 -> {
                                        if(task1.isSuccessful())
                                        {
                                            FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
                                            user.sendEmailVerification();
                                            Toast.makeText(RegisterRestaurant.this,"Registered , Check your email to verify your account!",Toast.LENGTH_LONG).show();

                                            new Handler().postDelayed(() -> {
                                                final Intent mainIntent = new Intent(RegisterRestaurant.this, Login.class);
                                                RegisterRestaurant.this.startActivity(mainIntent);
                                                RegisterRestaurant.this.finish();
                                            }, 3000);
                                        }else{
                                            Toast.makeText(RegisterRestaurant.this,"Failed to register! Try again !",Toast.LENGTH_LONG).show();
                                        }
                                        progressBar.setVisibility(View.GONE);
                                    });
                    }else{
                        Toast.makeText(RegisterRestaurant.this,"Failed to register! Try again !",Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);
                    }
                });
    }
}