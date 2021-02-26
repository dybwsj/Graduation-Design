package com.dongruan.graduation.networkdiskcommon.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 检查文件夹是否存在请求实体
 *
 * @author: duyubo
 */

@Data
public class CheckDirWhetherRequest implements Serializable {
    private String uid;
    private String dirName;
    private String parentPath;

    @Override
    public String toString() {
        return "CheckDirWhetherRequest{" +
                "uid='" + uid + '\'' +
                ", dirName='" + dirName + '\'' +
                ", parentPath='" + parentPath + '\'' +
                '}';
    }
}
