package com.dongruan.graduation.networkdiskssoserver.service;

import com.dongruan.graduation.networkdiskcommon.request.ChangePwdRequest;
import com.dongruan.graduation.networkdiskcommon.request.ModifyPassRequest;
import com.dongruan.graduation.networkdiskcommon.response.UserInfoDTO;
import com.dongruan.graduation.networkdiskcommon.utils.RestAPIResult;
import com.dongruan.graduation.networkdiskssoclient.rpc.Result;
import com.dongruan.graduation.networkdiskssoclient.rpc.SsoUser;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户服务接口
 * 
 * @author Joe
 */
public interface UserService {
	
	/**
	 * 登录
	 * 
	 * @param username
	 *            登录名
	 * @param password
	 *            密码
	 * @return
	 */
	Result<SsoUser> login(String username, String password, String RSAKey);

	RestAPIResult<String> forgetPassword(ModifyPassRequest request);

	RestAPIResult<String> modifyPassword(ChangePwdRequest request);

	RestAPIResult<UserInfoDTO> getUserInfo(@RequestParam("userId") String userId);

}
