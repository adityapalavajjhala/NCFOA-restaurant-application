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

public class CategoryAdapter extends FirebaseRecyclerAdapter<Category, CategoryAdapter.CategoryViewHolder>
{
    private final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private final DatabaseReference reference =FirebaseDatabase.getInstance().getReference("Restaurants");
    private final String userID =user.getUid();
    private final Context context;


    public CategoryAdapter(@NonNull FirebaseRecyclerOptions<Category> options1,Context context)
    {
        super(options1);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull final CategoryViewHolder holder, final int position, @NonNull final Category category)
    {
        holder.categoryName.setText(category.getCategoryName());
        holder.edit.setOnClickListener(view -> {editCategory(holder, position, category);});
        holder.delete.setOnClickListener(view -> {deleteCategory(holder, position);});
        System.out.println(category.getCategoryName());

       /* DatabaseReference dishreference = reference.child(userID).child("menu").child(category.getCategoryName()).child("dishes");
       dishreference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                System.out.println(map);
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        }); */

        holder.setOnClickListener(new CategoryViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
               Toast.makeText(view.getContext(), "Category position:" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void deleteCategory(@NonNull CategoryViewHolder holder, int position) {
        AlertDialog.Builder builder=new AlertDialog.Builder(holder.delete.getContext());
        builder.setTitle("Delete Panel");
        builder.setMessage("Do you want to delete this category ?");
        builder.setPositiveButton("Yes", (dialogInterface, i) -> reference.child(userID).child("menu")
                .child(getRef(position).getKey()).removeValue());
        builder.setNegativeButton("No", (dialogInterface, i) -> {
        });

        builder.show();
    }

    private void editCategory(@NonNull CategoryViewHolder holder, int position, @NonNull Category category) {
        DialogPlus dialogPlus=DialogPlus.newDialog(holder.edit.getContext())
                .setContentHolder(new ViewHolder(R.layout.category_dialogcontent))
                .setExpanded(true)
                .create();

        View myview=dialogPlus.getHolderView();
        final EditText categoryName=myview.findViewById(R.id.ucategory);
        Button submit=myview.findViewById(R.id.categoryUpdate);
        categoryName.setText(category.getCategoryName());
        dialogPlus.show();

        submit.setOnClickListener(view1 -> {
            onSubmitClick(position, dialogPlus, categoryName);
        });
    }

    private void onSubmitClick(int position, DialogPlus dialogPlus, EditText categoryName) {
        Map<String,Object> map=new HashMap<>();
        map.put("categoryName",categoryName.getText().toString());
        reference.child(userID).child("menu")
                .child(Objects.requireNonNull(getRef(position).getKey())).updateChildren(map)
                .addOnSuccessListener(aVoid -> dialogPlus.dismiss())
                .addOnFailureListener(e -> dialogPlus.dismiss());
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewc)
    {
        View view= LayoutInflater.from(context).inflate(R.layout.category_singlerow,parent,false);
        return new CategoryViewHolder(view);
    }


    static class CategoryViewHolder extends RecyclerView.ViewHolder
    {
        ImageView edit,delete;
        TextView categoryName;
        RecyclerView recview1;

        public CategoryViewHolder(@NonNull View itemView)
        {
            super(itemView);
            categoryName= itemView.findViewById(R.id.categorynametext);
            edit= itemView.findViewById(R.id.editicon);
            delete= itemView.findViewById(R.id.deleteicon);
            recview1 = itemView.findViewById(R.id.recview1);

            itemView.setOnClickListener(v -> mClickListener.onItemClick(v, getAdapterPosition()));
        }


        private CategoryViewHolder.ClickListener mClickListener;

        public interface ClickListener{
            public void onItemClick(View view, int position);
        }

        public void setOnClickListener(CategoryViewHolder.ClickListener clickListener){
            mClickListener = clickListener;
        }

    }


}
