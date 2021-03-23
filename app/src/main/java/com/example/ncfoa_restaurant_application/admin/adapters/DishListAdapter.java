package com.example.ncfoa_restaurant_application.admin.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ncfoa_restaurant_application.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ncfoa_restaurant_application.admin.model.Dish;


import java.util.List;


public class DishListAdapter extends RecyclerView.Adapter<DishListAdapter.DishListViewHolder> {

    private final List<Dish> dishItemList;

    public DishListAdapter(List<Dish> dishItemList) {
        this.dishItemList = dishItemList;
    }

    @NonNull
    @Override
    public DishListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewc = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dishes_singlerow, viewGroup, false);
        return new DishListViewHolder(viewc);
    }

    @Override
    public void onBindViewHolder(@NonNull DishListViewHolder dishListViewHolder, int i) {
        Dish dishItem = dishItemList.get(i);
        dishListViewHolder.dishlistname.setText(dishItem.getDishName());
        dishListViewHolder.dishquantity.setText((int) dishItem.getQuantity());
        dishListViewHolder.dishprice.setText((int) dishItem.getPrice());

    }

    @Override
    public int getItemCount() {
        return dishItemList.size();
    }

     static class DishListViewHolder extends RecyclerView.ViewHolder {
        TextView dishlistname,dishquantity,dishprice;
        public DishListViewHolder(View itemView) {
            super(itemView);
            dishlistname = itemView.findViewById(R.id.dishnametext);
            dishquantity = itemView.findViewById(R.id.dishquantitytext);
            dishprice= itemView.findViewById(R.id.dishpricetext);

        }
    }
}
