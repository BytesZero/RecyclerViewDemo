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

package com.zsl.recyclerviewdemo.adapter;

import android.content.Context;
import android.util.Log;

import com.zsl.recyclerviewdemo.R;
import com.zsl.recyclerviewdemo.entity.User;
import com.zsl.recyclerviewdemo.entity.UserA;
import com.zsl.recyclerviewdemo.entity.UserB;
import com.zsl.recyclerviewdemo.utils.UniversalRecyclerAdapter;
import com.zsl.recyclerviewdemo.utils.UniversalRecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsl on 15/11/2.
 */
public class MultipleItemAdapter extends UniversalRecyclerAdapter<User> {

    List<Integer> layoutIdList = new ArrayList<Integer>();

    public MultipleItemAdapter(Context context, List<User> mlists) {
        super(context, mlists, 0);
        layoutIdList.add(R.layout.lv_show1_item);
        layoutIdList.add(R.layout.lv_show2_item);
    }

    @Override
    public int getItemViewType(int position) {
        if (super.getItemViewType(position) == TYPE_HEADER) {
            return TYPE_HEADER;
        } else {
            int absPosition = getAbsPosition(position);
            if (mlists.get(absPosition) instanceof UserA) {
                return R.layout.lv_show1_item;
            } else if (mlists.get(absPosition) instanceof UserB) {
                return R.layout.lv_show2_item;
            } else {
                return super.getItemViewType(position);
            }
        }
    }

    @Override
    public void convert(UniversalRecyclerViewHolder holder, User user, int position) {
        Log.d("MultipleItemAdapter", "position:" + position);
        if (getItemViewType(position) == R.layout.lv_show1_item) {
            UserA userA = (UserA) user;
            holder.setImage(R.id.show1_item_iv_icon, userA.getIcon())
                    .setText(R.id.show1_item_tv_name, userA.getName())
                    .setCheckBox(R.id.show1_item_cb_man, userA.isMan());
        } else if (getItemViewType(position) == R.layout.lv_show2_item) {
            UserB userB = (UserB) user;
            holder.setText(R.id.show2_item_tv_name, userB.getName());
        }
    }
}
