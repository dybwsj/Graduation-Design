package com.dongruan.graduation.networkdiskfileservice.provider;

import com.dongruan.graduation.networkdiskcommon.utils.RestAPIResult;
import com.dongruan.graduation.networkdiskfileservice.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Md5数据处理类
 *
 * @author: quhailong
 * @date: 2019/9/25
 */
@Component
public class Md5Provider {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private FileService fileService;

    public RestAPIResult<String> md5CheckHandle(String fid, String md5) {
        RestAPIResult<String> panResult = new RestAPIResult<>();
        redisTemplate.opsForValue().set("fileMd5:" + fid, md5, 259200);
        Integer count = fileService.checkMd5Whether(md5);
        if (count > 0) {
            panResult.success(null);
        } else {
            panResult.error();
        }
        return panResult;
    }
}
