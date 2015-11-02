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

import com.zsl.recyclerviewdemo.R;
import com.zsl.recyclerviewdemo.entity.User;
import com.zsl.recyclerviewdemo.utils.UniversalRecyclerViewAdapter;
import com.zsl.recyclerviewdemo.utils.UniversalRecyclerViewViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsl on 15/11/2.
 */
public class MultipleItemAdapter extends UniversalRecyclerViewAdapter<User> {

    List<Integer> layoutIdList=new ArrayList<Integer>();

    public MultipleItemAdapter(Context context, List<User> mlists) {
        super(context, mlists, 0);
        layoutIdList.add(R.layout.lv_show1_item);
        layoutIdList.add(R.layout.lv_show2_item);
    }

    @Override
    public void convert(UniversalRecyclerViewViewHolder holder, User user, int position) {
        if (getItemViewType(position)==R.layout.lv_show1_item){
            holder.setImage(R.id.show1_item_iv_icon,user.getIcon())
                    .setText(R.id.show1_item_tv_name,user.getName())
                    .setCheckBox(R.id.show1_item_cb_man,user.isMan());
        }else if (getItemViewType(position)==R.layout.lv_show2_item){
            holder.setText(R.id.show2_item_tv_name,user.getName());
        }
    }

    @Override
    public int getItemViewType(int position) {
        return layoutIdList.get(position%3==0?1:0);
    }
}
