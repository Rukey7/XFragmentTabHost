package com.tabhost.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tabhost.demo.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnNormal;
    private Button mBtnMove;
    private Button mBtnRipple;
    private Button mBtnClip;

    private void assignViews() {
        mBtnNormal = (Button) findViewById(R.id.btn_normal);
        mBtnMove = (Button) findViewById(R.id.btn_move);
        mBtnRipple = (Button) findViewById(R.id.btn_ripple);
        mBtnClip = (Button) findViewById(R.id.btn_clip);
        mBtnNormal.setOnClickListener(this);
        mBtnMove.setOnClickListener(this);
        mBtnRipple.setOnClickListener(this);
        mBtnClip.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_normal:
                startActivity(new Intent(MainActivity.this, NormalActivity.class));
                break;
            case R.id.btn_clip:
                startActivity(new Intent(MainActivity.this, ClipActivity.class));
                break;
            case R.id.btn_ripple:
                startActivity(new Intent(MainActivity.this, QihooActivity.class));
                break;
            case R.id.btn_move:
                startActivity(new Intent(MainActivity.this, MoveActivity.class));
                break;
        }
    }
}
