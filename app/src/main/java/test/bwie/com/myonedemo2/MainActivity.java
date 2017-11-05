package test.bwie.com.myonedemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hjm.bottomtabbar.BottomTabBar;

import fragment.Myone;

public class MainActivity extends AppCompatActivity {

    BottomTabBar bottomTabBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitView();
    }

    private void InitView() {
        bottomTabBar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
        bottomTabBar.init(getSupportFragmentManager())
                .addTabItem("首页", R.mipmap.ic_launcher, Myone.class)
                .addTabItem("交易", R.mipmap.ic_launcher, Myone.class)
                .addTabItem("咨询", R.mipmap.ic_launcher, Myone.class);

    }
}
