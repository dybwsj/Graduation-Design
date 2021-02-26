package com.dongruan.graduation.networkdiskcommon.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 创建文件夹请求实体
 *
 * @author: duyubo
 */

@Data
public class CreateDirRequest implements Serializable {
    private String dirName;
    private String uid;
    private String parentPath;


    @Override
    public String toString() {
        return "CreateDirRequest{" +
                "dirName='" + dirName + '\'' +
                ", uid='" + uid + '\'' +
                ", parentPath='" + parentPath + '\'' +
                '}';
    }
}
