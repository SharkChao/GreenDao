package com.lenovo.sharkchao.hospital.utils;

import android.content.Context;

import com.lenovo.sharkchao.hospital.greendao.DBHelper;
import com.lenovo.sharkchao.hospital.greendao.DaoMaster;
import com.lenovo.sharkchao.hospital.greendao.DaoSession;

/**
 * Created by SharkChao on 2017/1/11.
 */

public class GetDaoMaster {
    public static DaoMaster daoMaster;
    public static DaoSession daoSession;
    public static Context context;
    public static DBHelper devOpenHelper;
    public static DaoMaster.DevOpenHelper helper;
    public static DaoMaster getDaoMaster() {
        if (daoMaster == null) {
            //使用封装好的helper
             devOpenHelper = getDBHelper(context);
            daoMaster = new DaoMaster(devOpenHelper.getWritableDb());

            //使用原来的helper
          /*  helper = new DaoMaster.DevOpenHelper(context,"leno");
            daoMaster=new DaoMaster(helper.getWritableDatabase());*/
        }
        return daoMaster;
    }

    public static DaoSession getDaoSession(Context context) {
        GetDaoMaster.context=context;
        if (daoSession == null) {
                    if (daoMaster == null) {
                        daoMaster = getDaoMaster();
                    }
                    daoSession = daoMaster.newSession();
        }
        return daoSession;
    }
    public static DBHelper getDBHelper(Context context){
        if (devOpenHelper==null){
            devOpenHelper=new DBHelper(context);
        }
        return devOpenHelper;
    }
    public static DaoMaster.DevOpenHelper getDvHelper(Context context){
        if (helper==null){
             helper = new DaoMaster.DevOpenHelper(context,"leno");
        }
        return helper;
    }
}
