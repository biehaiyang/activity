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
import com.ruoyi.system.bo.TMessageAddBo;
import com.ruoyi.system.bo.TMessageQueryBo;
import com.ruoyi.system.bo.TMessageEditBo;
import com.ruoyi.system.domain.TMessage;
import com.ruoyi.system.mapper.TMessageMapper;
import com.ruoyi.system.vo.TMessageVo;
import com.ruoyi.system.service.ITMessageService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 消息通知
Service业务层处理
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Service
public class TMessageServiceImpl extends ServicePlusImpl<TMessageMapper, TMessage> implements ITMessageService {

    @Override
    public TMessageVo queryById(Long id){
        return getVoById(id, TMessageVo.class);
    }

    @Override
    public TableDataInfo<TMessageVo> queryPageList(TMessageQueryBo bo) {
        PagePlus<TMessage, TMessageVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), TMessageVo.class);
        return PageUtils.buildDataInfo(result);
    }

    @Override
    public List<TMessageVo> queryList(TMessageQueryBo bo) {
        return listVo(buildQueryWrapper(bo), TMessageVo.class);
    }

    private LambdaQueryWrapper<TMessage> buildQueryWrapper(TMessageQueryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TMessage> lqw = Wrappers.lambdaQuery();
        lqw.eq(StrUtil.isNotBlank(bo.getTitle()), TMessage::getTitle, bo.getTitle());
        lqw.eq(StrUtil.isNotBlank(bo.getContent()), TMessage::getContent, bo.getContent());
        lqw.eq(StrUtil.isNotBlank(bo.getIsRead()), TMessage::getIsRead, bo.getIsRead());
        lqw.eq(bo.getUserId() != null, TMessage::getUserId, bo.getUserId());
        return lqw;
    }

    @Override
    public Boolean insertByAddBo(TMessageAddBo bo) {
        TMessage add = BeanUtil.toBean(bo, TMessage.class);
        validEntityBeforeSave(add);
        return save(add);
    }

    @Override
    public Boolean updateByEditBo(TMessageEditBo bo) {
        TMessage update = BeanUtil.toBean(bo, TMessage.class);
        validEntityBeforeSave(update);
        return updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(TMessage entity){
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
