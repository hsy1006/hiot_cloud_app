package com.huatec.hiot_cloud.ui.devicedetail;

import com.huatec.hiot_cloud.data.bean.DeviceDetailBean;
import com.huatec.hiot_cloud.ui.base.BaseView;

/**
 * 设备详情View层接口
 */
interface DeviceDetailView extends BaseView {

    /**
     * 根据设备详情内容显示
     *
     * @param data
     */
    void setDeviceDetail(DeviceDetailBean data);
}
