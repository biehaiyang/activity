package com.ruoyi.system.service;

import com.ruoyi.system.domain.TActivityData;
import com.ruoyi.system.vo.TActivityDataVo;
import com.ruoyi.system.bo.TActivityDataQueryBo;
import com.ruoyi.system.bo.TActivityDataAddBo;
import com.ruoyi.system.bo.TActivityDataEditBo;
import com.ruoyi.common.core.mybatisplus.core.IServicePlus;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 活动数据Service接口
 *
 * @author ruoyi
 * @date 2021-09-11
 */
public interface ITActivityDataService extends IServicePlus<TActivityData> {
	/**
	 * 查询单个
	 * @return
	 */
	TActivityDataVo queryById(Long id);

	/**
	 * 查询列表
	 */
    TableDataInfo<TActivityDataVo> queryPageList(TActivityDataQueryBo bo);

	/**
	 * 查询列表
	 */
	List<TActivityDataVo> queryList(TActivityDataQueryBo bo);

	/**
	 * 根据新增业务对象插入活动数据
	 * @param bo 活动数据新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(TActivityDataAddBo bo);

	/**
	 * 根据编辑业务对象修改活动数据
	 * @param bo 活动数据编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(TActivityDataEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
