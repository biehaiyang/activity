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
import com.ruoyi.system.bo.TActivityCommentAddBo;
import com.ruoyi.system.bo.TActivityCommentQueryBo;
import com.ruoyi.system.bo.TActivityCommentEditBo;
import com.ruoyi.system.domain.TActivityComment;
import com.ruoyi.system.mapper.TActivityCommentMapper;
import com.ruoyi.system.vo.TActivityCommentVo;
import com.ruoyi.system.service.ITActivityCommentService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 活动评论Service业务层处理
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Service
public class TActivityCommentServiceImpl extends ServicePlusImpl<TActivityCommentMapper, TActivityComment> implements ITActivityCommentService {

    @Override
    public TActivityCommentVo queryById(Integer id){
        return getVoById(id, TActivityCommentVo.class);
    }

    @Override
    public TableDataInfo<TActivityCommentVo> queryPageList(TActivityCommentQueryBo bo) {
        PagePlus<TActivityComment, TActivityCommentVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), TActivityCommentVo.class);
        return PageUtils.buildDataInfo(result);
    }

    @Override
    public List<TActivityCommentVo> queryList(TActivityCommentQueryBo bo) {
        return listVo(buildQueryWrapper(bo), TActivityCommentVo.class);
    }

    private LambdaQueryWrapper<TActivityComment> buildQueryWrapper(TActivityCommentQueryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TActivityComment> lqw = Wrappers.lambdaQuery();
        lqw.eq(StrUtil.isNotBlank(bo.getComment()), TActivityComment::getComment, bo.getComment());
        lqw.eq(bo.getStarLv() != null, TActivityComment::getStarLv, bo.getStarLv());
        lqw.eq(bo.getRId() != null, TActivityComment::getRId, bo.getRId());
        lqw.eq(bo.getPId() != null, TActivityComment::getPId, bo.getPId());
        lqw.eq(bo.getUserId() != null, TActivityComment::getUserId, bo.getUserId());
        lqw.eq(bo.getActivityId() != null, TActivityComment::getActivityId, bo.getActivityId());
        lqw.eq(bo.getShowFlag() != null, TActivityComment::getShowFlag, bo.getShowFlag());
        lqw.eq(bo.getRepliedId() != null, TActivityComment::getRepliedId, bo.getRepliedId());
        return lqw;
    }

    @Override
    public Boolean insertByAddBo(TActivityCommentAddBo bo) {
        TActivityComment add = BeanUtil.toBean(bo, TActivityComment.class);
        validEntityBeforeSave(add);
        return save(add);
    }

    @Override
    public Boolean updateByEditBo(TActivityCommentEditBo bo) {
        TActivityComment update = BeanUtil.toBean(bo, TActivityComment.class);
        validEntityBeforeSave(update);
        return updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(TActivityComment entity){
        //TODO 做一些数据校验,如唯一约束
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Integer> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return removeByIds(ids);
    }
}
