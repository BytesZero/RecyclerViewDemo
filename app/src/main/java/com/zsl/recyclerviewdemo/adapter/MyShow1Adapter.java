/*
 * Copyright (c) 2015 ZSL
 * Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

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

    /***创建OnItemClickListener***/

    private static OnItemClickListener onItemClickListener;

    public interface OnItemClickListener{
        void onItemClickListener(View itemView,int position);
    }

    //设置OnItemClickListener
    public static void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        MyShow1Adapter.onItemClickListener = onItemClickListener;
    }

    public static class Show1TextVoiewHolder extends RecyclerView.ViewHolder{
        TextView tv_name;
        public Show1TextVoiewHolder(final View itemView) {
            super(itemView);
            tv_name= (TextView) itemView.findViewById(R.id.show1_item_tv_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    Log.d("Show1TextVoiewHolder","click-->position="+position);

                    if (onItemClickListener!=null){
                        onItemClickListener.onItemClickListener(itemView,position);
                    }
                }
            });
        }
    }
}
