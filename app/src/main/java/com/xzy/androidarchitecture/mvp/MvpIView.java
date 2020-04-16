package com.xzy.androidarchitecture.mvp;

import com.xzy.androidarchitecture.bean.Account;

/**
 * @author xzy
 */
public interface MvpIView {

    String getInput();

    void showSuccessPage(Account account);

    void showFailedPage();
}
