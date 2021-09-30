package com.ruoyi.system.service;

import com.ruoyi.system.domain.TActivitySpec;
import com.ruoyi.system.vo.TActivitySpecVo;
import com.ruoyi.system.bo.TActivitySpecQueryBo;
import com.ruoyi.system.bo.TActivitySpecAddBo;
import com.ruoyi.system.bo.TActivitySpecEditBo;
import com.ruoyi.common.core.mybatisplus.core.IServicePlus;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 活动规格Service接口
 *
 * @author ruoyi
 * @date 2021-09-11
 */
public interface ITActivitySpecService extends IServicePlus<TActivitySpec> {
	/**
	 * 查询单个
	 * @return
	 */
	TActivitySpecVo queryById(Long id);

	/**
	 * 查询列表
	 */
    TableDataInfo<TActivitySpecVo> queryPageList(TActivitySpecQueryBo bo);

	/**
	 * 查询列表
	 */
	List<TActivitySpecVo> queryList(TActivitySpecQueryBo bo);

	/**
	 * 根据新增业务对象插入活动规格
	 * @param bo 活动规格新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(TActivitySpecAddBo bo);

	/**
	 * 根据编辑业务对象修改活动规格
	 * @param bo 活动规格编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(TActivitySpecEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
