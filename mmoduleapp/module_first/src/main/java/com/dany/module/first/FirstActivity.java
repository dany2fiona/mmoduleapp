package com.dany.module.first;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.dany.module.common.utils.ARouterUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.dany.module.common.utils.ARouterUtils.*;

@Route(path = First_Main,extras = Login_Extras)
public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.btn_dbtest)
    public void onViewClicked() {
        ARouter.getInstance().build(ARouterUtils.First_DBTest).navigation();
    }
}
