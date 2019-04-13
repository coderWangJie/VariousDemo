package com.wangj.variousdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wangj.variousdemo.R;
import com.wangj.variousdemo.entity.DemoVo;

import java.util.List;

public class DemoListAdapter extends BaseAdapter {

    private Context context;
    private List<DemoVo> list;

    public DemoListAdapter(Context context, List<DemoVo> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_demo, parent, false);
            viewHolder.textView = convertView.findViewById(R.id.textView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText(list.get(position).getDemoName());

        return convertView;
    }

    class ViewHolder {
        private TextView textView;
    }
}
