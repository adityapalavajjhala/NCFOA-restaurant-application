package com.example.ncfoa_restaurant_application.admin.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ncfoa_restaurant_application.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ncfoa_restaurant_application.admin.model.Request;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class OrderAdapter extends FirebaseRecyclerAdapter<Request, OrderAdapter.OrderViewHolder>
{
    public OrderAdapter(@NonNull FirebaseRecyclerOptions<Request> options1)
    {
        super(options1);
    }

    @Override
    protected void onBindViewHolder(@NonNull OrderAdapter.OrderViewHolder holder, int position, @NonNull Request request) {

        holder.phone.setText(request.getPhone());
        holder.name.setText(request.getName());
        holder.status.setText(request.getStatus());
        holder.table.setText(request.getTable());

    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewc)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.order_singlerow,parent,false);
        return new OrderViewHolder(view);
    }

    static class OrderViewHolder extends RecyclerView.ViewHolder
    {
        TextView phone,name,status,table;
        public OrderViewHolder(@NonNull View itemView)
        {
            super(itemView);
            phone= itemView.findViewById(R.id.phonetext);
            name= itemView.findViewById(R.id.nametext);
            table=itemView.findViewById(R.id.tabletext);
            status= itemView.findViewById(R.id.statustext);
        }
    }


}
