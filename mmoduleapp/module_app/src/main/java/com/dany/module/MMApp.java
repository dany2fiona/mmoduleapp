package com.dany.module;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by dan.y on 2018/5/10.
 */

public class MMApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if(BuildConfig.DEBUG){
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
    }
}
