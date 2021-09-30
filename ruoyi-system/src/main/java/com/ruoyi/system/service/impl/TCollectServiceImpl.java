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
import com.ruoyi.system.bo.TCollectAddBo;
import com.ruoyi.system.bo.TCollectQueryBo;
import com.ruoyi.system.bo.TCollectEditBo;
import com.ruoyi.system.domain.TCollect;
import com.ruoyi.system.mapper.TCollectMapper;
import com.ruoyi.system.vo.TCollectVo;
import com.ruoyi.system.service.ITCollectService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 收藏Service业务层处理
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Service
public class TCollectServiceImpl extends ServicePlusImpl<TCollectMapper, TCollect> implements ITCollectService {

    @Override
    public TCollectVo queryById(Long id){
        return getVoById(id, TCollectVo.class);
    }

    @Override
    public TableDataInfo<TCollectVo> queryPageList(TCollectQueryBo bo) {
        PagePlus<TCollect, TCollectVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), TCollectVo.class);
        return PageUtils.buildDataInfo(result);
    }

    @Override
    public List<TCollectVo> queryList(TCollectQueryBo bo) {
        return listVo(buildQueryWrapper(bo), TCollectVo.class);
    }

    private LambdaQueryWrapper<TCollect> buildQueryWrapper(TCollectQueryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TCollect> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getUserId() != null, TCollect::getUserId, bo.getUserId());
        lqw.eq(bo.getAcvitityId() != null, TCollect::getAcvitityId, bo.getAcvitityId());
        return lqw;
    }

    @Override
    public Boolean insertByAddBo(TCollectAddBo bo) {
        TCollect add = BeanUtil.toBean(bo, TCollect.class);
        validEntityBeforeSave(add);
        return save(add);
    }

    @Override
    public Boolean updateByEditBo(TCollectEditBo bo) {
        TCollect update = BeanUtil.toBean(bo, TCollect.class);
        validEntityBeforeSave(update);
        return updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(TCollect entity){
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
