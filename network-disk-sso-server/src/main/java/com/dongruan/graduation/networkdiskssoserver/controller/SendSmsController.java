package com.dongruan.graduation.networkdiskssoserver.controller;

import com.dongruan.graduation.networkdiskcommon.utils.RestAPIResult;
import com.dongruan.graduation.networkdiskssoserver.provider.SendSmsProvider;
import com.dongruan.graduation.networkdiskssoserver.validator.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.Map;

@RestController
public class SendSmsController {
    @Autowired
    private SendSmsProvider sendSmsProvider;


    /**
     * 发送短信
     *
     * @author: duyubo
     */
    @PostMapping(value = "sendSms")
    public RestAPIResult<String> sendSms(@RequestParam("phone") String phone) {
        return sendSmsProvider.sendSmsHandle(phone);
    }
}
