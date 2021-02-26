package com.dongruan.graduation.networkdiskapi.service;

import com.dongruan.graduation.networkdiskcommon.response.UserInfoDTO;
import com.dongruan.graduation.networkdiskcommon.utils.RestAPIResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserService {
    @RequestMapping(value = "getuserinfo", method = RequestMethod.POST)
    RestAPIResult<UserInfoDTO> getUserInfo(@RequestParam("userId") String userId);
}
