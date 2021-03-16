package com.example.ncfoa_restaurant_application.admin.adapters;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ncfoa_restaurant_application.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ncfoa_restaurant_application.admin.model.Dish;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class DishAdapter extends FirebaseRecyclerAdapter<Dish, DishAdapter.myviewholder>
{
    public DishAdapter(@NonNull FirebaseRecyclerOptions<Dish> options)
    {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final myviewholder holder, final int position, @NonNull final Dish model)
    {
        holder.dishname.setText(model.getDishName());
        holder.price.setText((int) model.getPrice());
        holder.description.setText(model.getDescription());
        holder.type.setText(model.getType());

        Glide.with(holder.img.getContext()).load(model.getPurl()).into(holder.img);

        holder.edit.setOnClickListener(view -> {
            final DialogPlus dialogPlus=DialogPlus.newDialog(holder.img.getContext())
                    .setContentHolder(new ViewHolder(R.layout.dialogcontent))
                    .setExpanded(true,1100)
                    .create();

            View myview=dialogPlus.getHolderView();

            final EditText purl=myview.findViewById(R.id.uimgurl);

            final EditText dishname=myview.findViewById(R.id.udishname);
            final EditText price=myview.findViewById(R.id.uprice);
            final EditText description=myview.findViewById(R.id.udescription);
            final EditText type=myview.findViewById(R.id.utype);

            Button submit=myview.findViewById(R.id.usubmit);

            purl.setText(model.getPurl());
            dishname.setText(model.getDishName());
            price.setText((int) model.getPrice());;
            description.setText(model.getDescription());
            type.setText(model.getType());

            dialogPlus.show();

            submit.setOnClickListener(view1 -> {
                Map<String,Object> map=new HashMap<>();
                map.put("dishname",dishname.getText().toString());
                map.put("price",price.getText().toString());
                map.put("description",description.getText().toString());
                map.put("purl",purl.getText().toString());
                map.put("type",type.getText().toString());


                FirebaseDatabase.getInstance().getReference().child("Testing")
                        .child(Objects.requireNonNull(getRef(position).getKey())).updateChildren(map)
                        .addOnSuccessListener(aVoid -> dialogPlus.dismiss())
                        .addOnFailureListener(e -> dialogPlus.dismiss());
            });


        });


        holder.delete.setOnClickListener(view -> {
            AlertDialog.Builder builder=new AlertDialog.Builder(holder.img.getContext());
            builder.setTitle("Delete Panel");
            builder.setMessage("Do you want to delete the Dish Item ?");

            builder.setPositiveButton("Yes", (dialogInterface, i) -> FirebaseDatabase.getInstance().getReference().child("Testing")
                    .child(getRef(position).getKey()).removeValue());

            builder.setNegativeButton("No", (dialogInterface, i) -> {

            });

            builder.show();
        });

    } // End of OnBindViewMethod

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewc)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }


    class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img;
        ImageView edit,delete;
        TextView dishname,price,description,type;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            img= itemView.findViewById(R.id.img);

            dishname= itemView.findViewById(R.id.dishnametext);
            price= itemView.findViewById(R.id.pricetext);
            description= itemView.findViewById(R.id.descriptiontext);
            type=itemView.findViewById(R.id.typetext);


            edit= itemView.findViewById(R.id.editicon);
            delete= itemView.findViewById(R.id.deleteicon);
        }
    }
}
