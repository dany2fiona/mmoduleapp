package com.dany.module.main.interceptor;

import android.content.Context;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

import static com.dany.module.common.utils.ARouterUtils.*;

/**
 * 自动注册，必须在init后-->放在main模块统一管理
 * 用于login判断和权限判断等全局公用的功能
 * Created by dan.y on 2018/5/16.
 */

@Interceptor(priority = 4)//值越小优先级越大
public class TestInterceptor implements IInterceptor {
    private Context mContext;
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        int extras = postcard.getExtra();
        Log.d("arouter",postcard.getPath() + ".." + postcard.getExtra());
        if(extras == Login_Extras){
            boolean isLogin = false;//sp中读取
            if(isLogin){
                callback.onContinue(postcard);
            }else{
                Looper.prepare();
                Toast.makeText(mContext, postcard.getPath() + ".." + postcard.getGroup()+"。。需要登录", Toast.LENGTH_SHORT).show();
                Looper.loop();
                callback.onInterrupt(null);
                Log.d("arouter",postcard.getPath() + ".." + postcard.getGroup()+"。。需要登录");
            }
        }else{
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {
        Log.d("arouter",TestInterceptor.class.getSimpleName() + " has been inited");
        mContext = context;
    }
}
