package com.dongruan.graduation.networkdiskcoreservice.service.impl;

import com.dongruan.graduation.networkdiskcoreservice.dao.CapacityDao;
import com.dongruan.graduation.networkdiskcoreservice.entity.CapacityDO;
import com.dongruan.graduation.networkdiskcoreservice.service.CapacityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class CapacityServiceImpl implements CapacityService {
    @Autowired
    private CapacityDao capacityDao;
    @Override
    public CapacityDO getCapacity(String userId) {
        return capacityDao.getCapacity(userId);
    }

    @Override
    public Integer updateCapacity(CapacityDO capacityDO) {
        return capacityDao.updateCapacity(capacityDO);
    }

    @Override
    public Integer saveCapacity(CapacityDO capacityDO) {
        return capacityDao.saveCapacity(capacityDO);
    }
}
