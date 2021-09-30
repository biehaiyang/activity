package com.ruoyi.system.service;

import com.ruoyi.system.domain.TActivityComment;
import com.ruoyi.system.vo.TActivityCommentVo;
import com.ruoyi.system.bo.TActivityCommentQueryBo;
import com.ruoyi.system.bo.TActivityCommentAddBo;
import com.ruoyi.system.bo.TActivityCommentEditBo;
import com.ruoyi.common.core.mybatisplus.core.IServicePlus;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 活动评论Service接口
 *
 * @author ruoyi
 * @date 2021-09-11
 */
public interface ITActivityCommentService extends IServicePlus<TActivityComment> {
	/**
	 * 查询单个
	 * @return
	 */
	TActivityCommentVo queryById(Integer id);

	/**
	 * 查询列表
	 */
    TableDataInfo<TActivityCommentVo> queryPageList(TActivityCommentQueryBo bo);

	/**
	 * 查询列表
	 */
	List<TActivityCommentVo> queryList(TActivityCommentQueryBo bo);

	/**
	 * 根据新增业务对象插入活动评论
	 * @param bo 活动评论新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(TActivityCommentAddBo bo);

	/**
	 * 根据编辑业务对象修改活动评论
	 * @param bo 活动评论编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(TActivityCommentEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Integer> ids, Boolean isValid);
}
