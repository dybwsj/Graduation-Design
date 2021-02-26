package com.dongruan.graduation.networkdiskcommon.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 复制或移动文件请求实体
 *
 * @author: duyubo
 */

@Data
public class CopyOrMoveFileRequest implements Serializable {
    private String uid;
    private String vids;
    private String dest;
    private String opera;


    @Override
    public String toString() {
        return "CopyOrMoveFileRequest{" +
                "uid='" + uid + '\'' +
                ", vids='" + vids + '\'' +
                ", dest='" + dest + '\'' +
                ", opera='" + opera + '\'' +
                '}';
    }
}
