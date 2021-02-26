package com.dongruan.graduation.networkdiskcommon.request;

import lombok.Data;

/**
 * 分享请求实体
 *
 * @author: duyubo
 */

@Data
public class ShareRequest {
    private String expiration;
    private String flag;
    private String uid;
    private String vids;

    @Override
    public String toString() {
        return "ShareRequest{" +
                "expiration='" + expiration + '\'' +
                ", flag='" + flag + '\'' +
                ", uid='" + uid + '\'' +
                ", vids='" + vids + '\'' +
                '}';
    }
}
