package com.ruoyi.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.common.core.page.PagePlus;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.mybatisplus.core.ServicePlusImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ruoyi.system.bo.TBannerAddBo;
import com.ruoyi.system.bo.TBannerQueryBo;
import com.ruoyi.system.bo.TBannerEditBo;
import com.ruoyi.system.domain.TBanner;
import com.ruoyi.system.mapper.TBannerMapper;
import com.ruoyi.system.vo.TBannerVo;
import com.ruoyi.system.service.ITBannerService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 广告图片Service业务层处理
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Service
public class TBannerServiceImpl extends ServicePlusImpl<TBannerMapper, TBanner> implements ITBannerService {

    @Override
    public TBannerVo queryById(Long id){
        return getVoById(id, TBannerVo.class);
    }

    @Override
    public TableDataInfo<TBannerVo> queryPageList(TBannerQueryBo bo) {
        PagePlus<TBanner, TBannerVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), TBannerVo.class);
        return PageUtils.buildDataInfo(result);
    }

    @Override
    public List<TBannerVo> queryList(TBannerQueryBo bo) {
        return listVo(buildQueryWrapper(bo), TBannerVo.class);
    }

    private LambdaQueryWrapper<TBanner> buildQueryWrapper(TBannerQueryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TBanner> lqw = Wrappers.lambdaQuery();
        lqw.like(StrUtil.isNotBlank(bo.getName()), TBanner::getName, bo.getName());
        lqw.eq(StrUtil.isNotBlank(bo.getImgUrl()), TBanner::getImgUrl, bo.getImgUrl());
        lqw.eq(StrUtil.isNotBlank(bo.getClickUrl()), TBanner::getClickUrl, bo.getClickUrl());
        lqw.eq(StrUtil.isNotBlank(bo.getSort()), TBanner::getSort, bo.getSort());
        return lqw;
    }

    @Override
    public Boolean insertByAddBo(TBannerAddBo bo) {
        TBanner add = BeanUtil.toBean(bo, TBanner.class);
        validEntityBeforeSave(add);
        return save(add);
    }

    @Override
    public Boolean updateByEditBo(TBannerEditBo bo) {
        TBanner update = BeanUtil.toBean(bo, TBanner.class);
        validEntityBeforeSave(update);
        return updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(TBanner entity){
        //TODO 做一些数据校验,如唯一约束
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return removeByIds(ids);
    }
}
