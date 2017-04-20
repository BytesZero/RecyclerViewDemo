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

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by zsl on 15/11/2.
 * RecyclerViewHolder
 */
public class UniversalRecyclerViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews;
    public View itemView;

    public UniversalRecyclerViewHolder(final View itemView) {
        super(itemView);
        this.mViews = new SparseArray<View>();
        this.itemView = itemView;
    }

    /**
     * 获得到控件
     *
     * @param viewId item layout 中控件的id
     * @param <T>    范型
     * @return 范型View
     */

    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 设置TextView的文本
     *
     * @param viewId item layout 中TextView的id
     * @param text   文本内容
     * @return UniversalRecyclerViewHolder
     */
    public UniversalRecyclerViewHolder setText(int viewId, String text) {
        TextView textView = getView(viewId);
        textView.setText(text);
        return this;
    }

    /**
     * 通过url设置ImageView 的图片
     * 这里可以修改为自己的图片加载库
     *
     * @param viewId item layout 中ImageView的id
     * @param url    图片的url
     * @return UniversalRecyclerViewHolder
     */
    public UniversalRecyclerViewHolder setImage(int viewId, String url) {
        ImageView imageView = getView(viewId);
        imageView.setTag(url);
        //这里可以修改为自己的图片加载库
//        Ion.with(mContext).load(url).intoImageView(imageView);
        ImageLoader.getInstance().displayImage(url, imageView);
        return this;
    }

    /**
     * 通过ResourceId设置ImageView 的图片
     *
     * @param view       item layout 中ImageView
     * @param resourceId 图片资源文件的id
     * @return UniversalRecyclerViewHolder
     */
    public UniversalRecyclerViewHolder setImageResource(View view, int resourceId) {
        ImageView imageView = (ImageView) view;
        imageView.setTag(resourceId + "");
        imageView.setImageResource(resourceId);
        return this;
    }

    /**
     * 通过ResourceId设置ImageView 的图片
     *
     * @param viewId     item layout 中ImageView的id
     * @param resourceId 图片资源文件的id
     * @return UniversalRecyclerViewHolder
     */
    public UniversalRecyclerViewHolder setImageResource(int viewId, int resourceId) {
        ImageView imageView = getView(viewId);
        imageView.setTag(resourceId + "");
        imageView.setImageResource(resourceId);
        return this;
    }

    /**
     * 通过bitmap 设置ImageView 的图片
     *
     * @param view   item layout 中ImageView
     * @param bitmap bitmap
     * @return UniversalRecyclerViewHolder
     */
    public UniversalRecyclerViewHolder setImageBitmap(View view, Bitmap bitmap) {
        ImageView imageView = (ImageView) view;
        imageView.setImageBitmap(bitmap);
        return this;
    }

    /**
     * 通过bitmap 设置ImageView 的图片
     *
     * @param viewId item layout 中ImageView的id
     * @param bitmap bitmap
     * @return UniversalRecyclerViewHolder
     */
    public UniversalRecyclerViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView imageView = getView(viewId);
        imageView.setImageBitmap(bitmap);
        return this;
    }

    /**
     * 设置View隐藏Gone
     *
     * @param viewId
     * @return
     */
    public UniversalRecyclerViewHolder setViewGone(int viewId) {
        getView(viewId).setVisibility(View.GONE);
        return this;
    }

    /**
     * 设置View隐藏Invisible
     *
     * @param viewId
     * @return
     */
    public UniversalRecyclerViewHolder setViewInvisible(int viewId) {
        getView(viewId).setVisibility(View.INVISIBLE);
        return this;
    }

    /**
     * 设置View显示Visible
     *
     * @param viewId
     * @return
     */
    public UniversalRecyclerViewHolder setViewVisible(int viewId) {
        getView(viewId).setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置CheckBox 是否选中
     *
     * @param viewId
     * @param isChecked
     * @return
     */
    public UniversalRecyclerViewHolder setCheckBox(int viewId, boolean isChecked) {
        CheckBox checkBox = getView(viewId);
        checkBox.setChecked(isChecked);
        return this;
    }

    /**
     * ==============下边可以写自己的控件的实现，参考上边的ImageView================
     */

}
