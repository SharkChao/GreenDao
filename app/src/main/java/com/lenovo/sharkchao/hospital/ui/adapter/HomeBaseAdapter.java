package com.lenovo.sharkchao.hospital.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sharkchao.hospital.R;
import com.lenovo.sharkchao.hospital.model.User;

import java.util.List;

/**
 * Created by SharkChao on 2017/1/11.
 */

public class HomeBaseAdapter extends MyBaseAdapter {
    private Context context;
    private List<User> lists;
    public HomeBaseAdapter(List<User> lists, Context context) {
        super(lists, context);
        this.context=context;
        this.lists=lists;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //先拿到当前对象
        User user=lists.get(position);
        ViewHolder viewHolder=null;
        View view;
        if(convertView==null){
            viewHolder=new ViewHolder();
            view=View.inflate(context, R.layout.list_item,null);
            viewHolder.tvName= (TextView) view.findViewById(R.id.tvName);
            viewHolder.tvAge= (TextView) view.findViewById(R.id.tvAge);
            viewHolder.tvSex= (TextView) view.findViewById(R.id.tvSex);
            view.setTag(viewHolder);
        }else{
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.tvName.setText(user.getName().toString());
        viewHolder.tvAge.setText(user.getAge());
        viewHolder.tvSex.setText(user.getSex());
        return view;
    }
    public class ViewHolder{
        private TextView tvName;
        private TextView tvAge;
        private TextView tvSex;
    }
}
