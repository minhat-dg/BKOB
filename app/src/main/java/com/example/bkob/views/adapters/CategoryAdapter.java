package com.example.bkob.views.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bkob.R;
import com.example.bkob.models.CategoryModel;
import com.example.bkob.views.interfaces.HomeInterface;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {
    private Context context;
    public ArrayList<CategoryModel> categoryList;
    private HomeInterface homeInterface;


    public CategoryAdapter(Context context, ArrayList<CategoryModel> categoryList){
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        CategoryModel categoryModel = categoryList.get(position);

        String name = categoryModel.getName();
        String imageUrl = categoryModel.getImageUrl();


        holder.categoryName.setText(name);
        try{
            Picasso.get().load(imageUrl).into(holder.categoryImage);
        }
        catch (Exception e){
            Log.d("Category", "Fail to load image:"+e.getMessage());
        }

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(homeInterface != null){
                    homeInterface.loadBookInCategory(categoryModel.getName());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
    public void onClick(HomeInterface homeInterface){
        this.homeInterface = homeInterface;
    }

    class CategoryHolder extends RecyclerView.ViewHolder {
        private ImageView categoryImage;
        private TextView categoryName;
        private RelativeLayout item;

        public CategoryHolder(@NonNull View itemView) {
            super(itemView);

            categoryImage = itemView.findViewById(R.id.img_category);
            categoryName = itemView.findViewById(R.id.tv_categoryName);
            item = itemView.findViewById(R.id.item_category);
        }
    }
}
