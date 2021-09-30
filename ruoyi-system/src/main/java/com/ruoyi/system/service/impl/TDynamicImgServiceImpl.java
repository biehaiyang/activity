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
import com.ruoyi.system.bo.TDynamicImgAddBo;
import com.ruoyi.system.bo.TDynamicImgQueryBo;
import com.ruoyi.system.bo.TDynamicImgEditBo;
import com.ruoyi.system.domain.TDynamicImg;
import com.ruoyi.system.mapper.TDynamicImgMapper;
import com.ruoyi.system.vo.TDynamicImgVo;
import com.ruoyi.system.service.ITDynamicImgService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 动态图片Service业务层处理
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Service
public class TDynamicImgServiceImpl extends ServicePlusImpl<TDynamicImgMapper, TDynamicImg> implements ITDynamicImgService {

    @Override
    public TDynamicImgVo queryById(Long id){
        return getVoById(id, TDynamicImgVo.class);
    }

    @Override
    public TableDataInfo<TDynamicImgVo> queryPageList(TDynamicImgQueryBo bo) {
        PagePlus<TDynamicImg, TDynamicImgVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), TDynamicImgVo.class);
        return PageUtils.buildDataInfo(result);
    }

    @Override
    public List<TDynamicImgVo> queryList(TDynamicImgQueryBo bo) {
        return listVo(buildQueryWrapper(bo), TDynamicImgVo.class);
    }

    private LambdaQueryWrapper<TDynamicImg> buildQueryWrapper(TDynamicImgQueryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TDynamicImg> lqw = Wrappers.lambdaQuery();
        lqw.eq(StrUtil.isNotBlank(bo.getImgUrl()), TDynamicImg::getImgUrl, bo.getImgUrl());
        return lqw;
    }

    @Override
    public Boolean insertByAddBo(TDynamicImgAddBo bo) {
        TDynamicImg add = BeanUtil.toBean(bo, TDynamicImg.class);
        validEntityBeforeSave(add);
        return save(add);
    }

    @Override
    public Boolean updateByEditBo(TDynamicImgEditBo bo) {
        TDynamicImg update = BeanUtil.toBean(bo, TDynamicImg.class);
        validEntityBeforeSave(update);
        return updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(TDynamicImg entity){
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
