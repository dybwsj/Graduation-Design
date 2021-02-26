package com.dongruan.graduation.networkdiskcoreservice.service.impl;

import com.dongruan.graduation.networkdiskcoreservice.dao.VirtualAddressDao;
import com.dongruan.graduation.networkdiskcoreservice.entity.VirtualAddressDO;
import com.dongruan.graduation.networkdiskcoreservice.service.VirtualaddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VirtualaddressServiceImpl implements VirtualaddressService {
    @Autowired
    private VirtualAddressDao virtualaddressDao;

    @Override
    public List<VirtualAddressDO> listVirtualAddress(String userId, String parentPath, Integer addrType) {
        return virtualaddressDao.listVirtualAddress(userId, parentPath, addrType);
    }

    @Override
    public List<VirtualAddressDO> listVirtualAddressLikeFileName(String userId, String fileName) {
        return virtualaddressDao.listVirtualAddressLikeFileName(userId, fileName);
    }

    @Override
    public Integer checkVirtualAddress(String userId, String parentPath, Integer addrType, String fileName) {
        return virtualaddressDao.checkVirtualAddress(userId, parentPath, addrType, fileName);
    }

    @Override
    public VirtualAddressDO getVirtualAddress(String uuid) {
        return virtualaddressDao.getVirtualAddress(uuid);
    }

    @Override
    public Integer updateVirtualAddress(VirtualAddressDO virtualAddressDO) {
        return virtualaddressDao.updateVirtualAddress(virtualAddressDO);
    }

    @Override
    public List<VirtualAddressDO> listVirtualAddressLikeFilePath(String userId, String parentPath) {
        return virtualaddressDao.listVirtualAddressLikeFilePath(userId, parentPath);
    }

    @Override
    public Integer removeVirtualAddress(String uuid) {
        return virtualaddressDao.removeVirtualAddress(uuid);
    }

    @Override
    public Integer saveVirtualAddress(VirtualAddressDO virtualAddressDO) {
        return virtualaddressDao.saveVirtualAddress(virtualAddressDO);
    }
}
