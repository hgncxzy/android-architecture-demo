package com.xzy.androidarchitecture.callback;

import com.xzy.androidarchitecture.bean.Account;

/**
 * @author 002034
 */
public interface Callback {
    void onSuccess(Account account);
    void onFailed();
}
