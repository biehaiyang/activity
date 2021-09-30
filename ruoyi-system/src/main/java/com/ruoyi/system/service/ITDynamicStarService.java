package com.ruoyi.system.service;

import com.ruoyi.system.domain.TDynamicStar;
import com.ruoyi.system.vo.TDynamicStarVo;
import com.ruoyi.system.bo.TDynamicStarQueryBo;
import com.ruoyi.system.bo.TDynamicStarAddBo;
import com.ruoyi.system.bo.TDynamicStarEditBo;
import com.ruoyi.common.core.mybatisplus.core.IServicePlus;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 动态点赞Service接口
 *
 * @author ruoyi
 * @date 2021-09-11
 */
public interface ITDynamicStarService extends IServicePlus<TDynamicStar> {
	/**
	 * 查询单个
	 * @return
	 */
	TDynamicStarVo queryById(Long id);

	/**
	 * 查询列表
	 */
    TableDataInfo<TDynamicStarVo> queryPageList(TDynamicStarQueryBo bo);

	/**
	 * 查询列表
	 */
	List<TDynamicStarVo> queryList(TDynamicStarQueryBo bo);

	/**
	 * 根据新增业务对象插入动态点赞
	 * @param bo 动态点赞新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(TDynamicStarAddBo bo);

	/**
	 * 根据编辑业务对象修改动态点赞
	 * @param bo 动态点赞编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(TDynamicStarEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
