package com.dongruan.graduation.networkdiskcommon.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 文件夹列表请求实体
 *
 * @author: duyubo
 */

@Data
public class ListFolderRequest implements Serializable {
    private String uid;
    private String parentPath;


    @Override
    public String toString() {
        return "ListFolderRequest{" +
                "uid='" + uid + '\'' +
                ", parentPath='" + parentPath + '\'' +
                '}';
    }
}
