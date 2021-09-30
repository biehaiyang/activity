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
import com.ruoyi.system.bo.TActivityDateAddBo;
import com.ruoyi.system.bo.TActivityDateQueryBo;
import com.ruoyi.system.bo.TActivityDateEditBo;
import com.ruoyi.system.domain.TActivityDate;
import com.ruoyi.system.mapper.TActivityDateMapper;
import com.ruoyi.system.vo.TActivityDateVo;
import com.ruoyi.system.service.ITActivityDateService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 活动时间（分场次）Service业务层处理
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Service
public class TActivityDateServiceImpl extends ServicePlusImpl<TActivityDateMapper, TActivityDate> implements ITActivityDateService {

    @Override
    public TActivityDateVo queryById(Long id){
        return getVoById(id, TActivityDateVo.class);
    }

    @Override
    public TableDataInfo<TActivityDateVo> queryPageList(TActivityDateQueryBo bo) {
        PagePlus<TActivityDate, TActivityDateVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), TActivityDateVo.class);
        return PageUtils.buildDataInfo(result);
    }

    @Override
    public List<TActivityDateVo> queryList(TActivityDateQueryBo bo) {
        return listVo(buildQueryWrapper(bo), TActivityDateVo.class);
    }

    private LambdaQueryWrapper<TActivityDate> buildQueryWrapper(TActivityDateQueryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TActivityDate> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getActivityId() != null, TActivityDate::getActivityId, bo.getActivityId());
        lqw.eq(bo.getActivityDate() != null, TActivityDate::getActivityDate, bo.getActivityDate());
        return lqw;
    }

    @Override
    public Boolean insertByAddBo(TActivityDateAddBo bo) {
        TActivityDate add = BeanUtil.toBean(bo, TActivityDate.class);
        validEntityBeforeSave(add);
        return save(add);
    }

    @Override
    public Boolean updateByEditBo(TActivityDateEditBo bo) {
        TActivityDate update = BeanUtil.toBean(bo, TActivityDate.class);
        validEntityBeforeSave(update);
        return updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(TActivityDate entity){
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
