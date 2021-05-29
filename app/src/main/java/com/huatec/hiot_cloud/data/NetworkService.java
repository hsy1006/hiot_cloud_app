package com.huatec.hiot_cloud.data;

import com.huatec.hiot_cloud.test.networktest.LoginResultDTO;
import com.huatec.hiot_cloud.test.networktest.ResultBase;
import com.huatec.hiot_cloud.test.networktest.UserBean;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * 网络请求接口
 */
public interface NetworkService {
//    public static final String baseUrl = "http://www.baidu.com/";
    public static final String baseUrl = "http://114.67.88.191:8080/";

    /**
     * 登录
     * @param userName
     * @param password
     * @param loginCode
     * @return
     */
    @POST("/auth/login")
    Observable<ResultBase<LoginResultDTO>> login(@Query("username")String userName,
                                                 @Query("password")String password,
                                                 @Query("loginCode")String loginCode);

    /**
     * 退出登录
     *
     * @param authorization
     * @return
     */
    @POST("/auth/logout")
    Observable<ResultBase> logout(@Header("Authorization") String authorization);

    /**
     * 用户信息
     * @param authorization
     * @return
     */
    @GET("/user/one")
    Observable<ResultBase<UserBean>> getUserInfo(@Header("Authorization")String authorization);

    /**
     * 修改邮箱
     * @param email
     * @param authorization
     * @return
     */
    @PUT("/user/email")
    Observable<ResultBase<String>> updateEmail(@Header("Authorization")String authorization,
                                               @Query("email")String email);

    /**
     * 注册
     * @param userBean
     * @return
     */
    @POST("/user/register")
    Observable<ResultBase<UserBean>> register(@Body UserBean userBean);

    /**
     * 修改密码
     * @param oldpassword
     * @param newpassword
     * @param confirmpassword
     * @param authorization
     * @return
     */
    @PUT("/user/password")
    Observable<ResultBase<String>> updatePassword(@Query("oldpassword")String oldpassword,
                                                  @Query("newpassword")String newpassword,
                                                  @Query("confirmpassword")String confirmpassword,
                                                  @Header("Authorization")String authorization);

    /**
     * 上传头像
     *
     * @param file
     * @param authorization
     * @return
     */
    @POST("/user/img")
    @Multipart
    Observable<ResultBase<String>> uploadImage(@Part MultipartBody.Part file,
                                               @Header("Authorization") String authorization);
}
