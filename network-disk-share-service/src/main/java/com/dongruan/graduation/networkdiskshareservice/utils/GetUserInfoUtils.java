package com.dongruan.graduation.networkdiskshareservice.utils;

import com.dongruan.graduation.networkdiskcommon.response.UserInfoDTO;
import com.dongruan.graduation.networkdiskcommon.utils.HttpClientUtils;
import com.dongruan.graduation.networkdiskcommon.utils.JSONUtils;
import com.dongruan.graduation.networkdiskcommon.utils.RestAPIResult;

import java.util.Map;

/**
 * @author: duyubo
 * @date: 2021年03月02日, 0002 17:17
 * @description:
 */
public class GetUserInfoUtils {
    public static UserInfoDTO getUserInfo(String uid) {
        String getShareUserUrl = "http://localhost:8080/getuserinfo/" + uid;
        String shareUser = HttpClientUtils.HttpGet(getShareUserUrl);
        RestAPIResult restAPIResult = JSONUtils.parseObject(shareUser, RestAPIResult.class);
        return JSONUtils.parseObject(restAPIResult.getRespData().toString(), UserInfoDTO.class);
    }
}
