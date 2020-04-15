package com.xzy.androidarchitecture.normal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.xzy.androidarchitecture.R;
import com.xzy.androidarchitecture.bean.Account;
import com.xzy.androidarchitecture.callback.Callback;

import java.util.Random;

/**
 * 没有任何框架实现模拟登录获取账户信息
 *
 * @author xzy
 */
public class NormalActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mInputEt;
    private Button mLoginBtn;
    private TextView mResultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        initView();
    }

    private void initView() {
        mInputEt = findViewById(R.id.et_input);
        mLoginBtn = findViewById(R.id.btn_login);
        mResultTv = findViewById(R.id.tv_result);
        mLoginBtn.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    private void onSuccessPage(Account account) {
        mResultTv.setText("账号:" + account.getAccount() + "| 账号等级:" + account.getLevel());
    }

    private void onFailedPage() {
        mResultTv.setText("获取数据失败");
    }

    private void getAccountData(String input, Callback callback) {
        Random random = new Random();
        boolean success = random.nextBoolean();
        if (success) {
            Account account = new Account();
            account.setAccount(input);
            account.setLevel(100);
            callback.onSuccess(account);
        } else {
            callback.onFailed();
        }
    }

    @Override
    public void onClick(View v) {
        getAccountData(mInputEt.getText().toString(), new Callback() {
            @Override
            public void onSuccess(Account account) {
                onSuccessPage(account);
            }

            @Override
            public void onFailed() {
                onFailedPage();
            }
        });
    }
}
