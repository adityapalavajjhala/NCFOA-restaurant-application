package com.example.ncfoa_restaurant_application.admin.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.ncfoa_restaurant_application.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ncfoa_restaurant_application.admin.model.Dish;
import com.example.ncfoa_restaurant_application.admin.model.Request;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.w3c.dom.Text;

public class KitchenStaffAdapter extends FirebaseRecyclerAdapter<Request, KitchenStaffAdapter.StaffOrderViewHolder>
{
    public KitchenStaffAdapter(@NonNull FirebaseRecyclerOptions<Request> options1)
    {
        super(options1);
    }

    @Override
    protected void onBindViewHolder(@NonNull KitchenStaffAdapter.StaffOrderViewHolder holder, int position, @NonNull Request request) {

        holder.phone.setText(request.getPhone());
        holder.name.setText(request.getName());
        holder.status.setText(request.getStatus());
        holder.table.setText(request.getTable());
        holder.prepared.setText(request.getTable());
    }

    @NonNull
    @Override
    public StaffOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewc)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.kitchen_order_singlerow,parent,false);

        return new StaffOrderViewHolder(view);
    }

    static class StaffOrderViewHolder extends RecyclerView.ViewHolder
    {
        TextView phone,name,status,table;
        RecyclerView recyclerView;
        Button prepared;


        public StaffOrderViewHolder(@NonNull View itemView)
        {
            super(itemView);
            phone= itemView.findViewById(R.id.phonetext);
            name= itemView.findViewById(R.id.nametext);
            table=itemView.findViewById(R.id.tabletext);
            status= itemView.findViewById(R.id.statustext);
            recyclerView =itemView.findViewById(R.id.recyclerview);
            prepared=itemView.findViewById(R.id.prepared);

        }


    }


}
