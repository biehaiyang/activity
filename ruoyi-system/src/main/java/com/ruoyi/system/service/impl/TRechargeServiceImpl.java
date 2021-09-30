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
import com.ruoyi.system.bo.TRechargeAddBo;
import com.ruoyi.system.bo.TRechargeQueryBo;
import com.ruoyi.system.bo.TRechargeEditBo;
import com.ruoyi.system.domain.TRecharge;
import com.ruoyi.system.mapper.TRechargeMapper;
import com.ruoyi.system.vo.TRechargeVo;
import com.ruoyi.system.service.ITRechargeService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 充值Service业务层处理
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Service
public class TRechargeServiceImpl extends ServicePlusImpl<TRechargeMapper, TRecharge> implements ITRechargeService {

    @Override
    public TRechargeVo queryById(Long id){
        return getVoById(id, TRechargeVo.class);
    }

    @Override
    public TableDataInfo<TRechargeVo> queryPageList(TRechargeQueryBo bo) {
        PagePlus<TRecharge, TRechargeVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), TRechargeVo.class);
        return PageUtils.buildDataInfo(result);
    }

    @Override
    public List<TRechargeVo> queryList(TRechargeQueryBo bo) {
        return listVo(buildQueryWrapper(bo), TRechargeVo.class);
    }

    private LambdaQueryWrapper<TRecharge> buildQueryWrapper(TRechargeQueryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TRecharge> lqw = Wrappers.lambdaQuery();
        lqw.eq(StrUtil.isNotBlank(bo.getOrderNo()), TRecharge::getOrderNo, bo.getOrderNo());
        lqw.eq(StrUtil.isNotBlank(bo.getSeqNoNo()), TRecharge::getSeqNoNo, bo.getSeqNoNo());
        lqw.eq(bo.getAmt() != null, TRecharge::getAmt, bo.getAmt());
        lqw.eq(bo.getPayType() != null, TRecharge::getPayType, bo.getPayType());
        lqw.eq(bo.getDone() != null, TRecharge::getDone, bo.getDone());
        lqw.eq(StrUtil.isNotBlank(bo.getSummary()), TRecharge::getSummary, bo.getSummary());
        lqw.eq(StrUtil.isNotBlank(bo.getReason()), TRecharge::getReason, bo.getReason());
        lqw.eq(bo.getUserId() != null, TRecharge::getUserId, bo.getUserId());
        return lqw;
    }

    @Override
    public Boolean insertByAddBo(TRechargeAddBo bo) {
        TRecharge add = BeanUtil.toBean(bo, TRecharge.class);
        validEntityBeforeSave(add);
        return save(add);
    }

    @Override
    public Boolean updateByEditBo(TRechargeEditBo bo) {
        TRecharge update = BeanUtil.toBean(bo, TRecharge.class);
        validEntityBeforeSave(update);
        return updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(TRecharge entity){
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
