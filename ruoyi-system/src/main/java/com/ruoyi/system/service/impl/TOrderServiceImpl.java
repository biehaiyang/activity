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
import com.ruoyi.system.bo.TOrderAddBo;
import com.ruoyi.system.bo.TOrderQueryBo;
import com.ruoyi.system.bo.TOrderEditBo;
import com.ruoyi.system.domain.TOrder;
import com.ruoyi.system.mapper.TOrderMapper;
import com.ruoyi.system.vo.TOrderVo;
import com.ruoyi.system.service.ITOrderService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 订单Service业务层处理
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Service
public class TOrderServiceImpl extends ServicePlusImpl<TOrderMapper, TOrder> implements ITOrderService {

    @Override
    public TOrderVo queryById(Long id){
        return getVoById(id, TOrderVo.class);
    }

    @Override
    public TableDataInfo<TOrderVo> queryPageList(TOrderQueryBo bo) {
        PagePlus<TOrder, TOrderVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), TOrderVo.class);
        return PageUtils.buildDataInfo(result);
    }

    @Override
    public List<TOrderVo> queryList(TOrderQueryBo bo) {
        return listVo(buildQueryWrapper(bo), TOrderVo.class);
    }

    private LambdaQueryWrapper<TOrder> buildQueryWrapper(TOrderQueryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TOrder> lqw = Wrappers.lambdaQuery();
        lqw.eq(StrUtil.isNotBlank(bo.getOrderTitle()), TOrder::getOrderTitle, bo.getOrderTitle());
        lqw.eq(bo.getTakeTime() != null, TOrder::getTakeTime, bo.getTakeTime());
        lqw.eq(StrUtil.isNotBlank(bo.getOrderSpec()), TOrder::getOrderSpec, bo.getOrderSpec());
        lqw.eq(bo.getPeopleNum() != null, TOrder::getPeopleNum, bo.getPeopleNum());
        lqw.eq(bo.getOrderMoney() != null, TOrder::getOrderMoney, bo.getOrderMoney());
        lqw.eq(StrUtil.isNotBlank(bo.getAddress()), TOrder::getAddress, bo.getAddress());
        lqw.eq(bo.getUnitMoney() != null, TOrder::getUnitMoney, bo.getUnitMoney());
        lqw.eq(StrUtil.isNotBlank(bo.getOrderStatus()), TOrder::getOrderStatus, bo.getOrderStatus());
        lqw.eq(StrUtil.isNotBlank(bo.getPayId()), TOrder::getPayId, bo.getPayId());
        lqw.eq(bo.getPayTime() != null, TOrder::getPayTime, bo.getPayTime());
        lqw.eq(StrUtil.isNotBlank(bo.getPayType()), TOrder::getPayType, bo.getPayType());
        return lqw;
    }

    @Override
    public Boolean insertByAddBo(TOrderAddBo bo) {
        TOrder add = BeanUtil.toBean(bo, TOrder.class);
        validEntityBeforeSave(add);
        return save(add);
    }

    @Override
    public Boolean updateByEditBo(TOrderEditBo bo) {
        TOrder update = BeanUtil.toBean(bo, TOrder.class);
        validEntityBeforeSave(update);
        return updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(TOrder entity){
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
