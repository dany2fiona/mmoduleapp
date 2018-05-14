package com.dany.module.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_m1).setOnClickListener(this);
        findViewById(R.id.btn_m2).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.btn_m1){
            ARouter.getInstance().build("/first/main").navigation();
        }else if(id == R.id.btn_m2){
            ARouter.getInstance().build("/second/main").navigation();
        }
    }
}
