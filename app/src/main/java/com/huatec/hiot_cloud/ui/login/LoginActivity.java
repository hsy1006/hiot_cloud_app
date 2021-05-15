package com.huatec.hiot_cloud.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.huatec.hiot_cloud.R;
import com.huatec.hiot_cloud.ui.main.MainActivity;
import com.huatec.hiot_cloud.utils.Constants;
import com.huatec.hiot_cloud.utils.ValidatorUtils;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //如果校验成功，则保存登录状态，跳转到列表界面
                if (ValidateSucc()){
                    //保存登录状态

                    //跳转列表界面
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    /**
     * 校验用户输入
     * @return
     */
    private boolean ValidateSucc() {
        TextInputEditText tiptetEmail = findViewById(R.id.tiptet_email);
        TextInputEditText tiptetPassword = findViewById(R.id.tiptet_password);
        String email = tiptetEmail.getText().toString();
        String password = tiptetPassword.getText().toString();

        //校验邮箱非空
        if (TextUtils.isEmpty(email)){
            tiptetEmail.setError("邮箱不能为空，请重新输入");
            return false;
        }
        //校验邮箱合规
        if (!ValidatorUtils.isEmail(email)){
            tiptetEmail.setError("邮箱输入不正确，请重新输入");
            return false;
        }

        //校验密码非空
        if (TextUtils.isEmpty(password)){
            tiptetPassword.setError("密码不能为空，请重新输入");
            return false;
        }

        //校验密码合规
        if (!ValidatorUtils.isPassword(password)){
            tiptetPassword.setError("密码输入不正确，请重新输入");
            return false;
        }

        //校验用户名密码正确

        return true;
    }
}
