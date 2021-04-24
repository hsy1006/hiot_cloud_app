package com.huatec.hiot_cloud.test.networktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.huatec.hiot_cloud.R;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TestRetrofitActivity extends AppCompatActivity {

    private static final String TAG = "TestRetrofitActivity";
    private Retrofit retrofit;
    private TestRetrofitService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_retrofit);

        //创建retrofit和setvice对象
        createRetrofit();

        //百度
        Button btnTest = findViewById(R.id.btn_retrofit_enqueue);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test();
            }
        });

        //登录
        Button btnLogin = findViewById(R.id.btn_retrofit_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                login("hsy","abc123456","app");
                login2("hsy","abc123456","app");
            }
        });

        //用户信息
        Button btnUserInfo = findViewById(R.id.btn_retrofit_userinfo);
        btnUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUserInfo("85f6ffa4a846439286c09a6aca505aa3_f85b02c30d784443aaf690a212132d01_use");
            }
        });

        //修改邮箱
        Button btnUpdateEmail = findViewById(R.id.btn_retrofit_update_email);
        btnUpdateEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateEmail("85f6ffa4a846439286c09a6aca505aa3_f85b02c30d784443aaf690a212132d01_use",
                        "1281068244email@qq.com");
            }
        });

        //注册
        Button btnRegister = findViewById(R.id.btn_retrofit_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    /**
     * 注册用户
     */
    private void register() {
        UserBean userBean = new UserBean();
        userBean.setUsername("hsy1006");
        userBean.setPassword("abc123456");
        userBean.setEmail("hsy1006@qq.com");
        userBean.setUserType("1");
        Call<ResponseBody> call = service.register(userBean);
        callEnqueue(call);
    }

    /**
     * 修改邮箱
     * @param authorization
     * @param email
     */
    private void updateEmail(String authorization, String email) {
        Call<ResponseBody> call = service.updateEmail(email,authorization);
        callEnqueue(call);
    }

    /**
     * 获取用户信息
     * @param authorization
     */
    private void getUserInfo(String authorization) {
        Call<ResponseBody> call = service.getUserInfo(authorization);
        callEnqueue(call);
    }


    /**
     * 登录
     * @param userName
     * @param password
     * @param loginCode
     */
    private void login(String userName, String password, String loginCode) {
        Call<ResponseBody> call = service.login(userName,password,loginCode);
        callEnqueue(call);
    }

    /**
     * 登录方式2
     * @param userName
     * @param password
     * @param loginCode
     */
    private void login2(String userName, String password, String loginCode) {
        Call<ResponseBody> call = service.login2(userName,password,loginCode);
        callEnqueue(call);
    }

    /**
     * 百度
     */
    private void test() {
        Call<ResponseBody> call = service.test();
        callEnqueue(call);
    }

    /**
     * callEnqueue方法
     * @param call
     */
    private void callEnqueue(Call<ResponseBody> call) {
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.d(TAG, "onResponse: " + response.body().string());
                } catch (IOException e) {
                    Log.e(TAG, "onResponse: " + e.getMessage(), e);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage(), t);
            }
        });
    }

    private void createRetrofit(){
        retrofit = new Retrofit.Builder().baseUrl(TestRetrofitService.baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build();
        service = retrofit.create(TestRetrofitService.class);
    }
}
