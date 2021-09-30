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
import com.ruoyi.system.bo.TActivitySpecAddBo;
import com.ruoyi.system.bo.TActivitySpecQueryBo;
import com.ruoyi.system.bo.TActivitySpecEditBo;
import com.ruoyi.system.domain.TActivitySpec;
import com.ruoyi.system.mapper.TActivitySpecMapper;
import com.ruoyi.system.vo.TActivitySpecVo;
import com.ruoyi.system.service.ITActivitySpecService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 活动规格Service业务层处理
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Service
public class TActivitySpecServiceImpl extends ServicePlusImpl<TActivitySpecMapper, TActivitySpec> implements ITActivitySpecService {

    @Override
    public TActivitySpecVo queryById(Long id){
        return getVoById(id, TActivitySpecVo.class);
    }

    @Override
    public TableDataInfo<TActivitySpecVo> queryPageList(TActivitySpecQueryBo bo) {
        PagePlus<TActivitySpec, TActivitySpecVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), TActivitySpecVo.class);
        return PageUtils.buildDataInfo(result);
    }

    @Override
    public List<TActivitySpecVo> queryList(TActivitySpecQueryBo bo) {
        return listVo(buildQueryWrapper(bo), TActivitySpecVo.class);
    }

    private LambdaQueryWrapper<TActivitySpec> buildQueryWrapper(TActivitySpecQueryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TActivitySpec> lqw = Wrappers.lambdaQuery();
        lqw.like(StrUtil.isNotBlank(bo.getSpecName()), TActivitySpec::getSpecName, bo.getSpecName());
        lqw.eq(bo.getMoney() != null, TActivitySpec::getMoney, bo.getMoney());
        lqw.eq(bo.getActivityId() != null, TActivitySpec::getActivityId, bo.getActivityId());
        return lqw;
    }

    @Override
    public Boolean insertByAddBo(TActivitySpecAddBo bo) {
        TActivitySpec add = BeanUtil.toBean(bo, TActivitySpec.class);
        validEntityBeforeSave(add);
        return save(add);
    }

    @Override
    public Boolean updateByEditBo(TActivitySpecEditBo bo) {
        TActivitySpec update = BeanUtil.toBean(bo, TActivitySpec.class);
        validEntityBeforeSave(update);
        return updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(TActivitySpec entity){
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
