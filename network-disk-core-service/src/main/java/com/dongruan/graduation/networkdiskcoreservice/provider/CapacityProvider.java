package com.dongruan.graduation.networkdiskcoreservice.provider;

import com.dongruan.graduation.networkdiskcommon.utils.JSONUtils;
import com.dongruan.graduation.networkdiskcommon.utils.RestAPIResult;
import com.dongruan.graduation.networkdiskcoreservice.entity.CapacityDO;
import com.dongruan.graduation.networkdiskcoreservice.service.CapacityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 容量服务数据处理
 *
 * @author: quhailong
 * @date: 2019/9/24
 */
@Component
public class CapacityProvider {
    @Autowired
    private CapacityService capacityService;

    /**
     * 容量查询数据处理
     *
     * @author: quhailong
     * @date: 2019/9/24
     */
    public RestAPIResult<String> useCapacityHandle(String uid) {
        RestAPIResult<String> panResult = new RestAPIResult<>();
        CapacityDO capacityDO = capacityService.getCapacity(uid);
        String useJson = JSONUtils.toJSONString(capacityDO);
        panResult.success(null);
        panResult.setRespData(useJson);
        return panResult;
    }

    /**
     * 初始化容量数据处理
     *
     * @author: quhailong
     * @date: 2019/9/25
     */
    public RestAPIResult<Integer> initCapacityHandle(String uid){
        RestAPIResult<Integer> panResult = new RestAPIResult<>();
        CapacityDO capacityDO = new CapacityDO();
        capacityDO.setUserId(uid);
        capacityDO.setTotalCapacity(5368709120L);
        capacityDO.setUsedCapacity(0L);
        Integer result = capacityService.saveCapacity(capacityDO);
        panResult.success(result);
        return panResult;
    }
}
