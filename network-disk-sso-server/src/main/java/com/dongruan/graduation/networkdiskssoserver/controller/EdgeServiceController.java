package com.dongruan.graduation.networkdiskssoserver.controller;

import com.dongruan.graduation.networkdiskcommon.utils.RestAPIResult;
import com.dongruan.graduation.networkdiskssoserver.provider.EdgeServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdgeServiceController {
    @Autowired
    private EdgeServiceProvider edgeServiceProvider;

    /**
     * 生成公钥
     *
     * @author: duyubo
     */
    @RequestMapping(value = "getpublickey", method = RequestMethod.GET)
    public RestAPIResult<String> getPublicKey() throws Exception {
        return edgeServiceProvider.getPublicKeyHandle();
    }

    /**
     * 检查密码格式
     *
     * @author: duyubo
     */
    @RequestMapping(value = "regcheckpwd", method = RequestMethod.POST)
    public RestAPIResult<String> regCheckPwd(@RequestParam("password") String password, @RequestParam("RSAKey") String RSAKey) {
        return edgeServiceProvider.regCheckPwdHandle(password, RSAKey);
    }

}
