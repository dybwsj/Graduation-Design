package com.dongruan.graduation.networkdiskssoserver.service.impl;

import com.dongruan.graduation.networkdiskcommon.request.ChangePwdRequest;
import com.dongruan.graduation.networkdiskcommon.request.ModifyPassRequest;
import com.dongruan.graduation.networkdiskcommon.response.UserInfoDTO;
import com.dongruan.graduation.networkdiskcommon.utils.IDUtils;
import com.dongruan.graduation.networkdiskcommon.utils.JWTUtils;
import com.dongruan.graduation.networkdiskcommon.utils.MD5Utils;
import com.dongruan.graduation.networkdiskcommon.utils.RSAUtils;
import com.dongruan.graduation.networkdiskcommon.utils.RestAPIResult;
import com.dongruan.graduation.networkdiskssoclient.rpc.Result;
import com.dongruan.graduation.networkdiskssoclient.rpc.SsoUser;
import com.dongruan.graduation.networkdiskssoserver.dao.UserInfoDao;
import com.dongruan.graduation.networkdiskssoserver.entity.UserInfoDO;
import com.dongruan.graduation.networkdiskssoserver.model.User;
import com.dongruan.graduation.networkdiskssoserver.service.UserService;
import com.dongruan.graduation.networkdiskssoserver.util.CookieUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserInfoDao userInfoDao;

	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@Override
	public Result<SsoUser> login(String username, String password, String RSAKey) {
		password = RSAUtils.decryptDataOnJava(password, RSAKey);
		UserInfoDO userInfoDO = userInfoDao.getUserInfoByPassport(username);
		if (userInfoDO != null) {
			if (MD5Utils.verify(password, userInfoDO.getPassword())) {
				return Result.createSuccess(new SsoUser(userInfoDO.getId(), userInfoDO.getUserName()));
			} else {
				return Result.createError("密码错误！");
			}
		}

		return Result.createError("用户不存在");
	}

	@Override
	public RestAPIResult<String> forgetPassword(ModifyPassRequest request) {
		RestAPIResult<String> panResult = new RestAPIResult<>();
		UserInfoDO userInfoDO = userInfoDao.getUserInfoByPassport(request.getUsername());
		if (userInfoDO == null) {
			panResult.error("用户信息不存在");
			return panResult;
		}
		String phoneNum = userInfoDO.getPhone();
		if (phoneNum == null) {
			panResult.error("手机号码不存在");
			return panResult;
		}
		String code = redisTemplate.opsForValue().get(phoneNum);
		if (code != null && Objects.equals(code, request.getVerifyCode())) {
			try {
				updateUser(userInfoDO, request.getNewPassword(), request.getRsaKey());
				panResult.success(null);
				return panResult;
			} catch (Exception e) {
				panResult.error("存入数据库发生错误");
				return panResult;
			}
		} else {
			panResult.error("验证码错误");
			return panResult;
		}
	}

	@Override
	public RestAPIResult<String> modifyPassword(ChangePwdRequest request) {
		RestAPIResult<String> panResult = new RestAPIResult<>();
		UserInfoDO userInfoDO = userInfoDao.getUserInfoByPassport(request.getUsername());
		if (userInfoDO == null) {
			panResult.error("用户信息不存在");
			return panResult;
		}
		String password = RSAUtils.decryptDataOnJava(request.getPassword(), request.getRsaKey());
		if (MD5Utils.verify(password, userInfoDO.getPassword())) {
			try {
				updateUser(userInfoDO, request.getNewPassword(), request.getRsaKey());
				panResult.success(null);
				return panResult;
			} catch (Exception e) {
				panResult.error("存入数据库发生错误");
				return panResult;
			}
		} else {
			panResult.error("密码错误");
			return panResult;
		}
	}

	private void updateUser(UserInfoDO userInfoDO, String password, String RSAKey) throws Exception {
		try {
			String newPassword = RSAUtils.decryptDataOnJava(password, RSAKey);
			String salt = IDUtils.showNextId(new Random().nextInt(30)).toString().substring(0, 16);
			userInfoDO.setPassword(MD5Utils.generate(newPassword, salt));
			userInfoDO.setSalt(salt);
			userInfoDO.setUpdateTime(new Date());
			userInfoDao.updateUserInfo(userInfoDO);
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public RestAPIResult<UserInfoDTO> getUserInfo(@RequestParam("userId") String userId) {
		RestAPIResult<UserInfoDTO> panResult = new RestAPIResult<>();
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		UserInfoDO userInfoDO = userInfoDao.getUserInfoByUserId(userId);
		if (userInfoDO != null) {
			BeanUtils.copyProperties(userInfoDO, userInfoDTO);
		}
		panResult.success(userInfoDTO);
		return panResult;
	}
}
