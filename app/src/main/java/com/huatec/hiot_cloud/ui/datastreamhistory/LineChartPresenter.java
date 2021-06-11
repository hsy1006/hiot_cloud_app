package com.huatec.hiot_cloud.ui.datastreamhistory;

import com.huatec.hiot_cloud.data.DataManager;
import com.huatec.hiot_cloud.data.bean.UpDataStreamSwitchBean;
import com.huatec.hiot_cloud.test.networktest.ResultBase;
import com.huatec.hiot_cloud.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * 通道历史数据presenter类
 */
class LineChartPresenter extends BasePresenter<LineChartView> {

    @Inject
    DataManager dataManager;

    @Inject
    public LineChartPresenter() {
    }

    /**
     * 获取通道历史数据
     *
     * @param upDataStreamId
     */
    public void getUpDataStreamHistory(String upDataStreamId) {
        subscrib(dataManager.getUpDataStreamHistiry(upDataStreamId), new RequestCallback<ResultBase<List<UpDataStreamSwitchBean>>>() {
            @Override
            public void onNext(ResultBase<List<UpDataStreamSwitchBean>> resultBase) {
                super.onNext(resultBase);
                if (resultBase.getData() != null) {
                    getView().showDataHistory(resultBase.getData());
                }
            }
        });
    }
}
