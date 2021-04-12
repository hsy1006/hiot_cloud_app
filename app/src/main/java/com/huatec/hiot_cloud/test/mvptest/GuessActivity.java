package com.huatec.hiot_cloud.test.mvptest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.huatec.hiot_cloud.R;
import com.huatec.hiot_cloud.base.BaseActivity;
import com.huatec.hiot_cloud.test.dagger2test.DaggerPresenterComponentG;
import com.huatec.hiot_cloud.test.dagger2test.DaggerPresenterComponentT;
import com.huatec.hiot_cloud.test.dagger2test.PresenterComponentG;
import com.huatec.hiot_cloud.test.dagger2test.PresenterComponentT;
import com.huatec.hiot_cloud.test.mvptest.model.Guess;

import javax.inject.Inject;

public class GuessActivity extends BaseActivity<GuessView,GuessPresenter> implements GuessView {

    @Inject
    GuessPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getComponent().inject(this);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_guess);
        Button btnRandom = findViewById(R.id.btn_random);
        Button btnMakeSure = findViewById(R.id.btn_makesure);
        TextView tvText = findViewById(R.id.tv_text);
        final EditText etGuess = findViewById(R.id.et_guess);
        final Guess guess = new Guess();
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.randomNum(guess);
            }
        });
        btnMakeSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setGuess(etGuess.getText().toString(),guess);
                presenter.makesure(guess);
            }
        });
    }

    @Override
    public GuessPresenter createPresenter() {
        return presenter;
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 创建注入器
     * @return
     */
    public PresenterComponentG getComponent(){
        return DaggerPresenterComponentG.builder().build();
    }
}
