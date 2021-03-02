package com.dongruan.graduation.networkdiskshareservice.provider;

import com.dongruan.graduation.networkdiskcommon.request.AddShareViewCountRequest;
import com.dongruan.graduation.networkdiskcommon.response.ShareDTO;
import com.dongruan.graduation.networkdiskcommon.response.UserInfoDTO;
import com.dongruan.graduation.networkdiskcommon.utils.HttpClientUtils;
import com.dongruan.graduation.networkdiskcommon.utils.JSONUtils;
import com.dongruan.graduation.networkdiskcommon.utils.RestAPIResult;
import com.dongruan.graduation.networkdiskshareservice.remote.UserRemote;
import com.dongruan.graduation.networkdiskshareservice.utils.GetUserInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.Map;

/**
 * 页面跳转数据处理类
 *
 * @author: quhailong
 * @date: 2019/9/27
 */
@Component
public class PageProvider {
    @Autowired
    private ShareProvider shareProvider;

    /**
     * 查看分享页面数据处理
     *
     * @author: quhailong
     * @date: 2019/9/27
     */
    public String sHandle(Model model, String shareId, String uid) {
        Map<String, Object> respMsg = shareProvider.getShareUserHandle(shareId).getRespMap();
        UserInfoDTO shareUserInfoDTO = JSONUtils.parseObject((String) respMsg.get("userinfo"), UserInfoDTO.class);
        UserInfoDTO userInfo = GetUserInfoUtils.getUserInfo(uid);
        if (shareUserInfoDTO == null) {
            model.addAttribute("name", userInfo.getUserName());
            return "sError";
        } else if (shareUserInfoDTO.getId().toString().equals(uid)) {
            model.addAttribute("name", shareUserInfoDTO.getUserName());
            return "share";
        }
        ShareDTO shareDTO = JSONUtils.parseObject((String) respMsg.get("share"), ShareDTO.class);
        if (shareDTO.getExpiration() != null && shareDTO.getExpiration().getTime() - (new Date().getTime()) < 0) {
            return "sError";
        }
        model.addAttribute("name", userInfo.getUserName());
        model.addAttribute("shareUser", shareUserInfoDTO.getUserName());
        if (shareDTO.getMultiWhether() == 1) {
            model.addAttribute("shareName", shareDTO.getTheme() + "等文件");
        } else {
            model.addAttribute("shareName", shareDTO.getTheme() + "文件");
        }
        AddShareViewCountRequest addShareViewCountRequest = new AddShareViewCountRequest();
        addShareViewCountRequest.setShareId(shareId);
        shareProvider.addShareViewCountHandle(addShareViewCountRequest);
        model.addAttribute("shareId", shareDTO.getShareId());
        return "s";
    }

}
