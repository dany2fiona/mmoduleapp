package com.dany.module.first;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dany.module.common.utils.ARouterUtils;
import com.dany.module.first.bean.UserBean;
import com.dany.module.first.databinding.ActivityDataBindingTestBinding;

@Route(path = ARouterUtils.First_DBTest)
public class DataBindingTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDataBindingTestBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding_test);
        UserBean bean = new UserBean("张三",20);
        binding.setUser(bean);
    }
}
