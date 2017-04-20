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
import android.widget.FrameLayout;

import java.util.List;

/**
 * Created by zsl on 15/11/2.
 * 通用的RecyclerViewAdapter
 */
public abstract class UniversalRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //item类型
    protected static final int TYPE_HEADER = -1;
    //    public static final int TYPE_FOOTER = -2;

    protected Context context;
    protected List<T> mlists;
    protected int lastPositon;
    private LayoutInflater mInflater;
    //headerView
    protected View headerView;
    protected int layoutId;
    private OnItemClickListener onItemClickListener;

    public UniversalRecyclerAdapter(Context context, List<T> mlists, int layoutId) {
        this.context = context;
        this.mlists = mlists;
        this.layoutId = layoutId;
        this.mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0 && headerView != null) {
            return TYPE_HEADER;
        } else {
            return super.getItemViewType(position);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {//Header
            FrameLayout frameLayout = new FrameLayout(parent.getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            return new HeaderViewHolder(frameLayout);
        } else {
            if (layoutId == 0) {//多item类型
                return new UniversalRecyclerViewHolder(mInflater.inflate(viewType, parent, false));
            } else {
                return new UniversalRecyclerViewHolder(mInflater.inflate(layoutId, parent, false));
            }
        }
    }

    @Override
    public int getItemCount() {
        int headerCount = 0;
        if (headerView != null) {
            headerCount = 1;
        }
        if (mlists == null) {
            return headerCount;
        } else {
            return mlists.size() + headerCount;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        lastPositon = position;
        if (holder instanceof HeaderViewHolder) {//绑定headerView
            ((HeaderViewHolder) holder).base.removeAllViews();
            ((HeaderViewHolder) holder).base.addView(headerView);
        } else {//通用的UniversalRecyclerViewHolder
            final int absPosition = getAbsPosition(holder.getAdapterPosition());
            convert((UniversalRecyclerViewHolder) holder, mlists.get(absPosition), position);
            //添加点击事件
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClick(view, absPosition);
                }
            });
            //添加长按事件
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    return onItemLongClick(view, absPosition);
                }
            });
        }

    }

    public abstract void convert(UniversalRecyclerViewHolder holder, T t, int position);

    /**
     * 获得最终的position
     *
     * @param position 当前position
     * @return 最终的position
     */
    public int getAbsPosition(int position) {
        return (position - (headerView == null ? 0 : 1));
    }

    ///////////////////////////////////////////////////////////////////////////
    // 添加公共操作
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 获取更新时使用的最终position
     *
     * @param position 当前的position
     * @return 最终的position
     */
    protected int getUpdatePosition(int position) {
        return (position + (headerView == null ? 0 : 1));
    }

    /**
     * 添加数据
     *
     * @param t        数据
     * @param position 插入的位置
     */
    public void add(T t, int position) {
        mlists.add(position, t);
        int absPosition = getUpdatePosition(position);
        notifyItemInserted(absPosition);
        notifyItemRangeChanged(position, lastPositon);
    }

    /**
     * 添加全部
     *
     * @param t 数据
     */
    public void addAll(List<T> t) {
        mlists.addAll(t);
        notifyDataSetChanged();
    }

    /**
     * 移除指定位置
     *
     * @param position position
     */
    public void remove(int position) {
        mlists.remove(position);
        int absPosition = getUpdatePosition(position);
        notifyItemRemoved(absPosition);
        notifyItemRangeChanged(absPosition, lastPositon);
    }

    /**
     * 更新指定item
     *
     * @param position position
     */
    public void update(int position) {
        notifyItemChanged(getUpdatePosition(position));
    }

    /**
     * 更新所有数据
     *
     * @param t List
     */
    public void updateAll(List<T> t) {
        mlists.clear();
        mlists.addAll(t);
        notifyDataSetChanged();
    }

    /**
     * 获取的getOnItemClickListener
     *
     * @return OnItemClickListener
     */
    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    /**
     * 设置OnItemClickListener
     *
     * @param onItemClickListener onItemClickListener
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    /**
     * item点击
     *
     * @param view     View
     * @param position position
     */
    protected void onItemClick(View view, int position) {
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(view, position);
        }
    }

    /**
     * item长按
     *
     * @param view     View
     * @param position position
     */
    protected boolean onItemLongClick(View view, int position) {
        if (onItemClickListener != null) {
            return onItemClickListener.onItemLongClick(view, position);
        }
        return false;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Header 的操作
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 添加Header
     *
     * @param view HeaderView
     */
    public void addHeader(View view) {
        if (view == null) {
            return;
        }
        if (headerView != null) {
        } else {
            headerView = view;
            notifyItemInserted(0);
        }
    }

    /**
     * 移除Header
     */
    public void removeHeader(View view) {
        if (view == null) {
            return;
        }
        if (view != headerView) {
        } else {
            headerView = null;
            notifyItemRemoved(0);
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
        }
    }
}
