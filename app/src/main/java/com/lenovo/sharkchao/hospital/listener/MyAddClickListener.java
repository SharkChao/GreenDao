package com.lenovo.sharkchao.hospital.listener;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;

import com.example.sharkchao.hospital.R;
import com.lenovo.sharkchao.hospital.MainActivity;
import com.lenovo.sharkchao.hospital.greendao.UserDao;
import com.lenovo.sharkchao.hospital.model.User;
import com.lenovo.sharkchao.hospital.utils.GetDaoMaster;

/**
 * Created by SharkChao on 2017/1/10.
 */

public class MyAddClickListener implements View.OnClickListener {
    private Context context;
    private UserDao userDao;
    public MyAddClickListener(Context context){
        userDao= GetDaoMaster.getDaoSession(context).getUserDao();
        this.context=context;
    }
    @Override
    public void onClick(View v) {
        final View view=View.inflate(context, R.layout.dialog_add,null);
        new AlertDialog.Builder(context)
                .setTitle("新增用户")
                .setView(view)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText etName= (EditText) view.findViewById(R.id.etName);
                        EditText etBName= (EditText) view.findViewById(R.id.etBName);
                        EditText etSName= (EditText) view.findViewById(R.id.etSName);
                        String name = etName.getText().toString();
                        String age=etBName.getText().toString();
                        String sex=etSName.getText().toString();
                        User user=new User(null,0,name,age,sex);
                        userDao.insert(user);

                        //此处用回调
                        MainActivity main=(MainActivity)context;
                        main.setMyadapter();
                    }
                })
                .setNegativeButton("取消",null)
                .create().show();
    }
}
