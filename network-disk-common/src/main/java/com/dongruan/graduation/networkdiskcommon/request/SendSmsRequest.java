package com.dongruan.graduation.networkdiskcommon.request;

import lombok.Data;

/**
 * 发送短信请求实体
 *
 * @author: duyubo
 */

@Data
public class SendSmsRequest {
     private String sid;
     private String token;
     private String appid;
     private String templateid;
     private String param;
     private String mobile;
     private String uid;

    @Override
    public String toString() {
        return "SendSmsRequest{" +
                "sid='" + sid + '\'' +
                ", token='" + token + '\'' +
                ", appid='" + appid + '\'' +
                ", templateid='" + templateid + '\'' +
                ", param='" + param + '\'' +
                ", mobile='" + mobile + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }
}
