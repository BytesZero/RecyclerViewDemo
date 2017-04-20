package com.zsl.recyclerviewdemo.utils;

import android.view.View;

/**
 * Created by zsl on 16/8/17.
 * RecyclerView OnItemClickListener
 */
public interface OnItemClickListener {

    void onItemClick(View view, int position);

    boolean onItemLongClick(View view, int position);
}
