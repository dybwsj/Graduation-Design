package com.dongruan.graduation.networkdiskapi.service;

import com.dongruan.graduation.networkdiskcommon.request.SendSmsRequest;
import com.dongruan.graduation.networkdiskcommon.utils.RestAPIResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface EdgeService {
    @RequestMapping(value = "sendSms", method = RequestMethod.POST)
    RestAPIResult<String> sendSms(@RequestBody SendSmsRequest request);
}
