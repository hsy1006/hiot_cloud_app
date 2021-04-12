package com.huatec.hiot_cloud.test.mvptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.huatec.hiot_cloud.R;
import com.huatec.hiot_cloud.base.BaseActivity;
import com.huatec.hiot_cloud.test.mvptest.model.Guess;
import com.huatec.hiot_cloud.test.mvptest.model.GuessPresenter;
import com.huatec.hiot_cloud.test.mvptest.model.GuessView;
import com.huatec.hiot_cloud.test.mvptest.model.TestPresenter;
import com.huatec.hiot_cloud.test.mvptest.model.TestView;

import java.util.Random;

public class GuessActivity extends BaseActivity<GuessView,GuessPresenter> implements GuessView {

    private GuessPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        presenter = new GuessPresenter();
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
}
