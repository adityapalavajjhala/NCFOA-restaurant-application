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

import com.example.ncfoa_restaurant_application.admin.model.Category;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CategoryAdapter extends FirebaseRecyclerAdapter<Category, CategoryAdapter.CategoryViewHolder>
{
    public CategoryAdapter(@NonNull FirebaseRecyclerOptions<Category> options1)
    {
        super(options1);
    }

    @Override
    protected void onBindViewHolder(@NonNull final CategoryViewHolder holder, final int position, @NonNull final Category category)
    {
        holder.categoryName.setText(category.getCategoryName());

        holder.edit.setOnClickListener(view -> {editCategory(holder, position, category);});

        holder.delete.setOnClickListener(view -> {deleteCategory(holder, position);});

    }

    private void deleteCategory(@NonNull CategoryViewHolder holder, int position) {
        AlertDialog.Builder builder=new AlertDialog.Builder(holder.delete.getContext());
        builder.setTitle("Delete Panel");
        builder.setMessage("Do you want to delete the Dish Item ?");
        builder.setPositiveButton("Yes", (dialogInterface, i) -> FirebaseDatabase.getInstance().getReference().child("Category")
                .child(getRef(position).getKey()).removeValue());
        builder.setNegativeButton("No", (dialogInterface, i) -> {
        });

        builder.show();
    }

    private void editCategory(@NonNull CategoryViewHolder holder, int position, @NonNull Category category) {
        DialogPlus dialogPlus=DialogPlus.newDialog(holder.edit.getContext())
                .setContentHolder(new ViewHolder(R.layout.category_dialogcontent))
                .setExpanded(true,1100)
                .create();

        View myview=dialogPlus.getHolderView();
        final EditText categoryName=myview.findViewById(R.id.ucategory);
        Button submit=myview.findViewById(R.id.usubmit1);
        categoryName.setText(category.getCategoryName());
        dialogPlus.show();

        submit.setOnClickListener(view1 -> {
            onSubmitClick(position, dialogPlus, categoryName);
        });
    }

    private void onSubmitClick(int position, DialogPlus dialogPlus, EditText categoryName) {
        Map<String,Object> map=new HashMap<>();
        map.put("categoryName",categoryName.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("Category")
                .child(Objects.requireNonNull(getRef(position).getKey())).updateChildren(map)
                .addOnSuccessListener(aVoid -> dialogPlus.dismiss())
                .addOnFailureListener(e -> dialogPlus.dismiss());
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewc)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_singlerow,parent,false);
        return new CategoryViewHolder(view);
    }


    class CategoryViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        ImageView edit,delete;
        TextView categoryName;
        public CategoryViewHolder(@NonNull View itemView)
        {
            super(itemView);
            categoryName= itemView.findViewById(R.id.categorynametext);
            edit= itemView.findViewById(R.id.editicon);
            delete= itemView.findViewById(R.id.deleteicon);
        }
    }
}
