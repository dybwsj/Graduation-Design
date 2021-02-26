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
    @RequestMapping(value = "createdir", method = RequestMethod.POST)
    RestAPIResult<String> createDir(@RequestBody CreateDirRequest request);

    @RequestMapping(value = "checkdirwhether", method = RequestMethod.GET)
    RestAPIResult<Integer> checkDirWhether(@SpringQueryMap CheckDirWhetherRequest request);

    @RequestMapping(value = "createvirtualaddress", method = RequestMethod.POST)
    RestAPIResult<Integer> createVirtualAddress(@RequestBody CreateVirtualAddressRequest request);

    @RequestMapping(value = "getfilenamebyvid", method = RequestMethod.GET)
    RestAPIResult<String> getFileNameByVid(@RequestParam("vid") String vid, @RequestParam("uid") String uid);

    @RequestMapping(value = "getvirtualaddress", method = RequestMethod.GET)
    RestAPIResult<VirtualAddressDTO> getVirtualaddress(@RequestParam("vid") String vid, @RequestParam("uid") String uid);

    @RequestMapping(value = "initcapacity", method = RequestMethod.POST)
    RestAPIResult<Integer> initCapacity(@RequestParam("userId") String userId);
}
