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
import com.ruoyi.system.bo.THistoryAddBo;
import com.ruoyi.system.bo.THistoryQueryBo;
import com.ruoyi.system.bo.THistoryEditBo;
import com.ruoyi.system.domain.THistory;
import com.ruoyi.system.mapper.THistoryMapper;
import com.ruoyi.system.vo.THistoryVo;
import com.ruoyi.system.service.ITHistoryService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 用户浏览历史Service业务层处理
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Service
public class THistoryServiceImpl extends ServicePlusImpl<THistoryMapper, THistory> implements ITHistoryService {

    @Override
    public THistoryVo queryById(Long id){
        return getVoById(id, THistoryVo.class);
    }

    @Override
    public TableDataInfo<THistoryVo> queryPageList(THistoryQueryBo bo) {
        PagePlus<THistory, THistoryVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), THistoryVo.class);
        return PageUtils.buildDataInfo(result);
    }

    @Override
    public List<THistoryVo> queryList(THistoryQueryBo bo) {
        return listVo(buildQueryWrapper(bo), THistoryVo.class);
    }

    private LambdaQueryWrapper<THistory> buildQueryWrapper(THistoryQueryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<THistory> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getUserId() != null, THistory::getUserId, bo.getUserId());
        lqw.eq(bo.getAcvitityId() != null, THistory::getAcvitityId, bo.getAcvitityId());
        return lqw;
    }

    @Override
    public Boolean insertByAddBo(THistoryAddBo bo) {
        THistory add = BeanUtil.toBean(bo, THistory.class);
        validEntityBeforeSave(add);
        return save(add);
    }

    @Override
    public Boolean updateByEditBo(THistoryEditBo bo) {
        THistory update = BeanUtil.toBean(bo, THistory.class);
        validEntityBeforeSave(update);
        return updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(THistory entity){
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
