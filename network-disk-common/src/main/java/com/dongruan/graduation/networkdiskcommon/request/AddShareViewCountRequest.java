package com.dongruan.graduation.networkdiskcommon.request;

import lombok.Data;

/**
 * 增加分享请求实体
 *
 * @author: duyubo
 */

@Data
public class AddShareViewCountRequest {
    private String shareId;


    @Override
    public String toString() {
        return "AddShareViewCountRequest{" +
                "shareId='" + shareId + '\'' +
                '}';
    }
}
