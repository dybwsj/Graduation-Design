package com.dongruan.graduation.networkdiskcoreservice.controller;

import com.dongruan.graduation.networkdiskcommon.request.CopyOrMoveFileRequest;
import com.dongruan.graduation.networkdiskcommon.request.CreateDirRequest;
import com.dongruan.graduation.networkdiskcommon.request.CreateVirtualAddressRequest;
import com.dongruan.graduation.networkdiskcommon.request.RenameFileOrDirRequest;
import com.dongruan.graduation.networkdiskcommon.utils.RestAPIResult;
import com.dongruan.graduation.networkdiskcoreservice.provider.UpdateContentProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 更新服务
 *
 * @author: quhailong
 * @date: 2019/9/24
 */
@RestController
public class UpdateContentController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private HttpServletRequest httpServletRequest;
    @Autowired
    private UpdateContentProvider updateContentProvider;

    /**
     * 文件或文件夹重命名
     *
     * @author: quhailong
     * @date: 2019/9/24
     */
    @RequestMapping(value = "renamefileordir", method = RequestMethod.PUT)
    public RestAPIResult<String> renameFileOrDir(@RequestBody RenameFileOrDirRequest request) {
        logger.info("文件或文件夹重命名请求URL：{}", httpServletRequest.getRequestURL());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        logger.info("文件或文件夹重命名数据处理开始,request:{}", request);
        RestAPIResult<String> result = updateContentProvider.renameFileOrDirHandle(request);
        logger.info("文件或文件夹重命名数据处理结束,result:{}", result);
        stopWatch.stop();
        logger.info("文件或文件夹重命名调用时间,millies:{}", stopWatch.getTotalTimeMillis());
        return result;
    }

    /**
     * 删除文件
     *
     * @author: quhailong
     * @date: 2019/9/24
     */
    @RequestMapping(value = "deletefile", method = RequestMethod.DELETE)
    public RestAPIResult<String> deleteFile(String uid, String vids) throws Exception {
        logger.info("删除文件请求URL：{}", httpServletRequest.getRequestURL());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        logger.info("删除文件数据处理开始,vids:{}", vids);
        RestAPIResult<String> result = updateContentProvider.deleteFileHandle(vids);
        logger.info("删除文件数据处理结束,result:{}", result);
        stopWatch.stop();
        logger.info("删除文件调用时间,millies:{}", stopWatch.getTotalTimeMillis());
        return result;
    }

    /**
     * 创建文件夹
     *
     * @author: quhailong
     * @date: 2019/9/24
     */
    //@RequestMapping("/createDir")
    @RequestMapping(value = "createdir", method = RequestMethod.POST)
    public RestAPIResult<String> createDir(@RequestBody CreateDirRequest request) {
        logger.info("创建文件夹请求URL：{}", httpServletRequest.getRequestURL());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        logger.info("创建文件夹数据处理开始,request:{}", request);
        RestAPIResult<String> result = updateContentProvider.createDirHandle(request);
        logger.info("创建文件夹数据处理结束,result:{}", result);
        stopWatch.stop();
        logger.info("创建文件夹调用时间,millies:{}", stopWatch.getTotalTimeMillis());
        return result;
    }

    /**
     * 文件复制或移动
     *
     * @author: quhailong
     * @date: 2019/9/24
     */
    //@RequestMapping(value = "filemanager", method = { RequestMethod.POST })
    @RequestMapping(value = "copyormovefile", method = RequestMethod.PUT)
    public RestAPIResult<String> copyOrMoveFile(@RequestBody CopyOrMoveFileRequest request) {
        logger.info("文件复制或移动请求URL：{}", httpServletRequest.getRequestURL());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        logger.info("文件复制或移动数据处理开始,request:{}", request);
        RestAPIResult<String> result = updateContentProvider.copyOrMoveFileHandle(request);
        logger.info("文件复制或移动数据处理结束,result:{}", result);
        stopWatch.stop();
        logger.info("文件复制或移动调用时间,millies:{}", stopWatch.getTotalTimeMillis());
        return result;
    }

    /**
     * 创建文件(调用)
     *
     * @author: quhailong
     * @date: 2019/9/25
     */
    @RequestMapping(value = "createvirtualaddress", method = RequestMethod.POST)
    public RestAPIResult<Integer> createVirtualAddress(@RequestBody CreateVirtualAddressRequest request) {
        logger.info("创建文件请求URL：{}", httpServletRequest.getRequestURL());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        logger.info("创建文件数据处理开始,request:{}", request);
        RestAPIResult<Integer> result = updateContentProvider.createVirtualAddressHandle(request);
        logger.info("创建文件数据处理结束,result:{}", result);
        stopWatch.stop();
        logger.info("创建文件调用时间,millies:{}", stopWatch.getTotalTimeMillis());
        return result;
    }

}
