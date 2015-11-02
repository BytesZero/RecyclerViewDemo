package com.zsl.recyclerviewdemo.adapter;

import android.content.Context;

import com.zsl.recyclerviewdemo.R;
import com.zsl.recyclerviewdemo.entity.User;
import com.zsl.recyclerviewdemo.utils.UniversalRecyclerViewAdapter;
import com.zsl.recyclerviewdemo.utils.UniversalRecyclerViewViewHolder;

import java.util.List;

/**
 * Created by zsl on 15/11/2.
 * show2Adapter
 */
public class MyShow2Adapter extends UniversalRecyclerViewAdapter<User> {


    public MyShow2Adapter(Context context, List<User> mlists, int layoutId) {
        super(context, mlists,R.layout.lv_show1_item);
    }

    @Override
    public void convert(UniversalRecyclerViewViewHolder holder, User user, int position) {
        holder.setText(R.id.show1_item_tv_name, user.getName())
                .setImage(R.id.show1_item_iv_icon, user.getIcon())
                .setCheckBox(R.id.show1_item_cb_man,user.isMan());
    }
}
