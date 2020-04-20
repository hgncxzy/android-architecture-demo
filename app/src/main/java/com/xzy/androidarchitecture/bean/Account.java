package com.xzy.androidarchitecture.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.xzy.androidarchitecture.BR;

/**
 * @author : xzy
 */
public class Account extends BaseObservable {
    private String account;
    private int level;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Bindable
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        notifyPropertyChanged(BR.level);
    }
}
