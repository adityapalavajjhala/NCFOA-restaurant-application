package com.example.ncfoa_restaurant_application.admin.adapters;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ncfoa_restaurant_application.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ncfoa_restaurant_application.admin.model.Dish;
import com.example.ncfoa_restaurant_application.admin.model.Request;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class DishListAdapter extends FirebaseRecyclerAdapter<Dish, DishListAdapter.DishListViewHolder>
{
    public DishListAdapter(@NonNull FirebaseRecyclerOptions<Dish> options2)
    {
        super(options2);
    }


    @Override
    protected void onBindViewHolder(@NonNull DishListAdapter.DishListViewHolder holder, int position, @NonNull Dish dish) {
        holder.dishname.setText(dish.getDishName());
        holder.quantity.setText((int) dish.getQuantity());
        holder.price.setText((int) dish.getPrice());

    }

    @NonNull
    @Override
    public DishListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewc)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.dishes_singlerow,parent,false);
        return new DishListViewHolder(view);
    }

    static class DishListViewHolder extends RecyclerView.ViewHolder
    {
        TextView dishname,quantity,price;

        public DishListViewHolder(@NonNull View itemView)
        {
            super(itemView);
            dishname=itemView.findViewById(R.id.dishnametext);
            quantity=itemView.findViewById(R.id.dishquantitytext);
            price=itemView.findViewById(R.id.dishpricetext);

        }
    }


}
