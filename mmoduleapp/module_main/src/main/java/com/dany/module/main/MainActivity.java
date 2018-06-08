package com.dany.module.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.dany.module.common.utils.ARouterUtils.*;


public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R2.id.btn_m1, R2.id.btn_m2, R2.id.btn_m3})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.btn_m1) {//无参数
            ARouter.getInstance().build(First_Main).greenChannel().navigation();
        } else if (id == R.id.btn_m2) {//有参数
            ARouter.getInstance().build(Second_Main)
                    .withString("teststring", "dany2fiona")
                    .withInt("testint", 520)
                    .greenChannel()
                    .navigation(MainActivity.this, 100);
        } else if (id == R.id.btn_m3) {
            ARouter.getInstance().build(Third_Main).navigation(MainActivity.this, new NavCallback() {
                @Override
                public void onArrival(Postcard postcard) {//路由到达之后调用
                    Log.d("arouter", "onArrival : " + postcard.getPath());
                }

                @Override
                public void onFound(Postcard postcard) {//路由目标被发现时调用
                    Log.d("arouter", "onFound : " + postcard.getPath());
                }

                @Override
                public void onLost(Postcard postcard) {//路由被丢失时调用
                    Log.d("arouter", "onLost : " + postcard.getPath());
                }

                @Override
                public void onInterrupt(Postcard postcard) {//路由被拦截时调用
                    Log.d("arouter", "onInterrupt : " + postcard.getPath());
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            Log.e("arouter", "-----------空-----------");
            return;
        }
        if (requestCode == 100 && resultCode == 101) {
            String key = data.getStringExtra("key");
            Toast.makeText(this, "回调的内容：" + key, Toast.LENGTH_SHORT).show();
        }
    }


}
