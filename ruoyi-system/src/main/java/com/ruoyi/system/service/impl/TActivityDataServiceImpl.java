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
import com.ruoyi.system.bo.TActivityDataAddBo;
import com.ruoyi.system.bo.TActivityDataQueryBo;
import com.ruoyi.system.bo.TActivityDataEditBo;
import com.ruoyi.system.domain.TActivityData;
import com.ruoyi.system.mapper.TActivityDataMapper;
import com.ruoyi.system.vo.TActivityDataVo;
import com.ruoyi.system.service.ITActivityDataService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 活动数据Service业务层处理
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Service
public class TActivityDataServiceImpl extends ServicePlusImpl<TActivityDataMapper, TActivityData> implements ITActivityDataService {

    @Override
    public TActivityDataVo queryById(Long id){
        return getVoById(id, TActivityDataVo.class);
    }

    @Override
    public TableDataInfo<TActivityDataVo> queryPageList(TActivityDataQueryBo bo) {
        PagePlus<TActivityData, TActivityDataVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), TActivityDataVo.class);
        return PageUtils.buildDataInfo(result);
    }

    @Override
    public List<TActivityDataVo> queryList(TActivityDataQueryBo bo) {
        return listVo(buildQueryWrapper(bo), TActivityDataVo.class);
    }

    private LambdaQueryWrapper<TActivityData> buildQueryWrapper(TActivityDataQueryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TActivityData> lqw = Wrappers.lambdaQuery();
        lqw.eq(StrUtil.isNotBlank(bo.getTitle()), TActivityData::getTitle, bo.getTitle());
        lqw.eq(StrUtil.isNotBlank(bo.getType()), TActivityData::getType, bo.getType());
        lqw.eq(bo.getStartTime() != null, TActivityData::getStartTime, bo.getStartTime());
        lqw.eq(bo.getEndTime() != null, TActivityData::getEndTime, bo.getEndTime());
        lqw.eq(bo.getMoney() != null, TActivityData::getMoney, bo.getMoney());
        lqw.eq(bo.getMaxPeople() != null, TActivityData::getMaxPeople, bo.getMaxPeople());
        lqw.eq(StrUtil.isNotBlank(bo.getSponsorPhone()), TActivityData::getSponsorPhone, bo.getSponsorPhone());
        lqw.eq(bo.getUserId() != null, TActivityData::getUserId, bo.getUserId());
        lqw.like(StrUtil.isNotBlank(bo.getUserName()), TActivityData::getUserName, bo.getUserName());
        lqw.eq(StrUtil.isNotBlank(bo.getSpecFlag()), TActivityData::getSpecFlag, bo.getSpecFlag());
        lqw.eq(StrUtil.isNotBlank(bo.getDateFlag()), TActivityData::getDateFlag, bo.getDateFlag());
        lqw.eq(bo.getBrowseNum() != null, TActivityData::getBrowseNum, bo.getBrowseNum());
        lqw.eq(bo.getAlreadyPeople() != null, TActivityData::getAlreadyPeople, bo.getAlreadyPeople());
        lqw.eq(StrUtil.isNotBlank(bo.getIsRecommend()), TActivityData::getIsRecommend, bo.getIsRecommend());
        lqw.eq(StrUtil.isNotBlank(bo.getProvince()), TActivityData::getProvince, bo.getProvince());
        lqw.eq(StrUtil.isNotBlank(bo.getCity()), TActivityData::getCity, bo.getCity());
        lqw.eq(StrUtil.isNotBlank(bo.getAddress()), TActivityData::getAddress, bo.getAddress());
        return lqw;
    }

    @Override
    public Boolean insertByAddBo(TActivityDataAddBo bo) {
        TActivityData add = BeanUtil.toBean(bo, TActivityData.class);
        validEntityBeforeSave(add);
        return save(add);
    }

    @Override
    public Boolean updateByEditBo(TActivityDataEditBo bo) {
        TActivityData update = BeanUtil.toBean(bo, TActivityData.class);
        validEntityBeforeSave(update);
        return updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(TActivityData entity){
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
