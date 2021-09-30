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
import com.ruoyi.system.bo.TAuditAddBo;
import com.ruoyi.system.bo.TAuditQueryBo;
import com.ruoyi.system.bo.TAuditEditBo;
import com.ruoyi.system.domain.TAudit;
import com.ruoyi.system.mapper.TAuditMapper;
import com.ruoyi.system.vo.TAuditVo;
import com.ruoyi.system.service.ITAuditService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 用户审核Service业务层处理
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Service
public class TAuditServiceImpl extends ServicePlusImpl<TAuditMapper, TAudit> implements ITAuditService {

    @Override
    public TAuditVo queryById(Long id){
        return getVoById(id, TAuditVo.class);
    }

    @Override
    public TableDataInfo<TAuditVo> queryPageList(TAuditQueryBo bo) {
        PagePlus<TAudit, TAuditVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), TAuditVo.class);
        return PageUtils.buildDataInfo(result);
    }

    @Override
    public List<TAuditVo> queryList(TAuditQueryBo bo) {
        return listVo(buildQueryWrapper(bo), TAuditVo.class);
    }

    private LambdaQueryWrapper<TAudit> buildQueryWrapper(TAuditQueryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TAudit> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getUserId() != null, TAudit::getUserId, bo.getUserId());
        lqw.eq(StrUtil.isNotBlank(bo.getCardFront()), TAudit::getCardFront, bo.getCardFront());
        lqw.eq(StrUtil.isNotBlank(bo.getCardBack()), TAudit::getCardBack, bo.getCardBack());
        lqw.eq(StrUtil.isNotBlank(bo.getBusinessImg()), TAudit::getBusinessImg, bo.getBusinessImg());
        lqw.eq(StrUtil.isNotBlank(bo.getType()), TAudit::getType, bo.getType());
        lqw.eq(StrUtil.isNotBlank(bo.getStatus()), TAudit::getStatus, bo.getStatus());
        return lqw;
    }

    @Override
    public Boolean insertByAddBo(TAuditAddBo bo) {
        TAudit add = BeanUtil.toBean(bo, TAudit.class);
        validEntityBeforeSave(add);
        return save(add);
    }

    @Override
    public Boolean updateByEditBo(TAuditEditBo bo) {
        TAudit update = BeanUtil.toBean(bo, TAudit.class);
        validEntityBeforeSave(update);
        return updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(TAudit entity){
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
