package com.dongruan.graduation.networkdiskcommon.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * 上传文件请求实体
 *
 * @author: duyubo
 */

@Data
public class UploadFileRequest implements Serializable {
    private String fid;
    private MultipartFile file;
    private String uid;
    private String parentPath;

    @Override
    public String toString() {
        return "UploadFileRequest{" +
                "fid='" + fid + '\'' +
                ", file=" + file +
                ", uid='" + uid + '\'' +
                ", parentPath='" + parentPath + '\'' +
                '}';
    }
}
