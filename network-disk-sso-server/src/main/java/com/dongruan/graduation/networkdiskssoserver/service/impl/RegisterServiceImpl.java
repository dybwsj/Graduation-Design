package com.dongruan.graduation.networkdiskssoserver.service.impl;

import com.dongruan.graduation.networkdiskcommon.request.UserRegisterRequest;
import com.dongruan.graduation.networkdiskcommon.utils.IDUtils;
import com.dongruan.graduation.networkdiskcommon.utils.MD5Utils;
import com.dongruan.graduation.networkdiskcommon.utils.RSAUtils;
import com.dongruan.graduation.networkdiskcommon.utils.RestAPIResult;
import com.dongruan.graduation.networkdiskssoserver.dao.UserInfoDao;
import com.dongruan.graduation.networkdiskssoserver.entity.UserInfoDO;
import com.dongruan.graduation.networkdiskssoserver.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private StringRedisTemplate redisTemplate;
//    @Autowired
//    private FileRemote fileRemote;

    @Override
    public RestAPIResult<String> checkUserNameHandle(String username) {
        RestAPIResult<String> panResult = new RestAPIResult<>();
        if (Pattern.compile("^[a-zA-Z0-9\u4E00-\u9FA5_]+$").matcher(username).matches() && !Pattern.compile("^[0-9]+$").matcher(username).matches()) {
            UserInfoDO userInfoDO = userInfoDao.getUserInfoByUserNameOrPhone(username, null);
            if (userInfoDO != null) {
                panResult.error("用户名已经被使用了，请更换");
                return panResult;
            }
            panResult.success(null);
            return panResult;
        } else {
            panResult.error("用户名仅支持中英文、数字和下划线,且不能为纯数字");
            return panResult;
        }
    }

    @Override
    public RestAPIResult<String> checkPhoneHandle(String phone) {
        RestAPIResult<String> panResult = new RestAPIResult<>();
        if (Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$").matcher(phone).matches()) {
            UserInfoDO userInfoDO = userInfoDao.getUserInfoByUserNameOrPhone(null, phone);
            if (userInfoDO != null) {
                panResult.setRespCode(144);
                panResult.setRespData(null);
                return panResult;
            }
            panResult.success(null);
            return panResult;
        } else {
            panResult.error("手机号码格式不正确");
            return panResult;
        }
    }

    @Override
    public RestAPIResult<String> userRegisterHandle(UserRegisterRequest request) throws Exception {
        RestAPIResult<String> panResult = new RestAPIResult<>();
        String code = redisTemplate.opsForValue().get(request.getPhone());
        if (code != null && Objects.equals(code, request.getVerifyCode())) {
            UserInfoDO userInfoDO = new UserInfoDO();
            String salt = IDUtils.showNextId(new Random().nextInt(30)).toString().substring(0, 16);
            userInfoDO.setPassword(MD5Utils.generate(RSAUtils.decryptDataOnJava(request.getPassword(), request.getRsaKey()), salt));
            userInfoDO.setSalt(salt);
            userInfoDO.setPhone(request.getPhone());
            userInfoDO.setUserName(request.getUsername());
            String userId = IDUtils.showNextId(new Random().nextInt(30)).toString();
            userInfoDO.setUserId(userId);
            userInfoDO.setCreateTime(new Date());
            userInfoDO.setUpdateTime(new Date());
            userInfoDO.setPicLocation("/");
            userInfoDao.saveUserInfo(userInfoDO);
            panResult.success(null);
            return panResult;
        } else {
            panResult.error("验证码错误");
            return panResult;
        }
    }

    @Override
    public RestAPIResult<String> loadImgHandle(String uid) {
        RestAPIResult<String> panResult = new RestAPIResult<>();
        UserInfoDO userInfoDO = userInfoDao.getUserInfoByUserId(uid);
        String picLocation = userInfoDO.getPicLocation();
        if (picLocation.contains("group")) {
            panResult.success("null");
            panResult.setRespData(picLocation);
        } else {
            panResult.success("null");
            panResult.setRespData("group1/M00/00/00/wKhdgF2RromAYwaYAAAJL2wXkdY418_big.jpg");
        }
        return panResult;
    }

    @Override
    public RestAPIResult<String> uploadPicHandle(String uid, MultipartFile file) throws IOException {
        RestAPIResult<String> panResult = new RestAPIResult<>();
//        String picLocation = fileRemote.upload(file).getRespData();
//        UserInfoDO userInfoDO = userInfoDao.getUserInfoByUserId(uid);
//        userInfoDO.setPicLocation(picLocation);
//        userInfoDO.setUpdateTime(new Date());
//        userInfoDao.updateUserInfo(userInfoDO);
//        panResult.success(null);
//        panResult.setDataCode("200");
        return panResult;
    }
}
