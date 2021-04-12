package com.huatec.hiot_cloud.test.mvptest.model;


import android.widget.Toast;

import com.huatec.hiot_cloud.base.BasePresenter;
import com.huatec.hiot_cloud.test.mvptest.GuessActivity;

import java.util.Random;

public class GuessPresenter extends BasePresenter<GuessView> {

    public GuessPresenter() {
    }

    public void randomNum(Guess guess) {
        Random random = new Random();
        int realNum = random.nextInt(100);
        guess.setRealNum(realNum);
    }

    public void setGuess(String s, Guess guess) {
        try {
            guess.setYourGuess(Integer.valueOf(s));
        } catch (Exception e) {
            getView().showMessage("输入有误，请重新输入");
        }
    }

    public void makesure(Guess guess) {
        if (guess.getRealNum() == guess.getYourGuess()) {
            getView().showMessage("你猜对了");
        } else if (guess.getRealNum() > guess.getYourGuess()) {
            getView().showMessage("你猜小了，请往大了猜");
        } else {
            getView().showMessage("你猜大了，请往小了猜");
        }
    }

}