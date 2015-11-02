package com.zsl.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zsl.recyclerviewdemo.R;

import java.util.List;

/**
 * Created by zsl on 15/11/2.
 */
public class MyShow1Adapter extends RecyclerView.Adapter<MyShow1Adapter.Show1TextVoiewHolder> {
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private List<String> mNameList;

    public MyShow1Adapter(Context mContext, List<String> mNameList) {
        this.mContext = mContext;
        this.mNameList = mNameList;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public Show1TextVoiewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Show1TextVoiewHolder(mLayoutInflater.inflate(R.layout.lv_show1_item,parent,false));
    }

    @Override
    public void onBindViewHolder(Show1TextVoiewHolder holder, int position) {
        holder.tv_name.setText(mNameList.get(position));
    }

    @Override
    public int getItemCount() {
        return mNameList==null?0:mNameList.size();
    }

    public static class Show1TextVoiewHolder extends RecyclerView.ViewHolder{
        TextView tv_name;
        public Show1TextVoiewHolder(View itemView) {
            super(itemView);
            tv_name= (TextView) itemView.findViewById(R.id.show1_item_tv_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Show1TextVoiewHolder","click-->position="+getAdapterPosition());
                }
            });
        }
    }
}
