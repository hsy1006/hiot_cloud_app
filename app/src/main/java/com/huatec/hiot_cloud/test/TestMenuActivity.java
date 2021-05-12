package com.huatec.hiot_cloud.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.huatec.hiot_cloud.R;
import com.huatec.hiot_cloud.test.lifecycletest.TestLifeCycleActivity;
import com.huatec.hiot_cloud.test.mvptest.GuessActivity;
import com.huatec.hiot_cloud.test.mvptest.TestMVPActivity;
import com.huatec.hiot_cloud.test.networktest.TestGsonActivity;
import com.huatec.hiot_cloud.test.networktest.TestNetworkPackActivity;
import com.huatec.hiot_cloud.test.networktest.TestOkHttpActivity;
import com.huatec.hiot_cloud.test.networktest.TestRetrofitActivity;
import com.huatec.hiot_cloud.test.networktest.TestRxJavaActivity;

public class TestMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_menu);

        //MVP测试模块跳转
        Button btnTestMvp = findViewById(R.id.btn_test_mvp);
        btnTestMvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestMenuActivity.this,GuessActivity.class);
                startActivity(intent);
            }
        });

        //lifecycle测试模块跳转
        Button btnTestLifeCycle = findViewById(R.id.btn_test_lifecycle);
        btnTestLifeCycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestMenuActivity.this, TestLifeCycleActivity.class);
                startActivity(intent);
            }
        });
        //fragment测试模块跳转
        Button btnTestFragment = findViewById(R.id.btn_test_fragment);
        btnTestFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestMenuActivity.this, TestMVPActivity.class);
                startActivity(intent);
            }
        });
        //okhttp测试模块跳转
        Button btnTestOkHttp = findViewById(R.id.btn_test_okhttp);
        btnTestOkHttp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestMenuActivity.this, TestOkHttpActivity.class);
                startActivity(intent);
            }
        });
        //retrofit测试模块跳转
        Button btnTestRetrofit = findViewById(R.id.btn_test_retrofit);
        btnTestRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestMenuActivity.this, TestRetrofitActivity.class);
                startActivity(intent);
            }
        });
        //gson测试模块跳转
        Button btnTestGson = findViewById(R.id.btn_test_gson);
        btnTestGson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestMenuActivity.this, TestGsonActivity.class);
                startActivity(intent);
            }
        });
        //rxjava测试模块跳转
        Button btnTestRxJava = findViewById(R.id.btn_test_rxjava);
        btnTestRxJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestMenuActivity.this, TestRxJavaActivity.class);
                startActivity(intent);
            }
        });

        //网络封装测试模块跳转
        Button btnTestNetworkPack = findViewById(R.id.btn_test_network_pack);
        btnTestNetworkPack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestMenuActivity.this, TestNetworkPackActivity.class);
                startActivity(intent);
            }
        });
    }
}
