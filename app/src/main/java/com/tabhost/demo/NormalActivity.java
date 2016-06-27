package com.tabhost.demo;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NormalActivity extends AppCompatActivity {

    private FragmentTabHost mTabHost;
    private String[] mTabTitle = new String[] {"首页", "软件", "游戏", "管理"};
    private int[] mImageResId = new int[] {R.drawable.sel_tab_home, R.drawable.sel_tab_app,
            R.drawable.sel_tab_game, R.drawable.sel_tab_mag};
    private Class[] mFragClass = new Class[] {TabFragment.class, TabFragment.class,
            TabFragment.class, TabFragment.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        _initTabHost();
    }

    private void _initTabHost() {
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.relate_tab_content);

        for (int i = 0; i < mFragClass.length; i++) {
            Bundle bundle = new Bundle();
            bundle.putString(TabFragment.FRAG_KEY, mTabTitle[i]);
            mTabHost.addTab(mTabHost.newTabSpec(mTabTitle[i]).setIndicator(_getIndicator(i)), mFragClass[i], bundle);
        }
    }

    private View _getIndicator(int index) {
        View view = LayoutInflater.from(this).inflate(R.layout.tab_indicator, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.tab_imageview);
        TextView title = (TextView) view.findViewById(R.id.tab_textview);
        imageView.setImageResource(mImageResId[index]);
        title.setText(mTabTitle[index]);
        return view;
    }
}
