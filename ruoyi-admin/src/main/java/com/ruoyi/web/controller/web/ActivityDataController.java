package com.ruoyi.web.controller.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.internal.$Gson$Preconditions;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.*;
import com.ruoyi.web.controller.token.LoginUser;
import com.ruoyi.web.controller.token.Token;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/web/activity")
public class ActivityDataController {

    @Resource
    private ITActivityDataService activityDataService;

    @Resource
    private ITActivityDateService activityDateService;

    @Resource
    private ITActivityImgService imgService;

    @Resource
    private ITActivitySpecService activitySpecService;

    @Resource
    private ITActivityCommentService commentService;

    @Token
    @PostMapping ("/addActivity")
    public AjaxResult addActivity (
            @LoginUser TWebUser webUser,
            TActivityData activityData) {

        //todo 让我感动的从来不是腻死人的话和昂贵的礼物而是你下意识的惦记和语气里满满的温柔.

        //添加 活动
        activityData.setIsRecommend("0");
        activityData.setUserId(webUser.getId());
        activityData.setUserName(webUser.getUserName());
        activityDataService.save(activityData);

        //判断是否开启时间
        if ("0".equals(activityData.getDateFlag())) {

            for (TActivityDate tActivityDate : activityData.getActivityDate()) {
                tActivityDate.setActivityId(activityData.getId());
            }

            activityDateService.saveAll(activityData.getActivityDate());
        }

        //判断是否开启规格
        if ("0".equals(activityData.getSpecFlag())) {
            for (TActivitySpec activitySpec : activityData.getActivitySpecs()) {
                activitySpec.setActivityId(activityData.getId());
            }
            activitySpecService.saveAll(activityData.getActivitySpecs());
        }

        List<TActivityImg> imgList = new ArrayList<>();

        //添加图片
        for (String s : activityData.getImgList()) {
            TActivityImg activityImg = new TActivityImg();
            activityImg.setId(activityData.getId());
            activityImg.setImgUrl(s);
            activityImg.setType("1");

            imgList.add(activityImg);
        }

        for (String s : activityData.getImgContentList()) {
            TActivityImg activityImg = new TActivityImg();
            activityImg.setId(activityData.getId());
            activityImg.setImgUrl(s);
            activityImg.setType("2");

            imgList.add(activityImg);
        }

        //添加图片
        imgService.saveAll(imgList);

        return AjaxResult.success("添加成功");
    }

    /**
     * 查询活动详情
     * @param id
     * @return
     */
    @PostMapping ("/queryActivityById")
    public AjaxResult queryActivityById (Integer id) {

        // todo 思念如白马 自别离 未停蹄
        TActivityData activityData = activityDataService.getById(id);

        QueryWrapper<TActivityImg> queryWrapper = new QueryWrapper<TActivityImg>()
                .eq("id", id);
        //图片
        List<TActivityImg> imgList = imgService.list(queryWrapper);

        Map<String, List<TActivityImg>> listMap = imgList.stream().collect(Collectors.groupingBy(TActivityImg::getType));
        activityData.setImgWebList(listMap.get("1"));
        activityData.setImgWebContentList(listMap.get("2"));

        if ("0".equals(activityData.getDateFlag())) {
            QueryWrapper<TActivityDate> dateQueryWrapper = new QueryWrapper<TActivityDate>()
                    .eq("activity_id", id);

            //时间
            List<TActivityDate> dateList = activityDateService.list(dateQueryWrapper);
            activityData.setActivityDate(dateList);

        }

        if ("0".equals(activityData.getSpecFlag())) {
            //规格
            QueryWrapper<TActivitySpec> specQueryWrapper = new QueryWrapper<TActivitySpec>()
                    .eq("activity_id", id);

            List<TActivitySpec> specList = activitySpecService.list(specQueryWrapper);
            activityData.setActivitySpecs(specList);

        }

        QueryWrapper<TActivityComment> commentQueryWrapper = new QueryWrapper<TActivityComment>()
                .eq("activity_id", id);

        List<TActivityComment> commentList = commentService.list(commentQueryWrapper);
        activityData.setCommentList(commentList);


        return AjaxResult.success(activityData);
    }

}
