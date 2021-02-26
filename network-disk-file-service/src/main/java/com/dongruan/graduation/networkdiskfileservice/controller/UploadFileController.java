package com.dongruan.graduation.networkdiskfileservice.controller;

import com.dongruan.graduation.networkdiskcommon.request.QuickUploadFileRequest;
import com.dongruan.graduation.networkdiskcommon.request.UploadFileRequest;
import com.dongruan.graduation.networkdiskcommon.utils.RestAPIResult;
import com.dongruan.graduation.networkdiskfileservice.provider.UploadFileProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 上传文件服务
 *
 * @author: quhailong
 * @date: 2019/9/25
 */
@RestController
public class UploadFileController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private HttpServletRequest httpServletRequest;
    @Autowired
    private UploadFileProvider uploadFileProvider;

    /**
     * 上传文件
     *
     * @author: quhailong
     * @date: 2019/9/25
     */
    @RequestMapping(value = "uploadfile", method = RequestMethod.POST)
    public RestAPIResult<String> uploadFile(UploadFileRequest request) throws IOException {
        logger.info("上传文件请求URL：{}", httpServletRequest.getRequestURL());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        logger.info("上传文件数据处理开始,request:{}", request);
        RestAPIResult<String> result = uploadFileProvider.uploadFileHandle(request);
        logger.info("上传文件数据处理结束,result:{}", result);
        stopWatch.stop();
        logger.info("上传文件调用时间,millies:{}", stopWatch.getTotalTimeMillis());
        return result;
    }

    /**
     * 秒传文件
     *
     * @author: quhailong
     * @date: 2019/9/25
     */
    //@RequestMapping("/uploadFileSpe") // new annotation since 4.3
    @RequestMapping(value = "quickuploadfile", method = RequestMethod.POST)
    public RestAPIResult<String> quickUploadFile(QuickUploadFileRequest request) throws UnsupportedEncodingException {
        logger.info("秒传文件请求URL：{}", httpServletRequest.getRequestURL());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        logger.info("秒传文件数据处理开始,request:{}", request);
        RestAPIResult<String> result = uploadFileProvider.quickUploadFileHandle(request);
        logger.info("秒传文件数据处理结束,result:{}", result);
        stopWatch.stop();
        logger.info("秒传文件调用时间,millies:{}", stopWatch.getTotalTimeMillis());
        return result;
    }

    /**
     * 上传文件(内部调用)
     *
     * @author: quhailong
     * @date: 2019/9/26
     */
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public RestAPIResult<String> upload(MultipartFile file) throws IOException {
        logger.info("上传文件(内部调用)请求URL：{}", httpServletRequest.getRequestURL());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        logger.info("上传文件(内部调用)数据处理开始");
        RestAPIResult<String> result = uploadFileProvider.uploadHandle(file);
        logger.info("上传文件(内部调用)数据处理结束,result:{}", result);
        stopWatch.stop();
        logger.info("上传文件调用时间,millies:{}", stopWatch.getTotalTimeMillis());
        return result;
    }

}
