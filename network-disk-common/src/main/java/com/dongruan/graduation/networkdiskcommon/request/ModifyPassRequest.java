package com.dongruan.graduation.networkdiskcommon.request;

import lombok.Data;

/**
 * 忘记密码修改密码请求实体
 *
 * @author: duyubo
 */

@Data
public class ModifyPassRequest {
    private String username;
    private String newPassword;
    private String verifyCode;
    private String rsaKey;

    @Override
    public String toString() {
        return "ModifyPassRequest{" +
                "username='" + username + '\'' +
                ", password='" + newPassword + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                ", rsaKey='" + rsaKey + '\'' +
                '}';
    }
}
