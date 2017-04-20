package com.zsl.recyclerviewdemo.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by zsl on 16/9/19.
 * HeaderViewHolder
 */
public class HeaderViewHolder extends RecyclerView.ViewHolder {

    FrameLayout base;
    public HeaderViewHolder(View itemView) {
        super(itemView);
        this.base= (FrameLayout) itemView;
    }

}
