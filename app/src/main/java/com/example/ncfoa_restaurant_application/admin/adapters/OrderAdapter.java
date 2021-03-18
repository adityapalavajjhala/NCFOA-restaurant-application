package com.example.ncfoa_restaurant_application.admin.adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.example.ncfoa_restaurant_application.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ncfoa_restaurant_application.admin.model.Request;


import java.util.List;


public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder>
{
    private final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private final List<Request> orderList;

    public OrderAdapter(List<Request> orderList) {
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.order_singlerow, viewGroup, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder orderViewHolder, int i) {
        Request request = orderList.get(i);
        orderViewHolder.phone.setText(request.getPhone());
        orderViewHolder.name.setText(request.getName());
        orderViewHolder.status.setText(request.getStatus());
        orderViewHolder.table.setText(request.getTable());

        LinearLayoutManager layoutManager = new LinearLayoutManager(orderViewHolder.dishRecyclerView.getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        layoutManager.setInitialPrefetchItemCount(request.getFoods().size());

        DishListAdapter dishListAdapter = new DishListAdapter(request.getFoods());
        orderViewHolder.dishRecyclerView.setLayoutManager(layoutManager);
        orderViewHolder.dishRecyclerView.setAdapter(dishListAdapter);
        orderViewHolder.dishRecyclerView.setRecycledViewPool(viewPool);

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

     class OrderViewHolder extends RecyclerView.ViewHolder
    {
        TextView phone,name,status,table;
        RecyclerView dishRecyclerView;
         OrderViewHolder(@NonNull View itemView)
        {
            super(itemView);
            phone= itemView.findViewById(R.id.phonetext);
            name= itemView.findViewById(R.id.nametext);
            table=itemView.findViewById(R.id.tabletext);
            status= itemView.findViewById(R.id.statustext);
            dishRecyclerView=itemView.findViewById(R.id.dishRecyclerView);
        }
    }


}
