package com.ruoyi.system.service;

import com.ruoyi.system.domain.TCenter;
import com.ruoyi.system.vo.TCenterVo;
import com.ruoyi.system.bo.TCenterQueryBo;
import com.ruoyi.system.bo.TCenterAddBo;
import com.ruoyi.system.bo.TCenterEditBo;
import com.ruoyi.common.core.mybatisplus.core.IServicePlus;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 客服Service接口
 *
 * @author ruoyi
 * @date 2021-09-11
 */
public interface ITCenterService extends IServicePlus<TCenter> {
	/**
	 * 查询单个
	 * @return
	 */
	TCenterVo queryById(Long id);

	/**
	 * 查询列表
	 */
    TableDataInfo<TCenterVo> queryPageList(TCenterQueryBo bo);

	/**
	 * 查询列表
	 */
	List<TCenterVo> queryList(TCenterQueryBo bo);

	/**
	 * 根据新增业务对象插入客服
	 * @param bo 客服新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(TCenterAddBo bo);

	/**
	 * 根据编辑业务对象修改客服
	 * @param bo 客服编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(TCenterEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
