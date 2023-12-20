package com.example.task_management;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList CategoryName, NumberOfTasks;


    CustomAdapter(Activity activity, Context context, ArrayList CategoryName, ArrayList NumberOfTasks){

        this.activity = activity;
        this.context = context;
        this.CategoryName = CategoryName;
        this.NumberOfTasks = NumberOfTasks;
    }


    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {

        holder.book_title_txt.setText(String.valueOf(NumberOfTasks.get(position)));
        holder.book_id_txt.setText(String.valueOf(CategoryName.get(position)));

    }

    @Override
    public int getItemCount() {
        return NumberOfTasks.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView book_id_txt, book_title_txt, book_author_txt, book_pages_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            book_id_txt = itemView.findViewById(R.id.gategory_id_txt);
            book_title_txt = itemView.findViewById(R.id.gategory_title_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }

    }
}
