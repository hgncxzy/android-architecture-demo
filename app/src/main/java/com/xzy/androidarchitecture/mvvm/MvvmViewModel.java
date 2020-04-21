package com.xzy.androidarchitecture.mvvm;

import android.app.Application;
import android.telecom.Call;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.xzy.androidarchitecture.BR;
import com.xzy.androidarchitecture.bean.Account;
import com.xzy.androidarchitecture.callback.Callback;

import java.util.Random;

/**
 * @author xzy
 */
public class MvvmViewModel extends BaseObservable {
    private String result;
    private String userInput;
    private MvvmModel mvvmModel;

    public MvvmViewModel(Application application) {
        mvvmModel = new MvvmModel();
    }

    public void getData(View view) {
        mvvmModel.getAccountData(userInput, new Callback() {
            @Override
            public void onSuccess(Account account) {
                setResult(account.getAccount() + "|" + account.getLevel());
            }

            @Override
            public void onFailed() {
                setResult("数据获取失败");
            }
        });
    }

    @Bindable
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
        notifyPropertyChanged(BR.result);
    }

    @Bindable
    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
        notifyPropertyChanged(BR.userInput);
    }
}
