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
import com.ruoyi.system.bo.TDynamicCommentAddBo;
import com.ruoyi.system.bo.TDynamicCommentQueryBo;
import com.ruoyi.system.bo.TDynamicCommentEditBo;
import com.ruoyi.system.domain.TDynamicComment;
import com.ruoyi.system.mapper.TDynamicCommentMapper;
import com.ruoyi.system.vo.TDynamicCommentVo;
import com.ruoyi.system.service.ITDynamicCommentService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 动态评论Service业务层处理
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Service
public class TDynamicCommentServiceImpl extends ServicePlusImpl<TDynamicCommentMapper, TDynamicComment> implements ITDynamicCommentService {

    @Override
    public TDynamicCommentVo queryById(Integer id){
        return getVoById(id, TDynamicCommentVo.class);
    }

    @Override
    public TableDataInfo<TDynamicCommentVo> queryPageList(TDynamicCommentQueryBo bo) {
        PagePlus<TDynamicComment, TDynamicCommentVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), TDynamicCommentVo.class);
        return PageUtils.buildDataInfo(result);
    }

    @Override
    public List<TDynamicCommentVo> queryList(TDynamicCommentQueryBo bo) {
        return listVo(buildQueryWrapper(bo), TDynamicCommentVo.class);
    }

    private LambdaQueryWrapper<TDynamicComment> buildQueryWrapper(TDynamicCommentQueryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TDynamicComment> lqw = Wrappers.lambdaQuery();
        lqw.eq(StrUtil.isNotBlank(bo.getComment()), TDynamicComment::getComment, bo.getComment());
        lqw.eq(bo.getRId() != null, TDynamicComment::getRId, bo.getRId());
        lqw.eq(bo.getPId() != null, TDynamicComment::getPId, bo.getPId());
        lqw.eq(bo.getUserId() != null, TDynamicComment::getUserId, bo.getUserId());
        lqw.eq(bo.getDynamicId() != null, TDynamicComment::getDynamicId, bo.getDynamicId());
        lqw.eq(bo.getShowFlag() != null, TDynamicComment::getShowFlag, bo.getShowFlag());
        lqw.eq(bo.getRepliedUserId() != null, TDynamicComment::getRepliedUserId, bo.getRepliedUserId());
        return lqw;
    }

    @Override
    public Boolean insertByAddBo(TDynamicCommentAddBo bo) {
        TDynamicComment add = BeanUtil.toBean(bo, TDynamicComment.class);
        validEntityBeforeSave(add);
        return save(add);
    }

    @Override
    public Boolean updateByEditBo(TDynamicCommentEditBo bo) {
        TDynamicComment update = BeanUtil.toBean(bo, TDynamicComment.class);
        validEntityBeforeSave(update);
        return updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(TDynamicComment entity){
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
