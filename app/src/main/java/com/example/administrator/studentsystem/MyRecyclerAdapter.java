package com.example.administrator.studentsystem;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.studentsystem.SqlFH.MainActivity;

/**
 * Created by zhangyu on 2016-08-20.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycer,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(view);
            }
        });
    }
    @Override
    public int getItemCount() {
        return 1;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView increase_text,remove_text,change_text,check_text,local_video,online_video;
        public ViewHolder(View itemView) {
            super(itemView);
            increase_text= (TextView) itemView.findViewById(R.id.increase_text);
            remove_text= (TextView) itemView.findViewById(R.id.remove_text);
            change_text= (TextView) itemView.findViewById(R.id.change_text);
            check_text= (TextView) itemView.findViewById(R.id.check_text);
            local_video= (TextView) itemView.findViewById(R.id.local_video);
            online_video= (TextView) itemView.findViewById(R.id.online_video);
        }
    }

    public  interface  onItemClickListener{
        void onItemClick(View view);
    }
    private onItemClickListener listener;

    public void setOnItemClickListener(onItemClickListener listener){
        this.listener=listener;
    }
}
