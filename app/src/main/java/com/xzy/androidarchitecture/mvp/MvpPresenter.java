package com.xzy.androidarchitecture.mvp;

import com.xzy.androidarchitecture.bean.Account;
import com.xzy.androidarchitecture.callback.Callback;

/**
 * @author xzy
 */
public class MvpPresenter {
    private MvpIView mMvpIView;
    private MvpModel mMvpModel;

    public MvpPresenter(MvpIView mMvpIView) {
        this.mMvpIView = mMvpIView;
        mMvpModel = new MvpModel();
    }

    public void getAccountData(String input) {
        mMvpModel.getAccountData(input, new Callback() {
            @Override
            public void onSuccess(Account account) {
                mMvpIView.showSuccessPage(account);
            }

            @Override
            public void onFailed() {
                mMvpIView.showFailedPage();
            }
        });
    }
}
