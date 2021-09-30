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
import com.ruoyi.system.bo.TDynamicAddBo;
import com.ruoyi.system.bo.TDynamicQueryBo;
import com.ruoyi.system.bo.TDynamicEditBo;
import com.ruoyi.system.domain.TDynamic;
import com.ruoyi.system.mapper.TDynamicMapper;
import com.ruoyi.system.vo.TDynamicVo;
import com.ruoyi.system.service.ITDynamicService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 动态Service业务层处理
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Service
public class TDynamicServiceImpl extends ServicePlusImpl<TDynamicMapper, TDynamic> implements ITDynamicService {

    @Override
    public TDynamicVo queryById(Long id){
        return getVoById(id, TDynamicVo.class);
    }

    @Override
    public TableDataInfo<TDynamicVo> queryPageList(TDynamicQueryBo bo) {
        PagePlus<TDynamic, TDynamicVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), TDynamicVo.class);
        return PageUtils.buildDataInfo(result);
    }

    @Override
    public List<TDynamicVo> queryList(TDynamicQueryBo bo) {
        return listVo(buildQueryWrapper(bo), TDynamicVo.class);
    }

    private LambdaQueryWrapper<TDynamic> buildQueryWrapper(TDynamicQueryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TDynamic> lqw = Wrappers.lambdaQuery();
        lqw.eq(StrUtil.isNotBlank(bo.getTitle()), TDynamic::getTitle, bo.getTitle());
        lqw.eq(StrUtil.isNotBlank(bo.getContent()), TDynamic::getContent, bo.getContent());
        lqw.eq(StrUtil.isNotBlank(bo.getIsAddress()), TDynamic::getIsAddress, bo.getIsAddress());
        lqw.eq(StrUtil.isNotBlank(bo.getAddress()), TDynamic::getAddress, bo.getAddress());
        lqw.eq(StrUtil.isNotBlank(bo.getDeleteFlag()), TDynamic::getDeleteFlag, bo.getDeleteFlag());
        lqw.eq(bo.getGiveNum() != null, TDynamic::getGiveNum, bo.getGiveNum());
        lqw.eq(bo.getUserId() != null, TDynamic::getUserId, bo.getUserId());
        return lqw;
    }

    @Override
    public Boolean insertByAddBo(TDynamicAddBo bo) {
        TDynamic add = BeanUtil.toBean(bo, TDynamic.class);
        validEntityBeforeSave(add);
        return save(add);
    }

    @Override
    public Boolean updateByEditBo(TDynamicEditBo bo) {
        TDynamic update = BeanUtil.toBean(bo, TDynamic.class);
        validEntityBeforeSave(update);
        return updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(TDynamic entity){
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
