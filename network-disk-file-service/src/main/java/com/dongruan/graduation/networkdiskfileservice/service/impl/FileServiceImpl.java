package com.dongruan.graduation.networkdiskfileservice.service.impl;

import com.dongruan.graduation.networkdiskfileservice.dao.FileDao;
import com.dongruan.graduation.networkdiskfileservice.entity.FileDO;
import com.dongruan.graduation.networkdiskfileservice.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class FileServiceImpl implements FileService {
    @Autowired
    private FileDao fileDao;
    @Override
    public Integer checkMd5Whether(String fileMd5) {
        return fileDao.checkMd5Whether(fileMd5);
    }

    @Override
    public FileDO getFileByMd5(String fileMd5) {
        return fileDao.getFileByMd5(fileMd5);
    }

    @Override
    public Integer saveFile(FileDO fileDO) {
        return fileDao.saveFile(fileDO);
    }

    @Override
    public FileDO getFileByFid(String fileId) {
        return fileDao.getFileByFid(fileId);
    }
}
