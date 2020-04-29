package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demo1.model.UserModel;
import com.example.demo1.presenter.LoginPresenter;
import com.example.demo1.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {
    private LoginPresenter loginPresenter;
    private ProgressDialog progressDialog;
    private EditText et1, et2;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loginPresenter = initPresenter();
        loginPresenter.attachView(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.login(et1.getText().toString().trim(), et2.getText().toString().trim());
            }
        });
    }

    public LoginPresenter initPresenter() {
        return new LoginPresenter(new UserModel());
    }

    private void initView() {
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        btn = findViewById(R.id.btn);
        progressDialog = new ProgressDialog(this);
    }

    @Override
    public void showResult(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoding(String msg) {
        progressDialog.setMessage(msg);
        if (!progressDialog.isShowing())
            progressDialog.show();
    }

    @Override
    public void hideLoding() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }

    @Override
    public void showerr(String err) {
        Toast.makeText(getApplicationContext(), err, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.deachView();
    }
}
