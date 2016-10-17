package com.example.administrator.studentsystem;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by zhangyu on 2016-08-20.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>{



    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView card_name,card_sex,card_age;
        public ViewHolder(View itemView) {
            super(itemView);
            card_age= (TextView) itemView.findViewById(R.id.card_age);
            card_sex= (TextView) itemView.findViewById(R.id.card_sex);
            card_name= (TextView) itemView.findViewById(R.id.card_name);
        }
    }

    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycleritem,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewAdapter.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
