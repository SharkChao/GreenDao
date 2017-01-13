package com.lenovo.sharkchao.hospital.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lenovo.sharkchao.hospital.model.User;

import java.util.List;

/**
 * Created by SharkChao on 2017/1/10.
 */

public class MyBaseAdapter extends BaseAdapter {
    private List<User> lists;
   public  MyBaseAdapter(List<User> lists,Context context){
       this.lists=lists;
   }
    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

}
