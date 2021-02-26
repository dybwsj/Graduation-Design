package com.dongruan.graduation.networkdiskcommon.request;

import lombok.Data;

/**
 * 注册发送短信请求实体
 *
 * @author: duyubo
 */

@Data
public class RegPhoneSendRequest {
    private String phoneNum;
    private String verfyCode;
    private String vcodestr;

    @Override
    public String toString() {
        return "RegPhoneSendRequest{" +
                "phoneNum='" + phoneNum + '\'' +
                ", verfyCode='" + verfyCode + '\'' +
                ", vcodestr='" + vcodestr + '\'' +
                '}';
    }
}
