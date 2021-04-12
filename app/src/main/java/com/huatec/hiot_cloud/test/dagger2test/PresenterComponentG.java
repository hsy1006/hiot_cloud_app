package com.huatec.hiot_cloud.test.dagger2test;

import com.huatec.hiot_cloud.test.mvptest.GuessActivity;

import dagger.Component;

/**
 * 测试注入器接口
 */
@Component(modules = TestModule.class)
public interface PresenterComponentG {
    void inject(GuessActivity guessActivity);
}
