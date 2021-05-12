package com.huatec.hiot_cloud.test.networktest;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.huatec.hiot_cloud.data.DataManager;
import com.huatec.hiot_cloud.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * 网络封装测试MVP架构的presenter层接口
 */
public class TestNetworkPackPresenter extends BasePresenter<TestNetworkPackView> {

    @Inject
    DataManager dataManager;

    @Inject
    public TestNetworkPackPresenter() {
    }

    /**
     * 登录
     * @param userName
     * @param password
     */
    public void login(String userName, String password){
        subscrib(dataManager.login(userName, password), new RequestCallback<ResultBase<LoginResultDTO>>() {
            @Override
            public void onNext(ResultBase<LoginResultDTO> resultBase) {
                if (resultBase != null && resultBase.getData() != null){
                    getView().showToken(resultBase.data.getTokenValue());
                    getView().showMessage(resultBase.getMsg());
                }
                else if (resultBase != null && !TextUtils.isEmpty(resultBase.getMsg())){
                    getView().showMessage(resultBase.getMsg());
                }
            }
        });
    }

    /**
     * 获取用户信息
     * @param authorization
     */
    public void getUserInfo(String authorization){
        subscrib(dataManager.getUserInfo(authorization), new RequestCallback<ResultBase<UserBean>>() {
            @Override
            public void onNext(ResultBase<UserBean> resultBase) {
                if (resultBase != null && resultBase.getData() != null){
                    UserBean userBean = resultBase.getData();
                    String str = String.format("用户：%s，邮箱：%s",userBean.getUsername(),userBean.getEmail());
                    getView().showMessage(resultBase.getMsg() + "\n" + str);
                }
                else if (resultBase != null && !TextUtils.isEmpty(resultBase.getMsg())){
                    getView().showMessage(resultBase.getMsg());
                }
            }
        });
    }

    /**
     * 修改邮箱
     * @param authorization
     * @param email
     */
    public void updataEmail(String authorization, String email){
        subscrib(dataManager.updateEmail(authorization, email), new RequestCallback<ResultBase<String>>() {
            @Override
            public void onNext(ResultBase<String> resultBase) {
                if (resultBase != null && resultBase.getData() != null){
                    getView().showMessage(resultBase.getMsg());
                }
                else if (resultBase != null && !TextUtils.isEmpty(resultBase.getMsg())){
                    getView().showMessage(resultBase.getMsg());
                }
            }
        });
    }

    /**
     * 注册
     * @param userName
     * @param password
     * @param email
     */
    public void register(String userName, String password, String email){
        subscrib(dataManager.register(userName, password, email), new RequestCallback<ResultBase<UserBean>>() {
            @Override
            public void onNext(ResultBase<UserBean> resultBase) {
                if (resultBase != null && resultBase.getData() != null){
                    getView().showMessage(resultBase.getMsg());
                }
                else if (resultBase != null && !TextUtils.isEmpty(resultBase.getMsg())){
                    getView().showMessage(resultBase.getMsg());
                }
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
    public void updataPassword(String oldpassword, String newpassword, String confirmpassword, String authorization){
        subscrib(dataManager.updatePassword(oldpassword, newpassword, confirmpassword, authorization), new RequestCallback<ResultBase<String>>() {
            @Override
            public void onNext(ResultBase<String> resultBase) {
                if (resultBase != null && resultBase.getData() != null){
                    getView().showMessage(resultBase.getMsg());
                }
                else if (resultBase != null && !TextUtils.isEmpty(resultBase.getMsg())){
                    getView().showMessage(resultBase.getMsg());
                }
            }
        });
    }

}
