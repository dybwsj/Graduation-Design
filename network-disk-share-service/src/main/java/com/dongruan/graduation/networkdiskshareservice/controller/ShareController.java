package com.dongruan.graduation.networkdiskshareservice.controller;

import com.dongruan.graduation.networkdiskcommon.request.AddShareViewCountRequest;
import com.dongruan.graduation.networkdiskcommon.request.SaveShareRequest;
import com.dongruan.graduation.networkdiskcommon.request.ShareListRequest;
import com.dongruan.graduation.networkdiskcommon.request.ShareRequest;
import com.dongruan.graduation.networkdiskcommon.utils.RestAPIResult;
import com.dongruan.graduation.networkdiskshareservice.provider.ShareProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class ShareController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private HttpServletRequest httpServletRequest;
    @Autowired
    private ShareProvider shareProvider;

    /**
     * 分享文件
     *
     * @author: quhailong
     * @date: 2019/9/26
     */
    @RequestMapping(value = "share", method = RequestMethod.POST)
    public RestAPIResult<String> share(@RequestBody ShareRequest request) {
        logger.info("分享文件请求URL：{}", httpServletRequest.getRequestURL());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        logger.info("分享文件数据处理开始,request:{}", request);
        RestAPIResult<String> result = shareProvider.shareHandle(request);
        logger.info("分享文件数据处理结束,result:{}", result);
        stopWatch.stop();
        logger.info("分享文件调用时间,millies:{}", stopWatch.getTotalTimeMillis());
        return result;
    }

    /**
     * 获取分享列表
     *
     * @author: quhailong
     * @date: 2019/9/26
     */
    //@RequestMapping(value = "shareList", method = {RequestMethod.POST})
    @RequestMapping(value = "sharelist", method = RequestMethod.GET)
    public RestAPIResult<String> shareList(ShareListRequest request) {
        logger.info("获取分享列表请求URL：{}", httpServletRequest.getRequestURL());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        logger.info("获取分享列表数据处理开始,request:{}", request);
        RestAPIResult<String> result = shareProvider.shareListHandle(request);
        logger.info("获取分享列表数据处理结束,result:{}", result);
        stopWatch.stop();
        logger.info("获取分享列表调用时间,millies:{}", stopWatch.getTotalTimeMillis());
        return result;
    }

    /**
     * 取消分享
     *
     * @author: quhailong
     * @date: 2019/9/26
     */
    //@RequestMapping(value = "unShare", method = {RequestMethod.POST})
    @RequestMapping(value = "unshare", method = RequestMethod.GET)
    public RestAPIResult<String> unShare(String uid, String vids) {
        logger.info("取消分享请求URL：{}", httpServletRequest.getRequestURL());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        logger.info("取消分享数据处理开始,vids:{}", vids);
        RestAPIResult<String> result = shareProvider.unShareHandle(uid, vids);
        logger.info("取消分享数据处理结束,result:{}", result);
        stopWatch.stop();
        logger.info("取消分享调用时间,millies:{}", stopWatch.getTotalTimeMillis());
        return result;
    }

    /**
     * 获取分享用户信息
     *
     * @author: quhailong
     * @date: 2019/9/26
     */
    //@RequestMapping(value = "getShareUser", method = {RequestMethod.POST})
    @RequestMapping(value = "getshareuser", method = RequestMethod.GET)
    public RestAPIResult<String> getShareUser(String shareId) {
        logger.info("获取分享用户信息请求URL：{}", httpServletRequest.getRequestURL());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        logger.info("获取分享用户信息数据处理开始,shareId:{}", shareId);
        RestAPIResult<String> result = shareProvider.getShareUserHandle(shareId);
        logger.info("获取分享用户信息数据处理结束,result:{}", result);
        stopWatch.stop();
        logger.info("获取分享用户信息调用时间,millies:{}", stopWatch.getTotalTimeMillis());
        return result;
    }

    /**
     * 保存分享
     *
     * @author: quhailong
     * @date: 2019/9/26
     */
    //@RequestMapping(value = "saveShare", method = {RequestMethod.POST})
    @RequestMapping(value = "saveshare", method = RequestMethod.POST)
    public RestAPIResult<String> saveShare(@RequestBody SaveShareRequest request) {
        logger.info("保存分享请求URL：{}", httpServletRequest.getRequestURL());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        logger.info("保存分享数据处理开始,request:{}", request);
        RestAPIResult<String> result = shareProvider.saveShareHandle(request);
        logger.info("保存分享数据处理结束,result:{}", result);
        stopWatch.stop();
        logger.info("保存分享调用时间,millies:{}", stopWatch.getTotalTimeMillis());
        return result;
    }

    /**
     * 查询分享是否带密码
     *
     * @author: quhailong
     * @date: 2019/9/26
     */
    //@RequestMapping(value = "checkLock", method = {RequestMethod.POST})
    @RequestMapping(value = "checklock", method = RequestMethod.GET)
    public RestAPIResult<String> checkLock(@RequestParam("shareId") String shareId) {
        logger.info("查询分享是否带密码请求URL：{}", httpServletRequest.getRequestURL());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        logger.info("查询分享是否带密码数据处理开始,shareId:{}", shareId);
        RestAPIResult<String> result = shareProvider.checkLockHandle(shareId);
        logger.info("查询分享是否带密码数据处理结束,result:{}", result);
        stopWatch.stop();
        logger.info("查询分享是否带密码调用时间,millies:{}", stopWatch.getTotalTimeMillis());
        return result;
    }

    /**
     * 验证分享密码
     *
     * @author: quhailong
     * @date: 2019/9/26
     */
    //@RequestMapping(value = "verifykLock", method = {RequestMethod.POST})
    @RequestMapping(value = "verifyklock", method = RequestMethod.GET)
    public RestAPIResult<String> verifykLock(@RequestParam("lockPassword") String lockPassword, @RequestParam("shareId") String shareId) {
        logger.info("验证分享密码请求URL：{}", httpServletRequest.getRequestURL());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        logger.info("验证分享密码数据处理开始,shareId:{}", shareId);
        RestAPIResult<String> result = shareProvider.verifykLockHandle(lockPassword, shareId);
        logger.info("验证分享密码数据处理结束,result:{}", result);
        stopWatch.stop();
        logger.info("验证分享密码调用时间,millies:{}", stopWatch.getTotalTimeMillis());
        return result;
    }

    /**
     * 获取分享虚拟地址信息
     *
     * @author: quhailong
     * @date: 2019/9/26
     */
    @RequestMapping(value = "getvinfo", method = RequestMethod.GET)
    public RestAPIResult<String> getUid(@RequestParam("shareId") String shareId, @RequestParam("lockPassword") String lockPassword) {
        logger.info("获取分享虚拟地址信息请求URL：{}", httpServletRequest.getRequestURL());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        logger.info("获取分享虚拟地址信息数据处理开始,shareId:{}", shareId);
        RestAPIResult<String> result = shareProvider.getVinfoHandle(shareId, lockPassword);
        logger.info("获取分享虚拟地址信息数据处理结束,result:{}", result);
        stopWatch.stop();
        logger.info("获取分享虚拟地址信息调用时间,millies:{}", stopWatch.getTotalTimeMillis());
        return result;
    }

    /**
     * 增加分享访问量
     *
     * @author: quhailong
     * @date: 2019/9/26
     */
    //@RequestMapping(value = "addShareView", method = {RequestMethod.POST})
    @RequestMapping(value = "addshareview", method = RequestMethod.POST)
    public void addShareView(@RequestBody AddShareViewCountRequest request) {
        logger.info("增加分享访问量请求URL：{}", httpServletRequest.getRequestURL());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        logger.info("增加分享访问量数据处理开始,request:{}", request);
        shareProvider.addShareViewCountHandle(request);
        logger.info("增加分享访问量数据处理结束");
        stopWatch.stop();
        logger.info("增加分享访问量调用时间,millies:{}", stopWatch.getTotalTimeMillis());
    }

    /**
     * 增加分享下载量
     *
     * @author: quhailong
     * @date: 2019/9/26
     */
    //@RequestMapping(value = "addShareDownload", method = {RequestMethod.POST})
    @RequestMapping(value = "addsharedownload", method = {RequestMethod.POST})
    public void addShareDownload(@RequestParam("shareId") String shareId) {
        logger.info("增加分享下载量请求URL：{}", httpServletRequest.getRequestURL());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        logger.info("增加分享下载量数据处理开始,shareId:{}", shareId);
        shareProvider.addShareDownloadCountHandle(shareId);
        logger.info("增加分享下载量数据处理结束");
        stopWatch.stop();
        logger.info("增加分享下载量调用时间,millies:{}", stopWatch.getTotalTimeMillis());
    }
}
