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
import com.ruoyi.system.bo.TActivityImgAddBo;
import com.ruoyi.system.bo.TActivityImgQueryBo;
import com.ruoyi.system.bo.TActivityImgEditBo;
import com.ruoyi.system.domain.TActivityImg;
import com.ruoyi.system.mapper.TActivityImgMapper;
import com.ruoyi.system.vo.TActivityImgVo;
import com.ruoyi.system.service.ITActivityImgService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 活动图片Service业务层处理
 *
 * @author ruoyi
 * @date 2021-10-10
 */
@Service
public class TActivityImgServiceImpl extends ServicePlusImpl<TActivityImgMapper, TActivityImg> implements ITActivityImgService {

    @Override
    public TActivityImgVo queryById(Long id){
        return getVoById(id, TActivityImgVo.class);
    }

    @Override
    public TableDataInfo<TActivityImgVo> queryPageList(TActivityImgQueryBo bo) {
        PagePlus<TActivityImg, TActivityImgVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), TActivityImgVo.class);
        return PageUtils.buildDataInfo(result);
    }

    @Override
    public List<TActivityImgVo> queryList(TActivityImgQueryBo bo) {
        return listVo(buildQueryWrapper(bo), TActivityImgVo.class);
    }

    private LambdaQueryWrapper<TActivityImg> buildQueryWrapper(TActivityImgQueryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TActivityImg> lqw = Wrappers.lambdaQuery();
        lqw.eq(StrUtil.isNotBlank(bo.getImgUrl()), TActivityImg::getImgUrl, bo.getImgUrl());
        lqw.eq(StrUtil.isNotBlank(bo.getType()), TActivityImg::getType, bo.getType());
        return lqw;
    }

    @Override
    public Boolean insertByAddBo(TActivityImgAddBo bo) {
        TActivityImg add = BeanUtil.toBean(bo, TActivityImg.class);
        validEntityBeforeSave(add);
        return save(add);
    }

    @Override
    public Boolean updateByEditBo(TActivityImgEditBo bo) {
        TActivityImg update = BeanUtil.toBean(bo, TActivityImg.class);
        validEntityBeforeSave(update);
        return updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(TActivityImg entity){
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
