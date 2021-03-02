package com.dongruan.graduation.networkdiskssoserver.controller;

import com.dongruan.graduation.networkdiskcommon.request.ChangePwdRequest;
import com.dongruan.graduation.networkdiskcommon.request.ModifyPassRequest;
import com.dongruan.graduation.networkdiskcommon.response.UserInfoDTO;
import com.dongruan.graduation.networkdiskcommon.utils.RestAPIResult;
import com.dongruan.graduation.networkdiskssoserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 密码服务
 *
 * @author: duyubo
 */
@RestController
public class PasswordController {
    @Autowired
    private UserService userService;

    /**
     * 忘记密码
     *
     * @author: quhailong
     * @date: 2019/9/26
     */
    @RequestMapping(value = "forgetPassword", method = RequestMethod.POST)
    public RestAPIResult<String> forgetPhoneSend(@RequestBody ModifyPassRequest request) {
        return userService.forgetPassword(request);
    }

    /**
     * 手机号/用户名校验
     *
     * @author: quhailong
     * @date: 2019/9/26
     */
//    @RequestMapping(value = "checkphonesend", method = {RequestMethod.GET})
//    public RestAPIResult<String> checkPhoneSend(@RequestParam("username") String username) {
//        logger.info("手机号/用户名校验服务请求URL：{}", httpServletRequest.getRequestURL());
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        logger.info("手机号/用户名校验数据处理开始,username:{}", username);
//        RestAPIResult<String> result = passwordService.checkPhoneSendHandle(username);
//        logger.info("手机号/用户名校验数据处理结束,result:{}", result);
//        stopWatch.stop();
//        logger.info("手机号/用户名校验调用时间,millies:{}", stopWatch.getTotalTimeMillis());
//        return result;
//    }

    /**
     * 修改密码
     *
     * @author: duyubo
     */
    @PostMapping(value = "modifyPassword")
    public RestAPIResult<String> modifyPassword(@RequestBody ChangePwdRequest request) {
        return userService.modifyPassword(request);
    }

    @GetMapping("getuserinfo/{userId}")
    public RestAPIResult<UserInfoDTO> getUserInfo(@PathVariable("userId") String userId) {
        return userService.getUserInfo(userId);
    }
}
