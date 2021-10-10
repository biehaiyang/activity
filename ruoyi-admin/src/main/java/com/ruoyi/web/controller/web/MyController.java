package com.ruoyi.web.controller.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/web/my")
public class MyController {

    @Resource
    private ITAccountService accountService;

    @Resource
    private ITCollectService collectService;

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

    @PostMapping ("/queryMoney")
    @Token
    public AjaxResult queryMoney (@LoginUser TWebUser webUser) {

        QueryWrapper<TAccount> queryWrapper = new QueryWrapper<TAccount>()
                .eq("user_id",webUser.getId())
                .orderByDesc("create_time");

        List<TAccount> accountList = accountService.list(queryWrapper);

        Map<String, Object> map = new HashMap<>();
        map.put("user",webUser);
        map.put("account",accountList);
        return AjaxResult.success(map);
    }

    /**
     * 收藏
     * @param webUser
     * @return
     */
    @PostMapping ("/queryByCollect")
    @Token
    public AjaxResult queryByCollect (@LoginUser TWebUser webUser) {

        QueryWrapper<TCollect> queryWrapper = new QueryWrapper<TCollect>()
                .eq("user_id", webUser.getId());

        List<TCollect> tCollectList = collectService.list(queryWrapper);

        List<Long> ids = new ArrayList<>();
        for (TCollect tCollect : tCollectList) {
            ids.add(tCollect.getAcvitityId());
        }

        List<TActivityData> activityData = activityDataService.listByIds(ids);

        for (TActivityData activityDatum : activityData) {
            QueryWrapper<TActivityImg> imgQueryWrapper = new QueryWrapper<TActivityImg>()
                    .eq("id", activityDatum.getId());
            //图片
            List<TActivityImg> imgList = imgService.list(imgQueryWrapper);

            Map<String, List<TActivityImg>> listMap = imgList.stream().collect(Collectors.groupingBy(TActivityImg::getType));
            activityDatum.setImgWebList(listMap.get("1"));
            activityDatum.setImgWebContentList(listMap.get("2"));

            if ("0".equals(activityDatum.getDateFlag())) {
                QueryWrapper<TActivityDate> dateQueryWrapper = new QueryWrapper<TActivityDate>()
                        .eq("activity_id", activityDatum.getId());

                //时间
                List<TActivityDate> dateList = activityDateService.list(dateQueryWrapper);
                activityDatum.setActivityDate(dateList);

            }

            if ("0".equals(activityDatum.getSpecFlag())) {
                //规格
                QueryWrapper<TActivitySpec> specQueryWrapper = new QueryWrapper<TActivitySpec>()
                        .eq("activity_id", activityDatum.getId());

                List<TActivitySpec> specList = activitySpecService.list(specQueryWrapper);
                activityDatum.setActivitySpecs(specList);

            }

            QueryWrapper<TActivityComment> commentQueryWrapper = new QueryWrapper<TActivityComment>()
                    .eq("activity_id", activityDatum.getId());

            List<TActivityComment> commentList = commentService.list(commentQueryWrapper);
            activityDatum.setCommentList(commentList);
        }


        return AjaxResult.success(activityData);
    }

    public AjaxResult queryByFans () {

        return AjaxResult.success();
    }
}
