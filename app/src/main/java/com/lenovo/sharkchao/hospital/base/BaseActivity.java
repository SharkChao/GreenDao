package com.lenovo.sharkchao.hospital.base;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by SharkChao on 2017/1/10.
 */

public abstract class BaseActivity extends Activity {


    public static Activity currentActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentActivity = this;
        initView();
        initData();
        initEvent();
    }

    public abstract  void initView();
    public abstract void initData();
    public abstract void initEvent();
    public static Activity getCurrentActivity(){
        return currentActivity;
    }
}
