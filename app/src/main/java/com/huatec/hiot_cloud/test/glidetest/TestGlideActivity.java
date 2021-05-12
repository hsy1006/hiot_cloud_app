package com.huatec.hiot_cloud.test.glidetest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.huatec.hiot_cloud.R;
import com.huatec.hiot_cloud.utils.ImageUtils;

public class TestGlideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_glide);

        final String jpg = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwx2.sinaimg.cn%2Fbmiddle%2Fa908aa2dly1gph2y2ahxdj21410u0jx1.jpg&refer=http%3A%2F%2Fwx2.sinaimg.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1623402321&t=2015267818493c30ce351c70734f4f28";
        final String gif = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fqimg.hxnews.com%2F2018%2F1022%2F1540179856925.gif&refer=http%3A%2F%2Fqimg.hxnews.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1623399947&t=eb3ccd5e122ad98ea69d89943e6b00ec";

        //glide加载按钮
        final ImageView iv = findViewById(R.id.iv_glide_test);
        Button btnGlideLoad = findViewById(R.id.btn_gilde_load_test);
        btnGlideLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(TestGlideActivity.this)
                        .load(jpg)
                        .placeholder(R.drawable.loading)
                        .error(R.drawable.error)
                        .transition(new DrawableTransitionOptions().crossFade(1000))
                        .centerCrop()
                        .into(iv);
            }
        });

        //使用工具类显示图片
        Button btnUtil = findViewById(R.id.btn_gilde_load_util_test);
        btnUtil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageUtils.show(TestGlideActivity.this, iv, gif);
            }
        });
    }
}
