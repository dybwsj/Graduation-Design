package com.dongruan.graduation.networkdiskssoserver.provider;

import com.dongruan.graduation.networkdiskcommon.utils.RSAUtils;
import com.dongruan.graduation.networkdiskcommon.utils.RestAPIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * 边缘服务数据处理类
 *
 * @author: quhailong
 * @date: 2019/9/26
 */
@Component
public class EdgeServiceProvider {

    public RestAPIResult<String> regCheckPwdHandle(String password, String RSAKey) {
        RestAPIResult<String> panResult = new RestAPIResult<>();
        try {
            password = RSAUtils.decryptDataOnJava(password, RSAKey);
        } catch (Exception e) {
            panResult.error("fail");
            return panResult;
        }
        if (!(password.length() < 6 || password.length() > 14)) {
            if (!Pattern.compile("^[\\u4E00-\\u9FA5]+$").matcher(password).matches() && !password.contains(" ")) {
                panResult.success(null);
                return panResult;
            } else {
                panResult.error("支持数字，大小写字母和标点符号，不允许有空格");
                return panResult;
            }
        } else {
            panResult.error("密码长度为6~14个字符");
            return panResult;
        }
    }

    public RestAPIResult<String> getPublicKeyHandle() throws Exception {
        RestAPIResult<String> panResult = new RestAPIResult<>();
        Map<String, Object> keyMap = RSAUtils.genKeyPair();
        String publicKey = RSAUtils.getPublicKey(keyMap);
        String privateKey = RSAUtils.getPrivateKey(keyMap);
        Map<String, Object> map = new HashMap<>();
        map.put("publicKey", publicKey);
        map.put("RSAKey", privateKey);
        panResult.setRespMap(map);
        panResult.setRespData("sucess");
        return panResult;
    }
}
