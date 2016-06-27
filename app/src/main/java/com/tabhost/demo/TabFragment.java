package com.tabhost.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by long on 2016/4/15.
 */
public class TabFragment extends Fragment {

    public static final String FRAG_KEY = "FragKey";
    private TextView mFragTabText;

    private void assignViews(View view) {
        mFragTabText = (TextView) view.findViewById(R.id.frag_tab_text);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, null);
        assignViews(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getArguments() != null) {
            String title = getArguments().getString(FRAG_KEY);
            mFragTabText.setText(title);
        }
    }
}
