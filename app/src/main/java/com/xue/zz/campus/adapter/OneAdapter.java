package com.xue.zz.campus.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xue.zz.campus.R;
import com.xue.zz.campus.config.Global;
import com.xue.zz.campus.modelinfo.ThreeInfo;

import java.util.List;


/**
 * 上拉加载更多
 * 装饰着模式
 */

public class OneAdapter extends RecyclerView.Adapter<OneAdapter.MyViewHolder> {
    private final int TYPE_HEAD = 1;
    private final int TYPE_NOMAL = 2;
    private int currentType;
    private Context mContext;
    private List<ThreeInfo> list;

    public OneAdapter(List<ThreeInfo> list, Context context) {
        this.mContext = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.ac_list_item_therr, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final String group_title = (list.get(position).getGroup_title());
        final String group_text = (list.get(position).getGroup_text());
        final String group_time = (list.get(position).getGroup_time());
        final String headimg = (list.get(position).getHeadimg());
        holder.group_title.setText(group_title);
        holder.group_text.setText(group_text);
        holder.group_time.setText(group_time);
        // 网络获得图片
        String iconURL = Global.BASE_URL_YUN + headimg;
        Glide.with(mContext).load(iconURL).into(holder.headimg);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            currentType = TYPE_HEAD;
        } else {
            currentType = TYPE_NOMAL;
        }
        return currentType;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private String res_id;
        private TextView group_title, group_text, group_time;
        private ImageView headimg;

        public MyViewHolder(View itemView) {
            super(itemView);
            // 标题
            group_title = (TextView) itemView.findViewById(R.id.group_title);
            // 内容
            group_text = (TextView) itemView.findViewById(R.id.group_text);
            // 时间
            group_time = (TextView) itemView.findViewById(R.id.group_time);
            // 图片
            headimg = (ImageView) itemView.findViewById(R.id.headimg);
        }
    }
}
