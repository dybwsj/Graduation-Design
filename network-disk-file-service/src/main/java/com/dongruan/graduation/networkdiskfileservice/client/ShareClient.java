package com.dongruan.graduation.networkdiskfileservice.client;

import com.dongruan.graduation.networkdiskcommon.utils.RestAPIResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 微服务调用
 * @author 屈海龙
 *
 */
@FeignClient(name="pan-share")
public interface ShareClient {
	@RequestMapping(value = "api/getVinfo", method = { RequestMethod.POST })
	public RestAPIResult<String> getVinfo(@RequestParam("shareId") String shareId, @RequestParam("lockPassword") String lockPassword);
	@RequestMapping(value = "api/addShareDownload", method = { RequestMethod.POST })
	public void addShareDownload(@RequestParam("shareId") String shareId);
}
