package com.xzy.androidarchitecture.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.xzy.androidarchitecture.R;
import com.xzy.androidarchitecture.databinding.ActivityMvvmBinding;

/**
 * 使用 mvvm 模式实现数据获取
 *
 * @author xzy
 */
public class MvvmActivity extends AppCompatActivity {
    private ActivityMvvmBinding binding;
    private MvvmViewModel mvvmViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        mvvmViewModel = new MvvmViewModel(getApplication());
        binding.setViewModel(mvvmViewModel);
    }
}
