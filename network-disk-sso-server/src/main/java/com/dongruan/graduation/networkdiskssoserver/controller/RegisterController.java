package com.dongruan.graduation.networkdiskssoserver.controller;

import com.dongruan.graduation.networkdiskcommon.request.ChangePwdRequest;
import com.dongruan.graduation.networkdiskcommon.request.UserRegisterRequest;
import com.dongruan.graduation.networkdiskcommon.utils.RestAPIResult;
import com.dongruan.graduation.networkdiskssoserver.service.RegisterService;
import com.dongruan.graduation.networkdiskssoserver.validator.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 注册服务
 *
 * @author: quhailong
 * @date: 2019/9/25
 */
@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    /**
     * 用户名查重
     *
     * @author: 杜宇博
     */

    @GetMapping(value = "/checkUsername")
    public RestAPIResult<String> checkUserName(@RequestParam("userName") String userName) {
        return registerService.checkUserNameHandle(userName);
    }

    /**
     * 手机号查重
     *
     * @author: duyubo
     */
    @GetMapping(value = "checkPhone")
    public RestAPIResult<String> checkPhone(@RequestParam("phone") @Phone String phone) {
        return registerService.checkPhoneHandle(phone);
    }

    /**
     * 用户注册
     *
     * @author: duyubo
     */
    @PostMapping(value = "register")
    public RestAPIResult<String> register(@RequestBody UserRegisterRequest request) throws Exception {
        return registerService.userRegisterHandle(request);
    }

    /**
     * 注册发送短信
     *
     * @author: quhailong
     * @date: 2019/9/26
     */
//    @RequestMapping(value = "regphonesend", method = RequestMethod.POST)
//    public RestAPIResult<String> regPhoneSend(@RequestBody RegPhoneSendRequest request) {
//        logger.info("注册发送短信请求URL：{}", httpServletRequest.getRequestURL());
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        logger.info("注册发送短信数据处理开始,request:{}", request);
//        RestAPIResult<String> result = registerService.regPhoneSendHandle(request);
//        logger.info("注册发送短信数据处理结束,result:{}", result);
//        stopWatch.stop();
//        logger.info("注册发送短信调用时间,millies:{}", stopWatch.getTotalTimeMillis());
//        return result;
//    }

    /**
     * 修改密码
     *
     * @author: quhailong
     * @date: 2019/9/26
     */
//    @RequestMapping(value = "changepwd", method = RequestMethod.POST)
//    public RestAPIResult<String> changePwd(@RequestBody ChangePwdRequest request) {
//        logger.info("修改密码请求URL：{}", httpServletRequest.getRequestURL());
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        logger.info("修改密码数据处理开始,request:{}", request);
//        RestAPIResult<String> result = registerService.changePwdHandle(request);
//        logger.info("修改密码数据处理结束,result:{}", result);
//        stopWatch.stop();
//        logger.info("修改密码调用时间,millies:{}", stopWatch.getTotalTimeMillis());
//        return result;
//    }

    /**
     * 加载用户头像
     *
     * @author: quhailong
     * @date: 2019/9/26
     */
    @GetMapping(value = "/loadImg")
    public RestAPIResult<String> loadImg(@RequestParam("uid") String uid) {
        return registerService.loadImgHandle(uid);
    }

    /**
     * 上传用户头像
     *
     * @author: quhailong
     * @date: 2019/9/26
     */
    @PostMapping(value = "/uploadPic")
    public RestAPIResult<String> uploadPic(@RequestParam("uid") String uid, @RequestParam("file") MultipartFile file) throws IOException {
        RestAPIResult<String> result = registerService.uploadPicHandle(uid, file);
        return result;
    }

}
