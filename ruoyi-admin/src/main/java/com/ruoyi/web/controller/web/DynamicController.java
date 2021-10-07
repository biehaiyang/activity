package com.ruoyi.web.controller.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.TDynamic;
import com.ruoyi.system.domain.TDynamicImg;
import com.ruoyi.system.mapper.TDynamicMapper;
import com.ruoyi.system.service.ITDynamicImgService;
import com.ruoyi.system.service.ITDynamicService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/web/dynamic")
public class DynamicController {

    @Resource
    private ITDynamicService dynamicService;

    @Resource
    private TDynamicMapper tDynamicMapper;

    @Resource
    private ITDynamicImgService dynamicImgService;

    /**
     * 查询所有动态
     * @param page
     * @param size
     * @return
     */
    @PostMapping ("/queryList")
    public AjaxResult queryList (
            @RequestParam(defaultValue = "1")Integer page,
            @RequestParam(defaultValue = "10")Integer size) {

        page = (page -1 ) * 10 ;

        List<TDynamic> dynamicList = tDynamicMapper.selectDynamic(page, size);

        for (TDynamic tDynamic : dynamicList) {

            QueryWrapper<TDynamicImg> queryWrapper = new QueryWrapper<TDynamicImg>()
                    .eq("id",tDynamic.getId());

            List<TDynamicImg> list = dynamicImgService.list();

            tDynamic.setImgList(list);
        }

        return AjaxResult.success(dynamicList);
    }
}
