package com.huatec.hiot_cloud.ui.scan;

import com.huatec.hiot_cloud.ui.base.BaseView;

/**
 * 扫一扫模块view接口
 */
interface ScanView extends BaseView {
    /**
     * 绑定成功后处理
     */
    void bindDeviceSucc();
}
