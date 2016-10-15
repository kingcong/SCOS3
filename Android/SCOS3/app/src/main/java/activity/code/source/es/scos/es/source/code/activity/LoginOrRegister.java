package activity.code.source.es.scos.es.source.code.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import activity.code.source.es.scos.R;
import activity.code.source.es.scos.es.source.code.model.User;

public class LoginOrRegister extends AppCompatActivity implements View.OnClickListener{

    private EditText et_username;
    private EditText et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_register);

        initLoginOrRegister();
    }

    // 初始化登录或者注册
    private void initLoginOrRegister() {
        // 用户名和密码
        et_username = (EditText)findViewById(R.id.et_username);
        et_password = (EditText)findViewById(R.id.et_password);

        // 登录
        Button loginButton = (Button)findViewById(R.id.bt_loginbtn);
        loginButton.setOnClickListener(this);

        // 注册
        Button registerButton = (Button) findViewById(R.id.bt_registerbtn);
        registerButton.setOnClickListener(this);

        // 返回
        Button backButton = (Button)findViewById(R.id.bt_backbtn);
        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_loginbtn:
                handleLoginEvent();
                break;
            case R.id.bt_registerbtn:
                handleRegisterEvent();
                break;
            case R.id.bt_backbtn:
                handleBackEvent();
                break;
        }
    }

    // 处理登录事件
    private void handleLoginEvent() {

        String username = et_username.getText().toString();
        String password = et_password.getText().toString();

        String reg = "^[a-zA-Z0-9\u4e00-\u9fa5]+$";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher("需要去匹配该正则的string字符串");
        boolean b = matcher.matches();

        // 这里处理输入框的逻辑处理
        if (username.isEmpty()) {
            et_username.setError("输入内容不符合规则");
            return;
        } else if (password.isEmpty()) {
            et_password.setError("输入内容不符合规则");
            return;
        }

        System.out.println("开始登录。。。。。");

        User loginUser = new User();
        loginUser.setUserName(username);
        loginUser.setPassword(password);
        loginUser.setOldUser(true);

        Intent intent = new Intent();
        intent.putExtra("activity.code.source.es.scos.es.source.code.activity.MainScreen","LoginSuccess");
        Bundle bundle = new Bundle();
        bundle.putSerializable("loginUser",loginUser);
        intent.putExtras(bundle);
        intent.setClass(this,MainScreen.class);
        startActivity(intent);
    }

    // 处理注册事件
    private void handleRegisterEvent() {

        String username = et_username.getText().toString();
        String password = et_password.getText().toString();

        // 这里处理输入框的逻辑处理
        if (username.isEmpty()) {
            et_username.setError("输入内容不符合规则");
            return;
        } else if (password.isEmpty()) {
            et_password.setError("输入内容不符合规则");
            return;
        }

        System.out.println("开始注册。。。。。");

        User loginUser = new User();
        loginUser.setUserName(username);
        loginUser.setPassword(password);
        loginUser.setOldUser(false);

        Intent intent = new Intent();
        intent.putExtra("activity.code.source.es.scos.es.source.code.activity.MainScreen","RegisterSuccess");
        Bundle bundle = new Bundle();
        bundle.putSerializable("loginUser",loginUser);
        intent.putExtras(bundle);
        intent.setClass(this,MainScreen.class);
        startActivity(intent);
    }

    // 处理返回事件
    private void handleBackEvent() {
        System.out.println("返回上一级。。。。。");
        Intent intent = new Intent();
        intent.putExtra("activity.code.source.es.scos.es.source.code.activity.MainScreen","Return");
        intent.setClass(this,MainScreen.class);
        startActivity(intent);
    }

    // 判断输入是否合法
    private boolean isInputMatchs(String inputStr,String regex) {
        String reg = "^[a-zA-Z0-9\u4e00-\u9fa5]+$";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(inputStr);
        boolean b = matcher.matches();
        return b;
    }
}
