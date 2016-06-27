package com.tabhost.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dl7.tabhost.library.TabItem;
import com.dl7.tabhost.library.XFragmentTabHost;

public class MoveActivity extends AppCompatActivity {

    private XFragmentTabHost mTabHost;
    String[] mTabTitle = new String[] {"首页", "软件", "游戏", "管理"};
    int[] mImageResId = new int[] {R.drawable.sel_tab_home, R.drawable.sel_tab_app,
            R.drawable.sel_tab_game, R.drawable.sel_tab_mag};
    Class[] mFragClass = new Class[] {TabFragment.class, TabFragment.class,
            TabFragment.class, TabFragment.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);
        _initTabHost();
    }

    private void _initTabHost() {
        mTabHost = (XFragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.relate_tab_content);
        mTabHost.setTabMode(XFragmentTabHost.TabMode.MoveToTop);

        for (int i = 0; i < mFragClass.length; i++) {
            Bundle bundle = new Bundle();
            bundle.putString(TabFragment.FRAG_KEY, mTabTitle[i]);
            mTabHost.addTabItem(new TabItem(mTabTitle[i], mImageResId[i]), mFragClass[i], bundle);
        }
    }
}
