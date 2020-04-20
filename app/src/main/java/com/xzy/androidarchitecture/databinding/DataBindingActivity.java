package com.xzy.androidarchitecture.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.xzy.androidarchitecture.R;
import com.xzy.androidarchitecture.bean.Account;

/**
 * dataBinding 的用法
 *
 * @author xzy
 */
public class DataBindingActivity extends AppCompatActivity {
    private ActivityDataBindingBinding dataBinding;
    private Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        account = new Account();
        account.setLevel(100);
        account.setAccount("TEST");
        dataBinding.setActivity(this);
        dataBinding.setAccount(account);
    }

    public void onclick(View view) {
        account.setLevel(account.getLevel() + 1);
//        dataBinding.setAccount(account);
    }
}
