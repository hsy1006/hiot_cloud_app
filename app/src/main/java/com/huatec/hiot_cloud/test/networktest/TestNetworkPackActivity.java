package com.huatec.hiot_cloud.test.networktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.huatec.hiot_cloud.R;
import com.huatec.hiot_cloud.data.DataManager;
import com.huatec.hiot_cloud.data.NetworkService;
import com.huatec.hiot_cloud.ui.base.BaseActivity;
import com.huatec.hiot_cloud.ui.base.BasePresenter;
import com.huatec.hiot_cloud.utils.Constans;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.Query;

/**
 * 网络封装层测试类
 */
public class TestNetworkPackActivity extends BaseActivity implements TestNetworkPackView{

    private static final String TAG = "TestNetworkPackActivity";
    private EditText etLoginPassword;
    private EditText etToken;
    private EditText etChangeEmail;
    private EditText etRegisterUserName;
    private EditText etRegisterPassword;
    private EditText etRegisterEmail;
    private EditText etRegisterUserType;
    private EditText etChangePassword;

    @Inject
    DataManager dataManager;

    @Inject
    TestNetworkPackPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_network_pack);

        //取到用户登录密码
        etLoginPassword = findViewById(R.id.et_network_pack_login_password);
        //取到edit_token
        etToken = findViewById(R.id.et_network_pack_token);
        //取到新邮箱
        etChangeEmail = findViewById(R.id.et_network_pack_change_email);
        //取到注册信息
        etRegisterUserName = findViewById(R.id.et_network_pack_regidter_user_name);
        etRegisterPassword = findViewById(R.id.et_network_pack_regidter_password);
        etRegisterEmail = findViewById(R.id.et_network_pack_regidter_email);
        //取到新密码
        etChangePassword = findViewById(R.id.et_network_pack_password);

        //登录
        Button btnLogin = findViewById(R.id.btn_network_pack_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login("hsy", etLoginPassword.getText().toString());
//                login("hsy", etLoginPassword.getText().toString());
            }
        });

        //用户信息
        Button btnUserInfo = findViewById(R.id.btn_network_pack_userinfo);
        btnUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getUserInfo(etToken.getText().toString());
            }
        });

        //修改邮箱
        Button btnUpdataEmail = findViewById(R.id.btn_network_pack_update_email);
        btnUpdataEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updataEmail(etToken.getText().toString(),etChangeEmail.getText().toString());
            }
        });

        //注册
        Button btnRegister = findViewById(R.id.btn_network_pack_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.register(etRegisterUserName.getText().toString(),etRegisterPassword.getText().toString(),etRegisterEmail.getText().toString());
            }
        });

        //修改密码
        Button btnUpdataPassword = findViewById(R.id.btn_network_pack_update_password);
        btnUpdataPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updataPassword(etLoginPassword.getText().toString(),etChangePassword.getText().toString(),etChangePassword.getText().toString(),etToken.getText().toString());
            }
        });
    }

    @Override
    public BasePresenter createPresenter() {
        return presenter;
    }

    @Override
    public void injectIndependies() {
        getActivityComponent().inject(this);
    }

    /**
     * 登录
     * @param userName
     * @param password
     */
    private void login(String userName, String password) {

//        dataManager.login(userName,password)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .unsubscribeOn(Schedulers.io())
//                .subscribe(new Observer<ResultBase<LoginResultDTO>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(ResultBase<LoginResultDTO> resultBase) {
//                        if (resultBase != null && resultBase.getData() != null){
//                            etToken.setText(resultBase.getData().getTokenValue());
//                            Toast.makeText(TestNetworkPackActivity.this, resultBase.getMsg(), Toast.LENGTH_SHORT).show();
//                            Log.d(TAG, "onNext: " + resultBase.getMsg());
//                        }
//                        else if (resultBase != null && !TextUtils.isEmpty(resultBase.getMsg())){
//                            Toast.makeText(TestNetworkPackActivity.this, resultBase.getMsg(), Toast.LENGTH_SHORT).show();
//                            Log.d(TAG, "onNext: " + resultBase.getMsg());
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e(TAG, "onError: " + e.getMessage(),e);
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }

    @Override
    public void showToken(String token) {
        etToken.setText(token);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(TestNetworkPackActivity.this, message, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "showMessage: " + message);
    }
}
