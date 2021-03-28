package com.example.ncfoa_restaurant_application.admin.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ncfoa_restaurant_application.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ncfoa_restaurant_application.admin.activities.CategoryScrollActivity;
import com.example.ncfoa_restaurant_application.admin.activities.DishScrollActivity;
import com.example.ncfoa_restaurant_application.admin.activities.DummyActivity;
import com.example.ncfoa_restaurant_application.admin.model.Category;
import com.example.ncfoa_restaurant_application.admin.model.Dish;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DishListAdapter extends FirebaseRecyclerAdapter<Dish, DishListAdapter.DishViewHolder>
{
    public DishListAdapter(FirebaseRecyclerOptions<Dish> options2) {
        super(options2);
    }

    @Override
    protected void onBindViewHolder(@NonNull final DishViewHolder holder, final int position, @NonNull final Dish dish)
    {
        holder.dishnametext.setText(dish.getDishName());
        holder.dishquantitytext.setText(dish.getDishName());
        holder.dishpricetext.setText((int) dish.getPrice());
    }


    @NonNull
    @Override
    public DishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewc)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.dishes_singlerow,parent,false);
        return new DishViewHolder(view);
    }




    static class DishViewHolder extends RecyclerView.ViewHolder
    {
        TextView dishnametext,dishquantitytext,dishpricetext;

        public DishViewHolder(@NonNull View itemView)
        {
            super(itemView);
            dishnametext= itemView.findViewById(R.id.dishnametext);
            dishquantitytext= itemView.findViewById(R.id.dishquantitytext);
            dishpricetext= itemView.findViewById(R.id.dishpricetext);
        }

    }
}
