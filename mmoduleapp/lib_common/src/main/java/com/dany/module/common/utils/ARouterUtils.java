package com.dany.module.common.utils;

/**
 * 路由表放在lib_common统一管理
 * Created by dan.y on 2018/5/22.
 */

public class ARouterUtils {
    /**
     *  页面
     */
    //跳转到first模块main视图
    public static final String First_Main = "/first/main";
    //跳转到second模块main视图
    public static final String Second_Main = "/second/main";
    //跳转到second模块main视图
    public static final String Third_Main = "/third/main";
    //跳转到DataBindingTest页面
    public static final String First_DBTest = "/first/dbtest";
    /**
     *  组--拦截器按组名生效拦截..但是一个普通组有多个页面时失效，采用extras来区分
     */
//    //统一登陆检查分组
//    public static final String Group_Login = "needlogin";
    //统一登录检查重新分组标识
    public static final int Login_Extras = 1;
}
