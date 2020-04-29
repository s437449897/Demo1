package com.example.demo1.model;

import android.os.Handler;
import android.os.Looper;

import com.example.demo1.back.CallBack;

public class UserModel implements IUserModel {
    private Handler handler=new Handler(Looper.getMainLooper());
    @Override
    public void login(final String user, final String pwd, final CallBack callBack) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (user.equals("123456") && pwd.equals("123456")){
                    callBack.onSuccess();
                }else {
                    callBack.onFilure("账号或密码错误");
                }
            }
        },2000 );
    }
}
