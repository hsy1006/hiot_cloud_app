package com.huatec.hiot_cloud.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.huatec.hiot_cloud.ui.login.LoginActivity;

import butterknife.ButterKnife;

/**
 * fragment模板类
 */
public abstract class BaseFragment<V extends BaseView, P extends BasePresenter<V>> extends Fragment implements BaseView {
    private P presenter;

    public abstract P createPresenter();

    /**
     * UI注入引用的对象
     */
    public abstract void injectDependencise();

    public abstract View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = initView(inflater,container,savedInstanceState);
        injectDependencise();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        presenter = createPresenter();
        if(presenter != null){
            presenter.setView((V)this);
        }
        ButterKnife.bind(this, view);
        super.onViewCreated(view,savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(presenter != null){
            presenter.destory();
        }
    }

    /**
     * 打开新界面，关闭本界面
     *
     * @param cls
     */
    protected void startActivity(Class<?> cls) {
        Intent intent = new Intent(getActivity(), cls);
        startActivity(intent);
        getActivity().finish();
    }

    /**
     * 打开新界面，保留本界面
     *
     * @param cls
     */
    protected void startActivityWithoutFinish(Class<?> cls) {
        Intent intent = new Intent(getActivity(), cls);
        startActivity(intent);
    }

    @Override
    public void tokenOut() {
        startActivity(LoginActivity.class);
    }
}
