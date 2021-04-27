package com.huatec.hiot_cloud.test.networktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huatec.hiot_cloud.R;

import java.io.IOException;
import java.lang.reflect.Type;

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
    private Gson gson = new Gson();
    private EditText etToken;
    private TextView tvUserName;
    private TextView tvPassword;
    private TextView tvEmial;
    private TextView tvUserType;
    private EditText etChangeEmail;
    private EditText etRegisterUserName;
    private EditText etRegisterPassword;
    private EditText etRegisterEmail;
    private EditText etRegisterUserType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_retrofit);

        //取到edit_token
        etToken = findViewById(R.id.et_token_retrofit);
        //取到用户信息
        tvUserName = findViewById(R.id.tv_user_name);
        tvPassword = findViewById(R.id.tv_password);
        tvEmial = findViewById(R.id.tv_email);
        tvUserType = findViewById(R.id.tv_user_type);
        //取到新邮箱
        etChangeEmail = findViewById(R.id.et_change_email);
        //取到注册信息
        etRegisterUserName = findViewById(R.id.et_regidter_user_name);
        etRegisterPassword = findViewById(R.id.et_regidter_password);
        etRegisterEmail = findViewById(R.id.et_regidter_email);
        etRegisterUserType = findViewById(R.id.et_regidter_user_type);

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
                getUserInfo(etToken.getText().toString());
            }
        });

        //修改邮箱
        Button btnUpdateEmail = findViewById(R.id.btn_retrofit_update_email);
        btnUpdateEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateEmail(etToken.getText().toString(),etChangeEmail.getText().toString());
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
        userBean.setUsername(etRegisterUserName.getText().toString());
        userBean.setPassword(etRegisterPassword.getText().toString());
        userBean.setEmail(etRegisterEmail.getText().toString());
        userBean.setUserType(etRegisterUserType.getText().toString());
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
//        callEnqueue(call);
        callEnqueueUserInfo(call);

////        Retrofit和gson联合自动解析
//        Call<ResultBase<UserBean>> call = service.getUserInfo2(authorization);
//        call.enqueue(new Callback<ResultBase<UserBean>>() {
//            @Override
//            public void onResponse(Call<ResultBase<UserBean>> call, Response<ResultBase<UserBean>> response) {
//                ResultBase<UserBean> resultBase =response.body();
//                if (resultBase != null && resultBase.getData() != null) {
//                    resultBase.getData();
//                    String str = resultBase.getData().getUsername() + "," + resultBase.getData().getEmail();
//                    Toast.makeText(TestRetrofitActivity.this, str, Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResultBase<UserBean>> call, Throwable t) {
//
//            }
//        });
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
//        callEnqueue(call);
        callEnqueueLogin2(call);
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
    private void callEnqueueUserInfo(Call<ResponseBody> call) {
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
//                    Log.d(TAG, "onResponse: " + response.body().string());
                    Type type = new TypeToken<ResultBase<UserBean>>(){}.getType();
                    ResultBase<UserBean> resultBase = gson.fromJson(response.body().string(),type);
                    if (resultBase != null && resultBase.getData() != null){
                        UserBean userBean = resultBase.getData();
                        String username = resultBase.getData().getUsername();
                        String email = resultBase.getData().getEmail();
                        String password = resultBase.getData().getPassword();
                        String usertype = resultBase.getData().getUserType();
                        tvEmial.setText("邮箱：" + email);
                        tvPassword.setText("密码：" + password);
                        tvUserName.setText("用户名：" + username);
                        tvUserType.setText("用户类型：" + usertype);
                        String str = String.format("用户名：%s，密码：%s，邮箱：%s，用户类型：%s",
                                userBean.getUsername(),userBean.getPassword(),userBean.getEmail(),userBean.getUserType());
                        Toast.makeText(TestRetrofitActivity.this, str, Toast.LENGTH_SHORT).show();
                    }
                    else if (resultBase !=null && resultBase.getMsg() != null){
                        Toast.makeText(TestRetrofitActivity.this, resultBase.getMsg(), Toast.LENGTH_SHORT).show();
                    }
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
    private void callEnqueueLogin2(Call<ResponseBody> call) {
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
//                    Log.d(TAG, "onResponse: " + response.body().string());
                    Type type = new TypeToken<ResultBase<LoginResultDTO>>(){}.getType();
                    ResultBase<LoginResultDTO> loginResultDTO = null;
                    loginResultDTO = gson.fromJson(response.body().string(),type);
                    if (loginResultDTO != null && loginResultDTO.getData() != null){
                        String token = loginResultDTO.getData().getTokenValue();
                        etToken.setText(token);
                    }
                    else if (loginResultDTO !=null && loginResultDTO.getMsg() != null){
                        Toast.makeText(TestRetrofitActivity.this, loginResultDTO.getMsg(), Toast.LENGTH_SHORT).show();
                    }
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
