package com.xzy.androidarchitecture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xzy.androidarchitecture.normal.NormalActivity;

/**
 * 程序入口
 *
 * @author xzy
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * 开始按钮
     */
    private Button mStarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mStarBtn = findViewById(R.id.btn_start);
        mStarBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, NormalActivity.class));
    }
}
