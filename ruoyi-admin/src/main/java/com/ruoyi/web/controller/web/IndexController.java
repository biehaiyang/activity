package com.ruoyi.web.controller.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.TActivityData;
import com.ruoyi.system.domain.TBanner;
import com.ruoyi.system.domain.TType;
import com.ruoyi.system.mapper.TActivityDataMapper;
import com.ruoyi.system.service.ITActivityDataService;
import com.ruoyi.system.service.ITBannerService;
import com.ruoyi.system.service.ITTypeService;
import com.ruoyi.web.controller.token.Token;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping ("/web/index")
@RestController
public class IndexController {

    @Resource
    private ITTypeService typeService;

    @Resource
    private ITBannerService bannerService;

    @Resource
    private ITActivityDataService dataService;

    /**
     * @createTime 2021-10-06 别海洋
     * @param page 页码
     * @param size 数量
     * @return
     */
    @PostMapping ("/index")
    @Token
    public AjaxResult index (
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {

        QueryWrapper<TBanner> bannerQueryWrapper = new QueryWrapper<TBanner>()
                .orderByDesc("sort");

        //广告图
        List<TBanner> bannerList = bannerService.list(bannerQueryWrapper);


        QueryWrapper<TType> tTypeQueryWrapper = new QueryWrapper<TType>()
                .orderByDesc("sort");

        //分类
        List<TType> typeList = typeService.list(tTypeQueryWrapper);


        QueryWrapper<TActivityData> dataQueryWrapper = new QueryWrapper<TActivityData>()
                .eq("is_recommend","1")
                .last(" limit 2 ");
        //推荐活动 2个
        List<TActivityData> tuijianList = dataService.list(dataQueryWrapper);

        Page<TActivityData> tActivityDataPage = new Page<TActivityData>(page, size);

        //所有活动
        dataQueryWrapper = new QueryWrapper<TActivityData>()
                .orderByDesc("createTime");

        Page<TActivityData> dataPage = dataService.page(tActivityDataPage, dataQueryWrapper);

        Map<String, Object> map = new HashMap<>();

        map.put("banner",bannerList);
        map.put("tyoe", typeList);
        map.put("tuijian", tuijianList);
        map.put("dataActivity",dataPage.getRecords());
        map.put("isMessage", "1");




        return AjaxResult.success(map);
    }

    @Resource
    private TActivityDataMapper activityDataMapper;

    /**
     * 根据类型查询数据
     * @param typeId
     * @return
     */
    @PostMapping ("/queryByType")
    public AjaxResult queryByType (Integer typeId,
                                   @RequestParam(defaultValue = "1") Integer page,
                                   @RequestParam(defaultValue = "10") Integer size) {


        QueryWrapper<TBanner> bannerQueryWrapper = new QueryWrapper<TBanner>()
                .orderByDesc("sort");

        //广告图
        List<TBanner> bannerList = bannerService.list(bannerQueryWrapper);

        QueryWrapper<TActivityData> dataQueryWrapper = new QueryWrapper<TActivityData>()
                .eq("is_recommend","1")
                .last(" limit 2 ");
        //推荐活动 2个
        List<TActivityData> tuijianList = dataService.list(dataQueryWrapper);

        //查询所有分类
        QueryWrapper<TType> tTypeQueryWrapper = new QueryWrapper<TType>()
                .orderByDesc("sort");

        //分类
        List<TType> typeList = typeService.list(tTypeQueryWrapper);

        page = (page - 1) * 10 ;
        //查询根据分类区分预约数据
        for (TType tType : typeList) {

            List<TActivityData> dataList =  activityDataMapper.selectByType (tType.getId(),page, size);
            tType.setActivityDataList(dataList);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("banner",bannerList);
        map.put("tuijian",tuijianList);
        map.put("typeList",typeList);
        return AjaxResult.success(map);
    }
}
