package com.example.ncfoa_restaurant_application.admin.adapters;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ncfoa_restaurant_application.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ncfoa_restaurant_application.admin.model.Request;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.Objects;

public class WaiterStaffAdapter extends FirebaseRecyclerAdapter<Request, WaiterStaffAdapter.WaiterOrderViewHolder>
{
    public WaiterStaffAdapter(@NonNull FirebaseRecyclerOptions<Request> options1)
    {
        super(options1);
    }

    @Override
    protected void onBindViewHolder(@NonNull WaiterStaffAdapter.WaiterOrderViewHolder holder, int position, @NonNull Request request) {

        holder.phone.setText(request.getPhone());
        holder.name.setText(request.getName());
        holder.status.setText(request.getStatus());
        holder.table.setText(request.getTable());

        holder.prepared.setOnClickListener(view -> {
            AlertDialog.Builder builder=new AlertDialog.Builder(holder.prepared.getContext());
            builder.setTitle("Order Delivered");
            builder.setMessage("Is the Order Completed");

            builder.setPositiveButton("Yes", (dialogInterface, i) -> {

                DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("Request").child(Objects.requireNonNull(getRef(position).getKey()));
                DatabaseReference statusRef = ref.child("status");
                statusRef.setValue("DELIVERED");

            });

            builder.setNegativeButton("No", (dialogInterface, i) -> {

            });

            builder.show();
        });


    }

    @NonNull
    @Override
    public WaiterOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewc)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.kitchen_order_singlerow,parent,false);

        return new WaiterOrderViewHolder(view);
    }

    static class WaiterOrderViewHolder extends RecyclerView.ViewHolder
    {
        TextView phone,name,status,table;
        RecyclerView recyclerView;
        Button prepared;


        public WaiterOrderViewHolder(@NonNull View itemView)
        {
            super(itemView);
            phone= itemView.findViewById(R.id.phonetext);
            name= itemView.findViewById(R.id.nametext);
            table=itemView.findViewById(R.id.tabletext);
            status= itemView.findViewById(R.id.statustext);
            prepared=itemView.findViewById(R.id.prepared);

        }


    }


}
