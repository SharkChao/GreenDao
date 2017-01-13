package com.lenovo.sharkchao.hospital.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.lenovo.sharkchao.hospital.greendao.DaoMaster;

/**
 * Created by SharkChao on 2017/1/10.
 */

public class DBHelper extends DaoMaster.OpenHelper {
    public static final String DBNAME = "lenve.db";

    public DBHelper(Context context) {
        super(context, "lenovo.db", null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }
}