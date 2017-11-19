package com.example.android.computerstoreapp.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.computerstoreapp.R;
import com.example.android.computerstoreapp.entity.Category;

import java.util.List;

/**
 * Created by android on 2017-10-26.
 */

public class CategoryAdapter  extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<Category> mCategoryList;
    private String path;
    private static String classFoldName = ".view.";

    static class ViewHolder extends RecyclerView.ViewHolder {
        View categoryView;
        ImageView categoryImage;
        TextView categoryName;

        public ViewHolder(View view) {
            super(view);

            categoryView = view;
            categoryImage = (ImageView) view.findViewById(R.id.category_image);
            categoryName = (TextView) view.findViewById(R.id.category_name);
        }
    }

    public CategoryAdapter (List<Category> categoryList) {
        mCategoryList = categoryList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        path=parent.getContext().getApplicationContext().getPackageName() + classFoldName;
        holder.categoryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Category category = mCategoryList.get(position);
            //    Toast.makeText(v.getContext(),"You clicked view" + category.getName(),Toast.LENGTH_SHORT).show();


                Intent intent = null;
                try {
                    intent = new Intent(v.getContext(), Class.forName(path +category.getClassName()));
                    v.getContext().startActivity(intent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Category category = mCategoryList.get(position);
        holder.categoryImage.setImageResource(category.getImageId());
        holder.categoryName.setText(category.getName());

    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }

}
