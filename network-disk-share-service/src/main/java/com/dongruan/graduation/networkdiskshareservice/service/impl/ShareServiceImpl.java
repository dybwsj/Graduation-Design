package com.dongruan.graduation.networkdiskshareservice.service.impl;

import com.dongruan.graduation.networkdiskshareservice.dao.ShareDao;
import com.dongruan.graduation.networkdiskshareservice.entity.ShareDO;
import com.dongruan.graduation.networkdiskshareservice.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShareServiceImpl implements ShareService {
    @Autowired
    private ShareDao shareDao;

    @Override
    public Integer saveShare(ShareDO shareDO) {
        return shareDao.saveShare(shareDO);
    }

    @Override
    public List<ShareDO> listShareByUserId(String userId) {
        return shareDao.listShareByUserId(userId);
    }

    @Override
    public Integer removeShareByShareIdList(String userId, List<String> shareIdList) {
        return shareDao.removeShareByShareIdList(userId, shareIdList);
    }

    @Override
    public ShareDO getShareByShareId(String shareId) {
        return shareDao.getShareByShareId(shareId);
    }

    @Override
    public Integer updateShare(ShareDO shareDO) {
        return shareDao.updateShare(shareDO);
    }
}
