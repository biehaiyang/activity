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
import com.ruoyi.system.bo.TAccountAddBo;
import com.ruoyi.system.bo.TAccountQueryBo;
import com.ruoyi.system.bo.TAccountEditBo;
import com.ruoyi.system.domain.TAccount;
import com.ruoyi.system.mapper.TAccountMapper;
import com.ruoyi.system.vo.TAccountVo;
import com.ruoyi.system.service.ITAccountService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 账户详情Service业务层处理
 *
 * @author ruoyi
 * @date 2021-10-10
 */
@Service
public class TAccountServiceImpl extends ServicePlusImpl<TAccountMapper, TAccount> implements ITAccountService {

    @Override
    public TAccountVo queryById(Long id){
        return getVoById(id, TAccountVo.class);
    }

    @Override
    public TableDataInfo<TAccountVo> queryPageList(TAccountQueryBo bo) {
        PagePlus<TAccount, TAccountVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), TAccountVo.class);
        return PageUtils.buildDataInfo(result);
    }

    @Override
    public List<TAccountVo> queryList(TAccountQueryBo bo) {
        return listVo(buildQueryWrapper(bo), TAccountVo.class);
    }

    private LambdaQueryWrapper<TAccount> buildQueryWrapper(TAccountQueryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TAccount> lqw = Wrappers.lambdaQuery();
        lqw.eq(StrUtil.isNotBlank(bo.getType()), TAccount::getType, bo.getType());
        lqw.eq(bo.getMoney() != null, TAccount::getMoney, bo.getMoney());
        lqw.eq(bo.getUserId() != null, TAccount::getUserId, bo.getUserId());
        lqw.like(StrUtil.isNotBlank(bo.getUserName()), TAccount::getUserName, bo.getUserName());
        return lqw;
    }

    @Override
    public Boolean insertByAddBo(TAccountAddBo bo) {
        TAccount add = BeanUtil.toBean(bo, TAccount.class);
        validEntityBeforeSave(add);
        return save(add);
    }

    @Override
    public Boolean updateByEditBo(TAccountEditBo bo) {
        TAccount update = BeanUtil.toBean(bo, TAccount.class);
        validEntityBeforeSave(update);
        return updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(TAccount entity){
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
