package com.xzy.androidarchitecture.mvc;

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
import com.xzy.androidarchitecture.mvc.model.MVCModel;

import java.util.Random;

/**
 * 使用 MVC 模式实现模拟登录获取账户信息
 *
 * @author xzy
 */
public class MvcActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mInputEt;
    private Button mLoginBtn;
    private TextView mResultTv;
    /**
     * 持有 MVCModel
     */
    private MVCModel mMVCModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        initView();
        mMVCModel = new MVCModel();
    }

    private void initView() {
        mInputEt = findViewById(R.id.et_input);
        mLoginBtn = findViewById(R.id.btn_login);
        mResultTv = findViewById(R.id.tv_result);
        mLoginBtn.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    private void showSuccessPage(Account account) {
        mResultTv.setText("账号:" + account.getAccount() + "| 账号等级:" + account.getLevel());
    }

    private void showFailedPage() {
        mResultTv.setText("获取数据失败");
    }

    @Override
    public void onClick(View v) {
        mMVCModel.getAccountData(mInputEt.getText().toString(), new Callback() {
            @Override
            public void onSuccess(Account account) {
                showSuccessPage(account);
            }

            @Override
            public void onFailed() {
                showFailedPage();
            }
        });
    }
}
