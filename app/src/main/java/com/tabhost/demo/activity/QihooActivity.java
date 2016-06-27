package com.tabhost.demo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dl7.tabhost.library.TabItem;
import com.dl7.tabhost.library.XFragmentTabHost;
import com.tabhost.demo.R;
import com.tabhost.demo.TabFragment;

public class QihooActivity extends AppCompatActivity {

    private XFragmentTabHost mTabHost;
    String[] mTabTitle = new String[] {"首页", "游戏", "软件", "应用圈", "管理"};
    int[] mImageResId = new int[] {R.drawable.sel_360_home, R.drawable.sel_360_game, R.drawable.sel_360_software,
            R.drawable.sel_360_app, R.drawable.sel_360_mag};
    Class[] mFragClass = new Class[] {TabFragment.class, TabFragment.class,
            TabFragment.class, TabFragment.class, TabFragment.class};

    private void initTabHost() {

        mTabHost = (XFragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.relate_tab_content);
        mTabHost.setTabMode(XFragmentTabHost.TabMode.Ripple);
        mTabHost.setTextActiveColor(Color.WHITE);
        mTabHost.setTextInactiveColor(Color.GRAY);
//        mTabHost.setFrontColor(Color.RED);
//        mTabHost.setBehindColor(Color.GREEN);

        for (int i = 0; i < mFragClass.length; i++) {
            Bundle bundle = new Bundle();
            bundle.putString(TabFragment.FRAG_KEY, mTabTitle[i]);
            mTabHost.addTabItem(new TabItem(mTabTitle[i], mImageResId[i]),
                    mFragClass[i], bundle);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qihoo);
        initTabHost();
    }
}
