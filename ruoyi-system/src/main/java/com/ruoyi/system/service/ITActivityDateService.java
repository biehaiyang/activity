package com.ruoyi.system.service;

import com.ruoyi.system.domain.TActivityDate;
import com.ruoyi.system.vo.TActivityDateVo;
import com.ruoyi.system.bo.TActivityDateQueryBo;
import com.ruoyi.system.bo.TActivityDateAddBo;
import com.ruoyi.system.bo.TActivityDateEditBo;
import com.ruoyi.common.core.mybatisplus.core.IServicePlus;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 活动时间（分场次）Service接口
 *
 * @author ruoyi
 * @date 2021-09-11
 */
public interface ITActivityDateService extends IServicePlus<TActivityDate> {
	/**
	 * 查询单个
	 * @return
	 */
	TActivityDateVo queryById(Long id);

	/**
	 * 查询列表
	 */
    TableDataInfo<TActivityDateVo> queryPageList(TActivityDateQueryBo bo);

	/**
	 * 查询列表
	 */
	List<TActivityDateVo> queryList(TActivityDateQueryBo bo);

	/**
	 * 根据新增业务对象插入活动时间（分场次）
	 * @param bo 活动时间（分场次）新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(TActivityDateAddBo bo);

	/**
	 * 根据编辑业务对象修改活动时间（分场次）
	 * @param bo 活动时间（分场次）编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(TActivityDateEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
