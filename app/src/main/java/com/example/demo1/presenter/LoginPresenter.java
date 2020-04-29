package com.example.demo1.presenter;

import com.example.demo1.back.CallBack;
import com.example.demo1.model.UserModel;
import com.example.demo1.view.LoginView;

public class LoginPresenter extends BaseMvpPresenter<LoginView> implements ILoginPresenter {
    private UserModel userModel;

    public LoginPresenter(UserModel userModel) {
        this.userModel = userModel;
    }

    @Override
    public void login(String user, String pwd) {
        checkViewAttach();//检查是否绑定
        //获取View实例
        final LoginView loginView = getMvpView();
        if (user.length() == 0 && pwd.length() == 0) {
            loginView.showToast("账号密码不能为空");
        } else {
            loginView.showLoding("正在登录");
            userModel.login(user, pwd, new CallBack() {
                @Override
                public void onSuccess() {
                    loginView.hideLoding();
                    loginView.showResult("登录成功");
                }

                @Override
                public void onFilure(String msg) {
                    loginView.hideLoding();
                    loginView.showerr(msg);
                }
            });
        }
    }
}
