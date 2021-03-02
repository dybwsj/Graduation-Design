package com.dongruan.graduation.networkdiskapi.service;

import com.dongruan.graduation.networkdiskcommon.utils.RestAPIResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface ShareService {

    @RequestMapping(value = "share/addsharedownload", method = {RequestMethod.POST})
    void addShareDownload(@RequestParam("shareId") String shareId);

    @RequestMapping(value = "share/getvinfo", method = RequestMethod.GET)
    RestAPIResult<String> getUid(@RequestParam("shareId") String shareId, @RequestParam("lockPassword") String lockPassword);
}
