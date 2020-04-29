package com.example.demo1.view;

public interface LoginView extends BaseMvpView {
    //成功返回信息
    void showResult(String msg);

    //Toast信息
    void showToast(String msg);

}
