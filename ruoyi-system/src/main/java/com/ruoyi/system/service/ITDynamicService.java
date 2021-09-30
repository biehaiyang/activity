package com.ruoyi.system.service;

import com.ruoyi.system.domain.TDynamic;
import com.ruoyi.system.vo.TDynamicVo;
import com.ruoyi.system.bo.TDynamicQueryBo;
import com.ruoyi.system.bo.TDynamicAddBo;
import com.ruoyi.system.bo.TDynamicEditBo;
import com.ruoyi.common.core.mybatisplus.core.IServicePlus;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 动态Service接口
 *
 * @author ruoyi
 * @date 2021-09-11
 */
public interface ITDynamicService extends IServicePlus<TDynamic> {
	/**
	 * 查询单个
	 * @return
	 */
	TDynamicVo queryById(Long id);

	/**
	 * 查询列表
	 */
    TableDataInfo<TDynamicVo> queryPageList(TDynamicQueryBo bo);

	/**
	 * 查询列表
	 */
	List<TDynamicVo> queryList(TDynamicQueryBo bo);

	/**
	 * 根据新增业务对象插入动态
	 * @param bo 动态新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(TDynamicAddBo bo);

	/**
	 * 根据编辑业务对象修改动态
	 * @param bo 动态编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(TDynamicEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
