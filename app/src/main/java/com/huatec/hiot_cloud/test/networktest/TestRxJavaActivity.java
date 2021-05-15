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
import com.huatec.hiot_cloud.data.NetworkService;
import com.huatec.hiot_cloud.utils.Constants;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TestRxJavaActivity extends AppCompatActivity {

    private static final String TAG = "TestRxJavaActivity";

    private Retrofit retrofit;

    private NetworkService service;
    private EditText etLoginPassword;
    private EditText etToken;
    private EditText etChangeEmail;
    private EditText etRegisterUserName;
    private EditText etRegisterPassword;
    private EditText etRegisterEmail;
    private EditText etRegisterUserType;
    private EditText etChangePassword;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_rx_java);

        //取到用户登录密码
        etLoginPassword = findViewById(R.id.et_rxjava_login_password);
        //取到edit_token
        etToken = findViewById(R.id.et_rxjava_token);
        //取到新邮箱
        etChangeEmail = findViewById(R.id.et_rxjava_change_email);
        //取到注册信息
        etRegisterUserName = findViewById(R.id.et_rxjava_regidter_user_name);
        etRegisterPassword = findViewById(R.id.et_rxjava_regidter_password);
        etRegisterEmail = findViewById(R.id.et_rxjava_regidter_email);
        etRegisterUserType = findViewById(R.id.et_rxjava_regidter_user_type);
        //取到新密码
        etChangePassword = findViewById(R.id.et_rxjava_password);

        //创建retrofit
        createRetrofit();

        //登录
        Button btnLogin = findViewById(R.id.btn_rxjava_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login("hsy", etLoginPassword.getText().toString(), Constants.LOGIN_CODE_APP);
            }
        });

        //用户信息
        Button btnUserInfo = findViewById(R.id.btn_rxjava_userinfo);
        btnUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUserInfo(etToken.getText().toString());
            }
        });

        //修改邮箱
        Button btnUpdataEmail = findViewById(R.id.btn_rxjava_update_email);
        btnUpdataEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updataEmail(etToken.getText().toString(),etChangeEmail.getText().toString());
            }
        });

        //注册
        Button btnRegister = findViewById(R.id.btn_rxjava_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

        //修改密码
        Button btnUpdataPassword = findViewById(R.id.btn_rxjava_update_password);
        btnUpdataPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updataPassword(etLoginPassword.getText().toString(),etChangePassword.getText().toString(),etChangePassword.getText().toString(),etToken.getText().toString());
            }
        });

    }

    /**
     * 修改密码
     * @param oldpassword
     * @param newpassword
     * @param confirmpassword
     * @param authorization
     */
    private void updataPassword(String oldpassword, String newpassword, String confirmpassword, String authorization) {
        Observable<ResultBase<String>> observable = service.updatePassword(oldpassword,newpassword,confirmpassword,authorization);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResultBase<String>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResultBase<String> resultBase) {
                        if (resultBase != null && resultBase.getData() != null){
                            Toast.makeText(TestRxJavaActivity.this, resultBase.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                        else if (resultBase != null && !TextUtils.isEmpty(resultBase.getMsg())){
                            Toast.makeText(TestRxJavaActivity.this, resultBase.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                        Log.d(TAG, "onNext: " + resultBase.getMsg());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.getMessage(),e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    /**
     * 注册
     */
    private void register() {
        UserBean userBean = new UserBean();
        userBean.setUsername(etRegisterUserName.getText().toString());
        userBean.setPassword(etRegisterPassword.getText().toString());
        userBean.setEmail(etRegisterEmail.getText().toString());
        userBean.setUserType(etRegisterUserType.getText().toString());
        Observable<ResultBase<UserBean>> observable = service.register(userBean);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResultBase<UserBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResultBase<UserBean> resultBase) {
                        if (resultBase != null && resultBase.getData() != null){
                            Toast.makeText(TestRxJavaActivity.this, resultBase.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                        else if (resultBase != null && !TextUtils.isEmpty(resultBase.getMsg())){
                            Toast.makeText(TestRxJavaActivity.this, resultBase.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                        Log.d(TAG, "onNext: " + resultBase.getMsg());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.getMessage(),e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    /**
     * 修改邮箱
     * @param authorization
     * @param email
     */
    private void updataEmail(String authorization, String email) {
        Observable<ResultBase<String>> observable = service.updateEmail(authorization,email);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResultBase<String>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResultBase<String> resultBase) {
                        if (resultBase != null && resultBase.getData() != null){
                            Toast.makeText(TestRxJavaActivity.this, resultBase.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                        else if (resultBase != null && !TextUtils.isEmpty(resultBase.getMsg())){
                            Toast.makeText(TestRxJavaActivity.this, resultBase.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                        Log.d(TAG, "onNext: " + resultBase.getMsg());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.getMessage(),e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 获取用户信息
     * @param authorization
     */
    private void getUserInfo(String authorization) {
        Observable<ResultBase<UserBean>> observable = service.getUserInfo(authorization);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResultBase<UserBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResultBase<UserBean> resultBase) {
                        if (resultBase != null && resultBase.getData() != null){
                            UserBean userBean = resultBase.getData();
                            String str = String.format("用户：%s，邮箱：%s",userBean.getUsername(),userBean.getEmail());
                            Toast.makeText(TestRxJavaActivity.this, str, Toast.LENGTH_SHORT).show();
                        }
                        else if (resultBase != null && !TextUtils.isEmpty(resultBase.getMsg())){
                            Toast.makeText(TestRxJavaActivity.this, resultBase.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                        Log.d(TAG, "onNext: " + resultBase.getMsg());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.getMessage(),e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 登录
     * @param userName
     * @param password
     * @param loginCode
     */
    private void login(String userName, String password, String loginCode) {
        service.login(userName,password,loginCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultBase<LoginResultDTO>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResultBase<LoginResultDTO> resultBase) {
                        if (resultBase != null && resultBase.getData() != null){
                            LoginResultDTO loginResult = resultBase.getData();
                            etToken.setText(loginResult.getTokenValue());
                            Log.d(TAG, "onNext: " + resultBase.getMsg());
                        }
                        else if (resultBase != null && !TextUtils.isEmpty(resultBase.getMsg())){
                            Log.d(TAG, "onNext: " + resultBase.getMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.getMessage(),e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 创建retrofit
     */
    private void createRetrofit(){
        retrofit = new Retrofit.Builder().baseUrl(NetworkService.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        service = retrofit.create(NetworkService.class);
    }
}
