package com.dongruan.graduation.networkdiskshareservice.controller;

import com.dongruan.graduation.networkdiskcommon.response.UserInfoDTO;
import com.dongruan.graduation.networkdiskshareservice.utils.GetUserInfoUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: duyubo
 * @date: 2021年03月02日, 0002 16:19
 * @description:
 */

@Controller
@RequestMapping("/share")
public class pageController {
    @RequestMapping("/manage/{uid}")
    public String share(Model model, @PathVariable("uid") String uid) {
        UserInfoDTO userInfo = GetUserInfoUtils.getUserInfo(uid);
        model.addAttribute("username", userInfo.getUserName());
        model.addAttribute("uid", uid);
        return "share";
    }
}
