package com.dongruan.graduation.networkdiskapi.service;

import com.dongruan.graduation.networkdiskcommon.request.CheckDirWhetherRequest;
import com.dongruan.graduation.networkdiskcommon.request.CreateDirRequest;
import com.dongruan.graduation.networkdiskcommon.request.CreateVirtualAddressRequest;
import com.dongruan.graduation.networkdiskcommon.response.VirtualAddressDTO;
import com.dongruan.graduation.networkdiskcommon.utils.RestAPIResult;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface CoreService {
    @RequestMapping(value = "core/createdir", method = RequestMethod.POST)
    RestAPIResult<String> createDir(@RequestBody CreateDirRequest request);

    @RequestMapping(value = "core/checkdirwhether", method = RequestMethod.GET)
    RestAPIResult<Integer> checkDirWhether(@SpringQueryMap CheckDirWhetherRequest request);

    @RequestMapping(value = "core/createvirtualaddress", method = RequestMethod.POST)
    RestAPIResult<Integer> createVirtualAddress(@RequestBody CreateVirtualAddressRequest request);

    @RequestMapping(value = "core/getfilenamebyvid", method = RequestMethod.GET)
    RestAPIResult<String> getFileNameByVid(@RequestParam("vid") String vid, @RequestParam("uid") String uid);

    @RequestMapping(value = "core/getvirtualaddress", method = RequestMethod.GET)
    RestAPIResult<VirtualAddressDTO> getVirtualaddress(@RequestParam("vid") String vid, @RequestParam("uid") String uid);

    @RequestMapping(value = "core/initcapacity", method = RequestMethod.POST)
    RestAPIResult<Integer> initCapacity(@RequestParam("userId") String userId);
}
