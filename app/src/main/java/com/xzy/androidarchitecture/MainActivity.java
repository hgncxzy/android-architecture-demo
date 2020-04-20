package com.xzy.androidarchitecture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xzy.androidarchitecture.databinding.DataBindingActivity;
import com.xzy.androidarchitecture.mvc.MvcActivity;
import com.xzy.androidarchitecture.mvp.MvpActivity;
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
    private Button mNormalBtn;
    private Button mMvclBtn;
    private Button mMvpBtn;
    private Button mMvvmBtn;
    private Button mDatabinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mNormalBtn = findViewById(R.id.btn_normal);
        mMvclBtn = findViewById(R.id.btn_mvc);
        mMvpBtn = findViewById(R.id.btn_mvp);
        mMvvmBtn = findViewById(R.id.btn_mvvm);
        mDatabinding = findViewById(R.id.btn_databinding);

        mNormalBtn.setOnClickListener(this);
        mMvclBtn.setOnClickListener(this);
        mMvpBtn.setOnClickListener(this);
        mMvvmBtn.setOnClickListener(this);
        mDatabinding.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_normal:
                startActivity(new Intent(this, NormalActivity.class));
                break;
            case R.id.btn_mvc:
                startActivity(new Intent(this, MvcActivity.class));
                break;
            case R.id.btn_mvp:
                startActivity(new Intent(this, MvpActivity.class));
                break;
            case R.id.btn_databinding:
                startActivity(new Intent(this, DataBindingActivity.class));
                break;
            default:
                break;
        }

    }
}
