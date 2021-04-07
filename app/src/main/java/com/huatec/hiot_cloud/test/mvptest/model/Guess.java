package com.huatec.hiot_cloud.test.mvptest.model;

import java.io.Serializable;

public class Guess implements Serializable {
    private int realNum;
    private int yourGuess;

    public int getRealNum() {
        return realNum;
    }

    public void setRealNum(int realNum) {
        this.realNum = realNum;
    }

    public int getYourGuess() {
        return yourGuess;
    }

    public void setYourGuess(int yourGuess) {
        this.yourGuess = yourGuess;
    }
}
