/*
 *    Copyright (c) 2015 ZSL
 *    Licensed under the Apache License, Version 2.0 (the "License");
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

package com.zsl.recyclerviewdemo.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by zsl on 15/11/2.
 */
public abstract class UniversalRecyclerViewAdapter<T> extends RecyclerView.Adapter<UniversalRecyclerViewViewHolder> {

    protected Context context;
    protected List<T> mlists;
    protected LayoutInflater mInflater;
    protected int layoutId;
    public UniversalRecyclerViewAdapter(Context context, List<T> mlists, int layoutId) {
        this.context = context;
        this.mlists = mlists;
        this.layoutId=layoutId;
        this.mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public UniversalRecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutId==0) {
            return new UniversalRecyclerViewViewHolder(mInflater.inflate(viewType, parent, false), onItemClickListener);
        }else{
            return new UniversalRecyclerViewViewHolder(mInflater.inflate(layoutId,parent,false),onItemClickListener);
        }
    }

    @Override
    public int getItemCount() {
        return mlists == null ? 0 : mlists.size();
    }

    @Override
    public void onBindViewHolder(UniversalRecyclerViewViewHolder holder, int position) {
        convert(holder, mlists.get(position), position);
    }

    public abstract void convert(UniversalRecyclerViewViewHolder holder, T t, int position);

    /***
     * 添加点击事件
     ***/
    protected static OnItemClickListener onItemClickListener;

    //点击事件的接口
    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    /**
     * 设置点击事件
     *
     * @param onItemClickListener
     */
    public static void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        UniversalRecyclerViewAdapter.onItemClickListener = onItemClickListener;
    }

    /***添加公共操作***/

    public void add(T t,int position){
        mlists.add(position,t);
        notifyItemInserted(position);
    }

    public void addAll(List<T> t,int positionStart){
        mlists.addAll(t);
        notifyItemRangeInserted(positionStart, t.size());
    }

    public void remove(int position){
        mlists.remove(position);
        notifyItemRemoved(position);
    }

    public void update(int position){
        notifyItemChanged(position);
    }

}
