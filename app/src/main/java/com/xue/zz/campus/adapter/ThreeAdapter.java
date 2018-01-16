package com.xue.zz.campus.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.xue.zz.campus.R;
import com.xue.zz.campus.config.Global;
import com.xue.zz.campus.modelinfo.ThreeInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/7/20.
 */

public class ThreeAdapter extends BaseAdapter {
    private List<ThreeInfo> list;
    private Context mContext;

    public ThreeAdapter(List<ThreeInfo> list, Context context) {
        this.list = list;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.ac_list_item_therr, null);
            holder = new ViewHolder();
            // 标题
            holder.group_title = (TextView) convertView.findViewById(R.id.group_title);
            // 内容
            holder.group_text = (TextView) convertView.findViewById(R.id.group_text);
            // 时间
            holder.group_time = (TextView) convertView.findViewById(R.id.group_time);
            // 图片
            holder.headimg = (ImageView) convertView.findViewById(R.id.headimg);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
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
        //Picasso.with(mContext).load(iconURL).into(holder.headimg);
//        holder.mList_itme_click.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext, Ac_MessageReply.class);
//                intent.putExtra("name", messageSendPerson + ":");
//                intent.putExtra("description", description);
//                intent.putExtra("messageSendId", messageSendId);
//                mContext.startActivity(intent);
//            }
//        });
        return convertView;
    }


    class ViewHolder {
        private String res_id;
        private TextView group_title, group_text, group_time;
        private ImageView headimg;
    }


    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
