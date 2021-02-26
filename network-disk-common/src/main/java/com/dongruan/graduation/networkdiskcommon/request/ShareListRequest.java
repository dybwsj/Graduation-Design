package com.dongruan.graduation.networkdiskcommon.request;

import lombok.Data;

/**
 * 分享列表请求实体
 *
 * @author: duyubo
 */

@Data
public class ShareListRequest {
    private Integer desc;
    private String order;
    private Integer page;
    private String uid;

    @Override
    public String toString() {
        return "ShareListRequest{" +
                "desc=" + desc +
                ", order='" + order + '\'' +
                ", page=" + page +
                ", uid='" + uid + '\'' +
                '}';
    }
}
