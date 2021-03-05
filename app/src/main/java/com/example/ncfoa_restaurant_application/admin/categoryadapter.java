package com.example.ncfoa_restaurant_application.admin;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ncfoa_restaurant_application.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.DialogPlusBuilder;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.logging.Handler;

import de.hdodenhof.circleimageview.CircleImageView;

public class categoryadapter extends FirebaseRecyclerAdapter<category,categoryadapter.myviewholder>
{
    public categoryadapter(@NonNull FirebaseRecyclerOptions<category> options1)
    {
        super(options1);
    }

    @Override
    protected void onBindViewHolder(@NonNull final myviewholder holder, final int position, @NonNull final category category)
    {
        holder.categoryName.setText(category.getCategoryName());

        holder.edit.setOnClickListener(view -> {
            final DialogPlus dialogPlus=DialogPlus.newDialog(holder.edit.getContext())
                    .setContentHolder(new ViewHolder(R.layout.category_dialogcontent))
                    .setExpanded(true,1100)
                    .create();

            View myview=dialogPlus.getHolderView();


            final EditText categoryName=myview.findViewById(R.id.ucategory);

            Button submit=myview.findViewById(R.id.usubmit1);

            categoryName.setText(category.getCategoryName());

            dialogPlus.show();

            submit.setOnClickListener(view1 -> {
                Map<String,Object> map=new HashMap<>();
                map.put("categoryName",categoryName.getText().toString());


                FirebaseDatabase.getInstance().getReference().child("Category")
                        .child(Objects.requireNonNull(getRef(position).getKey())).updateChildren(map)
                        .addOnSuccessListener(aVoid -> dialogPlus.dismiss())
                        .addOnFailureListener(e -> dialogPlus.dismiss());
            });


        });


        holder.delete.setOnClickListener(view -> {
            AlertDialog.Builder builder=new AlertDialog.Builder(holder.delete.getContext());
            builder.setTitle("Delete Panel");
            builder.setMessage("Do you want to delete the Dish Item ?");

            builder.setPositiveButton("Yes", (dialogInterface, i) -> FirebaseDatabase.getInstance().getReference().child("Category")
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
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_singlerow,parent,false);
        return new myviewholder(view);
    }


    class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img;
        ImageView edit,delete;
        TextView categoryName;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);

            categoryName= itemView.findViewById(R.id.categorynametext);


            edit= itemView.findViewById(R.id.editicon);
            delete= itemView.findViewById(R.id.deleteicon);
        }
    }
}
