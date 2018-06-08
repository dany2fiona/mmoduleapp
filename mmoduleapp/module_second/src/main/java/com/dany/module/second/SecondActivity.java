package com.dany.module.second;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.dany.module.common.utils.ARouterUtils.*;

@Route(path = Second_Main,extras = Login_Extras)
public class SecondActivity extends AppCompatActivity {
    @BindView(R2.id.tv_test)
    TextView mTestTv;

    @Autowired(name = "teststring")
    String testString;
    @Autowired(name = "testint")
    int testInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

        //inject
        ARouter.getInstance().inject(this);

        mTestTv.setText("i am delivered,testString::" + testString + ",testInt::" + testInt);
    }

    @Override
    public void onBackPressed() {
        Intent intent = getIntent();
        intent.putExtra("key", "module_second");
        setResult(101, intent);
        finish();
    }

}
