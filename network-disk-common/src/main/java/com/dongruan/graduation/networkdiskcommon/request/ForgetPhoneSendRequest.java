package com.dongruan.graduation.networkdiskcommon.request;

import lombok.Data;

/**
 * 忘记密码发送短信请求实体
 *
 * @author: duyubo
 */

@Data
public class ForgetPhoneSendRequest {
    private String username;
    private String VerificationCode;
    private String vcodestr;


    @Override
    public String toString() {
        return "ForgetPhoneSendRequest{" +
                "username='" + username + '\'' +
                ", verfyCode='" + VerificationCode + '\'' +
                ", vcodestr='" + vcodestr + '\'' +
                '}';
    }
}
