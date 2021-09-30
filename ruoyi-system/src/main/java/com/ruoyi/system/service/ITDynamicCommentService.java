package com.ruoyi.system.service;

import com.ruoyi.system.domain.TDynamicComment;
import com.ruoyi.system.vo.TDynamicCommentVo;
import com.ruoyi.system.bo.TDynamicCommentQueryBo;
import com.ruoyi.system.bo.TDynamicCommentAddBo;
import com.ruoyi.system.bo.TDynamicCommentEditBo;
import com.ruoyi.common.core.mybatisplus.core.IServicePlus;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 动态评论Service接口
 *
 * @author ruoyi
 * @date 2021-09-11
 */
public interface ITDynamicCommentService extends IServicePlus<TDynamicComment> {
	/**
	 * 查询单个
	 * @return
	 */
	TDynamicCommentVo queryById(Integer id);

	/**
	 * 查询列表
	 */
    TableDataInfo<TDynamicCommentVo> queryPageList(TDynamicCommentQueryBo bo);

	/**
	 * 查询列表
	 */
	List<TDynamicCommentVo> queryList(TDynamicCommentQueryBo bo);

	/**
	 * 根据新增业务对象插入动态评论
	 * @param bo 动态评论新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(TDynamicCommentAddBo bo);

	/**
	 * 根据编辑业务对象修改动态评论
	 * @param bo 动态评论编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(TDynamicCommentEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Integer> ids, Boolean isValid);
}
