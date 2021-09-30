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
import com.ruoyi.system.bo.TCenterAddBo;
import com.ruoyi.system.bo.TCenterQueryBo;
import com.ruoyi.system.bo.TCenterEditBo;
import com.ruoyi.system.domain.TCenter;
import com.ruoyi.system.mapper.TCenterMapper;
import com.ruoyi.system.vo.TCenterVo;
import com.ruoyi.system.service.ITCenterService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 客服Service业务层处理
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Service
public class TCenterServiceImpl extends ServicePlusImpl<TCenterMapper, TCenter> implements ITCenterService {

    @Override
    public TCenterVo queryById(Long id){
        return getVoById(id, TCenterVo.class);
    }

    @Override
    public TableDataInfo<TCenterVo> queryPageList(TCenterQueryBo bo) {
        PagePlus<TCenter, TCenterVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), TCenterVo.class);
        return PageUtils.buildDataInfo(result);
    }

    @Override
    public List<TCenterVo> queryList(TCenterQueryBo bo) {
        return listVo(buildQueryWrapper(bo), TCenterVo.class);
    }

    private LambdaQueryWrapper<TCenter> buildQueryWrapper(TCenterQueryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TCenter> lqw = Wrappers.lambdaQuery();
        lqw.eq(StrUtil.isNotBlank(bo.getPhone()), TCenter::getPhone, bo.getPhone());
        lqw.eq(StrUtil.isNotBlank(bo.getWxcode()), TCenter::getWxcode, bo.getWxcode());
        lqw.eq(StrUtil.isNotBlank(bo.getImgUrl()), TCenter::getImgUrl, bo.getImgUrl());
        return lqw;
    }

    @Override
    public Boolean insertByAddBo(TCenterAddBo bo) {
        TCenter add = BeanUtil.toBean(bo, TCenter.class);
        validEntityBeforeSave(add);
        return save(add);
    }

    @Override
    public Boolean updateByEditBo(TCenterEditBo bo) {
        TCenter update = BeanUtil.toBean(bo, TCenter.class);
        validEntityBeforeSave(update);
        return updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(TCenter entity){
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
