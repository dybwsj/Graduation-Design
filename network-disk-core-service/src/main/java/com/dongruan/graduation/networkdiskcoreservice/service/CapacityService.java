package com.dongruan.graduation.networkdiskcoreservice.service;

import com.dongruan.graduation.networkdiskcoreservice.entity.CapacityDO;

public interface CapacityService {
    /**
     * 获取容量
     *
     * @author: quhailong
     * @date: 2019/9/24
     */
    CapacityDO getCapacity(String userId);

    /**
     * 修改容量
     *
     * @author: quhailong
     * @date: 2019/9/24
     */
    Integer updateCapacity(CapacityDO capacityDO);

    /**
     * 保存容量
     *
     * @author: quhailong
     * @date: 2019/9/25
     */
    Integer saveCapacity(CapacityDO capacityDO);
}
