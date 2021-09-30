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
import com.ruoyi.system.bo.TDynamicStarAddBo;
import com.ruoyi.system.bo.TDynamicStarQueryBo;
import com.ruoyi.system.bo.TDynamicStarEditBo;
import com.ruoyi.system.domain.TDynamicStar;
import com.ruoyi.system.mapper.TDynamicStarMapper;
import com.ruoyi.system.vo.TDynamicStarVo;
import com.ruoyi.system.service.ITDynamicStarService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 动态点赞Service业务层处理
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Service
public class TDynamicStarServiceImpl extends ServicePlusImpl<TDynamicStarMapper, TDynamicStar> implements ITDynamicStarService {

    @Override
    public TDynamicStarVo queryById(Long id){
        return getVoById(id, TDynamicStarVo.class);
    }

    @Override
    public TableDataInfo<TDynamicStarVo> queryPageList(TDynamicStarQueryBo bo) {
        PagePlus<TDynamicStar, TDynamicStarVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), TDynamicStarVo.class);
        return PageUtils.buildDataInfo(result);
    }

    @Override
    public List<TDynamicStarVo> queryList(TDynamicStarQueryBo bo) {
        return listVo(buildQueryWrapper(bo), TDynamicStarVo.class);
    }

    private LambdaQueryWrapper<TDynamicStar> buildQueryWrapper(TDynamicStarQueryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TDynamicStar> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getDynamicId() != null, TDynamicStar::getDynamicId, bo.getDynamicId());
        lqw.eq(bo.getUserId() != null, TDynamicStar::getUserId, bo.getUserId());
        lqw.eq(bo.getStarUserId() != null, TDynamicStar::getStarUserId, bo.getStarUserId());
        return lqw;
    }

    @Override
    public Boolean insertByAddBo(TDynamicStarAddBo bo) {
        TDynamicStar add = BeanUtil.toBean(bo, TDynamicStar.class);
        validEntityBeforeSave(add);
        return save(add);
    }

    @Override
    public Boolean updateByEditBo(TDynamicStarEditBo bo) {
        TDynamicStar update = BeanUtil.toBean(bo, TDynamicStar.class);
        validEntityBeforeSave(update);
        return updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(TDynamicStar entity){
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
