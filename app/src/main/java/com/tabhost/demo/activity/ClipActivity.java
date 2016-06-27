package com.tabhost.demo.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.dl7.tabhost.library.TabItem;
import com.dl7.tabhost.library.XFragmentTabHost;
import com.tabhost.demo.R;
import com.tabhost.demo.TabFragment;

public class ClipActivity extends AppCompatActivity {

    private XFragmentTabHost mTabHost;
    String[] mTabTitle = new String[] {"首页", "软件", "游戏", "管理"};
    int[] mImageResId = new int[] {R.drawable.sel_tab_home, R.drawable.sel_tab_app,
            R.drawable.sel_tab_game, R.drawable.sel_tab_mag};
    Class[] mFragClass = new Class[] {TabFragment.class, TabFragment.class,
            TabFragment.class, TabFragment.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip);
        _initTabHost();
    }

    private void _initTabHost() {
        Drawable[] drawables = new Drawable[] { ContextCompat.getDrawable(this, R.mipmap.ic_bg1),
                ContextCompat.getDrawable(this, R.mipmap.ic_bg2),
                ContextCompat.getDrawable(this, R.mipmap.ic_bg3),
                ContextCompat.getDrawable(this, R.mipmap.ic_bg4)};

        mTabHost = (XFragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.relate_tab_content);
        mTabHost.setTabMode(XFragmentTabHost.TabMode.ClipDrawable);

        for (int i = 0; i < mFragClass.length; i++) {
            Bundle bundle = new Bundle();
            bundle.putString(TabFragment.FRAG_KEY, mTabTitle[i]);
            mTabHost.addTabItem(new TabItem(mTabTitle[i], drawables[i], mImageResId[i]),
                    mFragClass[i], bundle);
        }
    }
}
