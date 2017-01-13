package com.lenovo.sharkchao.hospital;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sharkchao.hospital.R;
import com.lenovo.sharkchao.hospital.base.BaseActivity;
import com.lenovo.sharkchao.hospital.model.Picture;

/**
 * A login screen that offers login via email/password.
 */
public class DetailActivity extends BaseActivity {

   private TextView tvName;
    private TextView tvWid;
   private  TextView tvHei;
    private Picture picture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        picture = (Picture) getIntent().getExtras().getSerializable("picture");
        initView();
        if (picture!=null){
            initData();
        }

    }

    @Override
    public void initView() {
         tvName= (TextView) findViewById(R.id.ptName);
         tvWid= (TextView) findViewById(R.id.ptWid);
         tvHei= (TextView) findViewById(R.id.ptHei);
    }

    @Override
    public void initData() {
        tvName.setText(picture.getPictureName());
        tvWid.setText("宽度为："+picture.getWidth());
        tvHei.setText("高度为:"+picture.getHeight());
    }

    @Override
    public void initEvent() {

    }

    public static void ToDetailActivity(Context context, Picture picture) {
        Intent intent=new Intent(context,DetailActivity.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("key",picture);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}

