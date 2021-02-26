package com.dongruan.graduation.networkdiskcommon.request;

import lombok.Data;

/**
 * 修改密码请求实体
 *
 * @author: duyubo
 */

@Data
public class ChangePwdRequest {
//    private String token;
//    private String uid;
    private String username;
    private String password;
    private String newPassword;
    private String rsaKey;

    @Override
    public String toString() {
        return "ChangePwdRequest{" +
//                "token='" + token + '\'' +
//                ", uid='" + uid + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", rsaKey='" + rsaKey + '\'' +
                '}';
    }
}
