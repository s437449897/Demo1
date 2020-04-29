package com.example.demo1.view;

public interface BaseMvpView {
    //显示等待框
    void showLoding(String msg);
    //隐藏等待框
    void hideLoding();
    //错误信息
    void showerr(String err);
}