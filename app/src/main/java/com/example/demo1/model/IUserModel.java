package com.example.demo1.model;

import com.example.demo1.back.CallBack;

public interface IUserModel {
    void login(String user, String pwd, CallBack callBack);
}
