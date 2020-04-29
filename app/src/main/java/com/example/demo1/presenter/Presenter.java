package com.example.demo1.presenter;

interface Presenter<V> {
    void attachView(V mvpView);
    void deachView();
}
