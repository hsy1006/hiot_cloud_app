package com.huatec.hiot_cloud.test.networktest;

import com.huatec.hiot_cloud.data.bean.UserBean;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * retrofit service接口
 */
public interface TestRetrofitService {
    public static final String baseUrl2 = "http://www.baidu.com/";
    public static final String baseUrl = "http://114.67.88.191:8080/";

    /**
     * 百度
     * @return
     */
    @GET("/")
    Call<ResponseBody> test();

    /**
     * 登录方式1
     * @param userName
     * @param password
     * @param loginCode
     * @return
     */
    @POST("/auth/login")
    Call<ResponseBody> login(@Query("username")String userName,
                             @Query("password")String password,
                             @Query("loginCode")String loginCode);

    /**
     * 登录方式1
     * @param userName
     * @param password
     * @param loginCode
     * @return
     */
    @POST("/auth/login")
    @FormUrlEncoded
    Call<ResponseBody> login2(@Field("username") String userName,
                              @Field("password")String password,
                              @Field("loginCode")String loginCode);

    /**
     * 用户信息
     * @param authorization
     * @return
     */
    @GET("/user/one")
    Call<ResponseBody> getUserInfo(@Header("Authorization")String authorization);

    /**
     * 用户信息（Retrofit和gson联合自动解析）
     * @param authorization
     * @return
     */
    @GET("/user/one")
    Call<ResultBase<UserBean>> getUserInfo2(@Header("Authorization")String authorization);

    /**
     * 修改邮箱
     * @param email
     * @param authorization
     * @return
     */
    @PUT("/user/email")
    Call<ResponseBody> updateEmail(@Query("email")String email,
                                   @Header("Authorization")String authorization);

    /**
     * 注册
     * @param userBean
     * @return
     */
    @POST("/user/register")
    Call<ResponseBody> register(@Body UserBean userBean);
}
