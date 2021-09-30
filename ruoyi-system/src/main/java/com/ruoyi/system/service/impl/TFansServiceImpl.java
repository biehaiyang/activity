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
import com.ruoyi.system.bo.TFansAddBo;
import com.ruoyi.system.bo.TFansQueryBo;
import com.ruoyi.system.bo.TFansEditBo;
import com.ruoyi.system.domain.TFans;
import com.ruoyi.system.mapper.TFansMapper;
import com.ruoyi.system.vo.TFansVo;
import com.ruoyi.system.service.ITFansService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 用户关注Service业务层处理
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Service
public class TFansServiceImpl extends ServicePlusImpl<TFansMapper, TFans> implements ITFansService {

    @Override
    public TFansVo queryById(Long id){
        return getVoById(id, TFansVo.class);
    }

    @Override
    public TableDataInfo<TFansVo> queryPageList(TFansQueryBo bo) {
        PagePlus<TFans, TFansVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), TFansVo.class);
        return PageUtils.buildDataInfo(result);
    }

    @Override
    public List<TFansVo> queryList(TFansQueryBo bo) {
        return listVo(buildQueryWrapper(bo), TFansVo.class);
    }

    private LambdaQueryWrapper<TFans> buildQueryWrapper(TFansQueryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TFans> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getUserId() != null, TFans::getUserId, bo.getUserId());
        lqw.eq(bo.getFocusId() != null, TFans::getFocusId, bo.getFocusId());
        return lqw;
    }

    @Override
    public Boolean insertByAddBo(TFansAddBo bo) {
        TFans add = BeanUtil.toBean(bo, TFans.class);
        validEntityBeforeSave(add);
        return save(add);
    }

    @Override
    public Boolean updateByEditBo(TFansEditBo bo) {
        TFans update = BeanUtil.toBean(bo, TFans.class);
        validEntityBeforeSave(update);
        return updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(TFans entity){
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
