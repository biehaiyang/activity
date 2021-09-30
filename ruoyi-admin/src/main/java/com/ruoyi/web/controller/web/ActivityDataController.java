package com.ruoyi.web.controller.web;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.TActivityData;
import com.ruoyi.system.domain.TActivityDate;
import com.ruoyi.system.domain.TActivitySpec;
import com.ruoyi.system.domain.TWebUser;
import com.ruoyi.system.service.ITActivityDataService;
import com.ruoyi.system.service.ITActivityDateService;
import com.ruoyi.system.service.ITActivitySpecService;
import com.ruoyi.web.controller.token.LoginUser;
import com.ruoyi.web.controller.token.Token;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/web/activity")
public class ActivityDataController {

    @Resource
    private ITActivityDataService activityDataService;

    @Resource
    private ITActivityDateService activityDateService;

    @Resource
    private ITActivitySpecService activitySpecService;

    @Token
    @PostMapping ("/addActivity")
    public AjaxResult addActivity (
            @LoginUser TWebUser webUser,
            TActivityData activityData) {

        activityData.setIsRecommend("0");
        activityData.setUserId(webUser.getId());
        activityData.setUserName(webUser.getUserName());
        activityDataService.save(activityData);

        if ("0".equals(activityData.getDateFlag())) {

            for (TActivityDate tActivityDate : activityData.getActivityDate()) {
                tActivityDate.setActivityId(activityData.getId());
            }

            activityDateService.saveAll(activityData.getActivityDate());
        }

        if ("0".equals(activityData.getSpecFlag())) {
            for (TActivitySpec activitySpec : activityData.getActivitySpecs()) {
                activitySpec.setActivityId(activityData.getId());
            }
            activitySpecService.saveAll(activityData.getActivitySpecs());
        }

        return AjaxResult.success("添加成功");
    }



}
