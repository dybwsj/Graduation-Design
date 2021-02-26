package com.dongruan.graduation.networkdiskssoserver.service;

import com.dongruan.graduation.networkdiskcommon.request.UserRegisterRequest;
import com.dongruan.graduation.networkdiskcommon.utils.RestAPIResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface RegisterService {
    /**
     * 用户名查重数据处理
     *
     * @author: quhailong
     * @date: 2019/9/25
     */
    RestAPIResult<String> checkUserNameHandle(String username);

    /**
     * 手机号查重数据处理
     *
     * @author: quhailong
     * @date: 2019/9/25
     */
    RestAPIResult<String> checkPhoneHandle(String phone);

    /**
     * 用户注册数据处理
     *
     * @author: quhailong
     * @date: 2019/9/25
     */
    RestAPIResult<String> userRegisterHandle(UserRegisterRequest request) throws Exception;

    /**
     * 加载用户头像数据处理
     *
     * @author: quhailong
     * @date: 2019/9/26
     */
    RestAPIResult<String> loadImgHandle(String uid);

    /**
     * 上传用户头像数据处理
     *
     * @author: quhailong
     * @date: 2019/9/26
     */
    RestAPIResult<String> uploadPicHandle(String uid, MultipartFile file) throws IOException;
}
