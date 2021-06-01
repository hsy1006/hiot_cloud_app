package com.huatec.hiot_cloud.utils;

/**
 * 常量类
 */
public class Constants {
    /**
     *碎片数
     */
    public static final int MAIN_FRAGMENT_COUNT = 4;
    /**
     * 主页viewpager的“消息”fragment选择序号
     */
    public static final int MAIN_VIEWPAGER_INDEX_MESSAGE = 0;
    /**
     * 主页viewpager的“设备”fragment选择序号
     */
    public static final int MAIN_VIEWPAGER_INDEX_EQUIPMENT = 1;
    /**
     * 主页viewpager的“场景”fragment选择序号
     */
    public static final int MAIN_VIEWPAGER_INDEX_SCENE = 2;
    /**
     * 主页viewpager的“我的”fragment选择序号
     */
    public static final int MAIN_VIEWPAGER_INDEX_MINE= 3;
    /**
     * APP登录的logincode
     */
    public static final String LOGIN_CODE_APP = "app";
    /**
     * 用户类型
     */
    public static final String USER_TYPE_NORMAI = "1";
    /**
     * 服务端返回消息状态属性成功
     */
    public static final int MSG_STATUS_SUCESS = 1;
    /**
     * 网络访问失败吐司
     */
    public static final String TOAST_MSG_NETWORK_FAIL = "当前网络无法访问，请稍后再试";
    /**
     * form-data类型
     */
    public static final String MULTIPART_FORM_DATA = "multipart/form-data";
    /**
     * token失效
     */
    public static final int MSG_STATUS_TOKEN_OUT = -100;
    /**
     * 设备已绑定状态
     */
    public static final int DEVICE_STATUS_BINDED = 1;
    /**
     * 设备未绑定状态
     */
    public static final int DEVICE_STATUS_UNBINDED = 0;
    /**
     * 设备id
     */
    public static final String INTENT_EXTRA_DEVICE_ID = "DEVICE_ID";
    /**
     * 设备已激活
     */
    public static final String DEVICE_STATUS_ACTIVITY = "1";
    /**
     * 设备未激活
     */
    public static final String DEVICE_STATUS_UN_ACTIVITY = "0";
    /**
     * 通到类型-默认全部
     */
    public static final String DATA_STREAM_TYPE_ALL = "0";
    /**
     * 通到类型-数值类型
     */
    public static final String DATA_STREAM_TYPE_VALUE = "1";
    /**
     * 通到类型-开关类型
     */
    public static final String DATA_STREAM_TYPE_SWITCH = "2";
    /**
     * 通到类型-GPS类型
     */
    public static final String DATA_STREAM_TYPE_GPS = "3";
    /**
     * 通到类型-文本类型
     */
    public static final String DATA_STREAM_TYPE_TEXT = "4";
    /**
     * 开关状态-开
     */
    public static final int SWITCH_STATUS_ON = 1;
    /**
     * 开关状态-关
     */
    public static final int SWITCH_STATUS_OFF = 0;
}
