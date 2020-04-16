package com.xzy.androidarchitecture.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.xzy.androidarchitecture.R;
import com.xzy.androidarchitecture.bean.Account;

/**
 * 使用 MVP 模式模拟登陆获取用户信息
 *
 * @author xzy
 */
public class MvpActivity extends AppCompatActivity implements MvpIView, View.OnClickListener {
    private EditText mInputEt;
    private Button mLoginBtn;
    private TextView mResultTv;
    /**
     * 持有 presenter
     */
    private MvpPresenter mMvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        initView();
        mMvpPresenter = new MvpPresenter(this);
    }

    private void initView() {
        mInputEt = findViewById(R.id.et_input);
        mLoginBtn = findViewById(R.id.btn_login);
        mResultTv = findViewById(R.id.tv_result);
        mLoginBtn.setOnClickListener(this);
    }

    @Override
    public String getInput() {
        return mInputEt.getText().toString();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void showSuccessPage(Account account) {
        mResultTv.setText("账号:" + account.getAccount() + "| 账号等级:" + account.getLevel());
    }

    @Override
    public void showFailedPage() {
        mResultTv.setText("获取数据失败");
    }

    @Override
    public void onClick(View v) {
        mMvpPresenter.getAccountData(getInput());
    }
}
