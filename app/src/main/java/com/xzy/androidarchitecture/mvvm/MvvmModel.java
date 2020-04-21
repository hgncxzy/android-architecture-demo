package com.xzy.androidarchitecture.mvvm;

import com.xzy.androidarchitecture.bean.Account;
import com.xzy.androidarchitecture.callback.Callback;

import java.util.Random;

/**
 * @author xzy
 */
public class MvvmModel {
    
    public void getAccountData(String input, Callback callback) {
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
}
