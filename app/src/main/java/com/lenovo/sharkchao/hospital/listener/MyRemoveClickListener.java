package com.lenovo.sharkchao.hospital.listener;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sharkchao.hospital.R;
import com.lenovo.sharkchao.hospital.MainActivity;
import com.lenovo.sharkchao.hospital.greendao.UserDao;
import com.lenovo.sharkchao.hospital.model.User;
import com.lenovo.sharkchao.hospital.utils.GetDaoMaster;

/**
 * Created by SharkChao on 2017/1/11.
 */

public class MyRemoveClickListener implements View.OnClickListener {
    private Context context;
    private UserDao userDao;
    public MyRemoveClickListener(Context context){
        userDao= GetDaoMaster.getDaoSession(context).getUserDao();
        this.context=context;
    }
    @Override
    public void onClick(View v) {
        final View view2=View.inflate(context, R.layout.dialog_move,null);
        new AlertDialog.Builder(context)
                .setTitle("删除用户")
                .setView(view2)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText etName= (EditText) view2.findViewById(R.id.etName);
                        String name = etName.getText().toString();
                        Toast.makeText(context,""+name,Toast.LENGTH_SHORT).show();
                        User user = userDao.queryBuilder() .where(UserDao.Properties.Name.eq(name)) .build() .unique();
                        if (user!=null){
                            userDao.delete(user);
                        }else{
                            Toast.makeText(context,"查无此人",Toast.LENGTH_SHORT).show();
                        }
                        //此处用回调
                        MainActivity main=(MainActivity)context;
                        main.setMyadapter();
                    }
                })
                .setNegativeButton("取消",null)
                .create().show();
    }
}
