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
import com.ruoyi.system.bo.TTypeAddBo;
import com.ruoyi.system.bo.TTypeQueryBo;
import com.ruoyi.system.bo.TTypeEditBo;
import com.ruoyi.system.domain.TType;
import com.ruoyi.system.mapper.TTypeMapper;
import com.ruoyi.system.vo.TTypeVo;
import com.ruoyi.system.service.ITTypeService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 所有分类Service业务层处理
 *
 * @author ruoyi
 * @date 2021-09-12
 */
@Service
public class TTypeServiceImpl extends ServicePlusImpl<TTypeMapper, TType> implements ITTypeService {

    @Override
    public TTypeVo queryById(Long id){
        return getVoById(id, TTypeVo.class);
    }

    @Override
    public TableDataInfo<TTypeVo> queryPageList(TTypeQueryBo bo) {
        PagePlus<TType, TTypeVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), TTypeVo.class);
        return PageUtils.buildDataInfo(result);
    }

    @Override
    public List<TTypeVo> queryList(TTypeQueryBo bo) {
        return listVo(buildQueryWrapper(bo), TTypeVo.class);
    }

    private LambdaQueryWrapper<TType> buildQueryWrapper(TTypeQueryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TType> lqw = Wrappers.lambdaQuery();
        lqw.like(StrUtil.isNotBlank(bo.getTypeName()), TType::getTypeName, bo.getTypeName());
        lqw.eq(StrUtil.isNotBlank(bo.getTypeImg()), TType::getTypeImg, bo.getTypeImg());
        lqw.eq(StrUtil.isNotBlank(bo.getHrefUrl()), TType::getHrefUrl, bo.getHrefUrl());
        lqw.eq(bo.getSort() != null, TType::getSort, bo.getSort());
        return lqw;
    }

    @Override
    public Boolean insertByAddBo(TTypeAddBo bo) {
        TType add = BeanUtil.toBean(bo, TType.class);
        validEntityBeforeSave(add);
        return save(add);
    }

    @Override
    public Boolean updateByEditBo(TTypeEditBo bo) {
        TType update = BeanUtil.toBean(bo, TType.class);
        validEntityBeforeSave(update);
        return updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(TType entity){
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
