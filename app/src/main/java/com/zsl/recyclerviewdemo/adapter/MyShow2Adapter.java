package com.zsl.recyclerviewdemo.adapter;

import android.content.Context;

import com.zsl.recyclerviewdemo.R;
import com.zsl.recyclerviewdemo.entity.User;
import com.zsl.recyclerviewdemo.entity.UserA;
import com.zsl.recyclerviewdemo.utils.UniversalRecyclerAdapter;
import com.zsl.recyclerviewdemo.utils.UniversalRecyclerViewHolder;

import java.util.List;

/**
 * Created by zsl on 15/11/2.
 * show2Adapter
 */
public class MyShow2Adapter extends UniversalRecyclerAdapter<UserA> {


    public MyShow2Adapter(Context context, List<UserA> mlists) {
        super(context, mlists, R.layout.lv_show1_item);
    }

    @Override
    public void convert(UniversalRecyclerViewHolder holder, UserA userA, int position) {
        holder.setText(R.id.show1_item_tv_name, userA.getName())
                .setImage(R.id.show1_item_iv_icon, userA.getIcon())
                .setCheckBox(R.id.show1_item_cb_man, userA.isMan());
    }
}
